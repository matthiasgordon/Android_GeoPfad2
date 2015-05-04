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

import android.content.Intent;

import com.google.android.gms.maps.model.Marker;

/** Class implemented by: Marc Niedermeier
 * serves all the logic that is needed for the MapFragment*/

public class MapFragmentApplicationLogic {
	
	private MapFragmentData mData;
	private MapFragmentGUI mGUI;
	private IntentBuilder mIntentBuilder;
	
	public MapFragmentApplicationLogic(MapFragmentData data, MapFragmentGUI gui) {
		mData = data;
		mGUI = gui;
		mIntentBuilder = new IntentBuilder();
	}
	
	/** changes the markers depending on which id is given 
	 * (see MapFragemenEventToListenerMapping)
	 * @param id of which item was selected in the spinner*/
	
	public void changeMarkers(int id){
		if(id != -1)
			mGUI.styleMap(mData.getRouteCoordinates(), mData.getOrte(), id, 
					mData.getVisitStatus(),false);
		else
			mGUI.styleMap(mData.getRouteCoordinates(), mData.getOrte(), id, 
					mData.getVisitStatus(),true);
	}
	
	/** Method that starts ActivityLocations when a markerinfowindow was clicked
	 * with intent containing the data about the location selected
	 * @param mMarker marker that was licked on*/
	
	public void onMarkerClicked(Marker mMarker){
		int i=0;
		for (Ort curOrt : mData.getOrte()){
			if(curOrt.getName().equals(mMarker.getTitle())){
				Intent intent = mIntentBuilder.buildIntentForActivityLocations(mData.getActivity(), mData.getOrte(), i);
				mData.getActivity().startActivity(intent);
			}
			i++;
		}
	}
}