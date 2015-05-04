/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	B�ttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - A�R hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation ver�ndert werden.
**
**	Ohne ausdr�ckliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zug�nglich gemacht werden.
**
**	Eine Vervielf�ltigung und Ver�ffentlichung des Quellcodes ohne ausdr�ckliche
**	Genehmigung - auch in Ausz�gen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;

import java.util.List;

import android.support.v4.app.FragmentActivity;

/**In the class an object "List <location>" mOrte is generated. 
 * This object receives the data read out of the Orte_DOM_Parser.*/
public class ListFragmentData {
	
	private List<Ort> mOrte;
	private FragmentActivity mActivity;
	
	public ListFragmentData(ListFragment mFrag) {
		
		mOrte = Orte_DOM_Parser.getOrteFromFile(mFrag.getActivity());
		mActivity = mFrag.getActivity();
	}

	public List<Ort> getOrte() {
		return mOrte;
	}

	public FragmentActivity getActivity() {
		return mActivity;
	}	
}
