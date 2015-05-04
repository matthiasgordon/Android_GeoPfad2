/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	Böttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - AäR hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation verändert werden.
**
**	Ohne ausdrückliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zugänglich gemacht werden.
**
**	Eine Vervielfältigung und Veröffentlichung des Quellcodes ohne ausdrückliche
**	Genehmigung - auch in Auszügen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.AdapterView.OnItemClickListener;

/**This class manages the onItemClick events of the ListView rows 
 * and calls the appropriate method when an event occurs.*/
public class ListFragmentEventToListenerMapping implements OnItemClickListener, SearchView.OnQueryTextListener {
	
	private ListFragment mFrag;
	private ListFragmentData mData;
	private ListFragmentGUI mGUI;
	private ListFragmentApplicationLogic mAppLogic;
	
	public ListFragmentEventToListenerMapping(ListFragment frag, ListFragmentData data, ListFragmentGUI gui, ListFragmentApplicationLogic applogic) {
		mFrag = frag;
		mAppLogic = applogic;
		mData = data;
		mGUI = gui;
		mGUI.getListOrte().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		mAppLogic.showDetailView(view);
	}

	/**Method implemented by: Johanna Korten
	 *filters listview (build up a new filtered listview)
	 *builds one list with all locations and one empty list
	 *if the key input by the user equals to an existing location
	 *the empty arraylist will be filled with the filtered locations
	 *to ignore the case-sensitive all strings will be to upper case
	 * */
	@Override
	public boolean onQueryTextChange(String mEntry) {
		List <Ort> Orte = mData.getOrte();
		List <Ort> shownOrte = new ArrayList <Ort>();
		for(Ort currOrt : Orte){
			if(currOrt.getName().toUpperCase(Locale.GERMAN)
					.contains(mEntry.toUpperCase(Locale.GERMAN))){
				shownOrte.add(currOrt);
			}		
		}
			mGUI.fillListView(mFrag.getView(), shownOrte);
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		return false;
	}
}
