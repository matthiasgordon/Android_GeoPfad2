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

import de.fhdw.bfwi412a.geopfad.R;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ListFragmentApplicationLogic {

	public final int ADD_LOCATION = 100;
	
	private ListFragment mFrag;
	private ListFragmentGUI mGUI;
	private ListFragmentData mData;
	private IntentBuilder mIntentBuilder;
	
	public ListFragmentApplicationLogic(ListFragment frag, ListFragmentData data, ListFragmentGUI gui) {
		mFrag = frag;
		mData = data;
		mGUI = gui;
		mIntentBuilder = new IntentBuilder();
	}
	
	/**The method combines the detail view of a location with its id.*/
	public void showDetailView(View view){
		TextView txtOrtID = (TextView)view.findViewWithTag(mFrag.getResources().getString(R.string.tag_listview_ort_id));
		int mOrtID = Integer.parseInt(txtOrtID.getText().toString())-1;
		
		Intent intent = mIntentBuilder.buildIntentForActivityLocations(mData.getActivity(), mData.getOrte(), mOrtID);
		mData.getActivity().startActivity(intent);	
	}
	
	/**This method added a row to the existing list of the listview,
	 *  when the user creates a new location.*/
	public void addLocation() {
		Intent intent = new Intent(mFrag.getActivity(), ActivityAddLocation.class);
		intent.putExtra(mFrag.getResources().getString(R.string.intent_extras_list_length), String.valueOf(mGUI.getmListLength()+1));
		mFrag.startActivityForResult(intent, ADD_LOCATION);
	}
	
}
