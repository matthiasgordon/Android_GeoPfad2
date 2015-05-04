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
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**Class implemented by: Marc Niedermeier 
 * MapFragment is one part of the FragentActivity ActivityMain; 
 * shows route in GoogleMap of entire GeoPfad with Marker for each location;
 * can be called with parameter to show single location highlighted;
 * when called without parameter it shows all locations;
 * has spinner to change the selection of shown markers */

public class MapFragment extends Fragment {
	
	private MapFragmentData mData;
	private MapFragmentGUI mGUI;
	private MapFragmentApplicationLogic mApplicationLogic;
	private String mLocationName;
	private boolean mIsFromIntent;
	
	/** two constructors when string is passed it is saved in mLocationName
	 * boolean mIsFromIntent is set depending on which consturctor is used
	 * mIsFromIntent is used to decide how the MapFragment is styled therefore
	 * it is passed to several methods*/
	
	public MapFragment(){
		mIsFromIntent = false;
	}
	
	public MapFragment (String intentData) {
		mLocationName = intentData;
		if(mLocationName != null)
		mIsFromIntent = true;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.map_fragment, container, false);
		initData();
		initGUI(mView);
		initApplicationLogic();
		initEventToListenerMapping();
		return mView;
	}	

	/** onResume refreshs Map every time when user gets to the MapFragment by pressing
	 * the back button of the device*/
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		initGUI(getView());
	}
	
	private void initData () {
		mData = new MapFragmentData(this);
	}
	
	/** after providing and data the map is styled in initGUI and the spinner 
	 * selection list is created */

	private void initGUI (View view) {
		mGUI = new MapFragmentGUI(this, view, mLocationName, mIsFromIntent);
		mGUI.styleMap(mData.getRouteCoordinates(), mData.getOrte(), 0, 
				mData.getVisitStatus(), mIsFromIntent);
		mGUI.setSpinnerList(mIsFromIntent);
	}
	
	private void initApplicationLogic () {
		mApplicationLogic = new MapFragmentApplicationLogic(mData, mGUI);
	}
	
	private void initEventToListenerMapping () {
		new MapFragmentEventToListener(mGUI, mApplicationLogic, mIsFromIntent);
	}
}