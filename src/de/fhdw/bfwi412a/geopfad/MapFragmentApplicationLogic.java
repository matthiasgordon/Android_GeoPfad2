package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;

import com.google.android.gms.maps.model.Marker;

public class MapFragmentApplicationLogic {
	
	private MapFragmentData mData;
	private MapFragmentGUI mGUI;
	private IntentBuilder mIntentBuilder;
	
	public MapFragmentApplicationLogic(MapFragmentData data, MapFragmentGUI gui) {
		mData = data;
		mGUI = gui;
		mIntentBuilder = new IntentBuilder();
	}
	
	public void changeMarkers(int id){
		if(id != -1)
			mGUI.styleMap(mData.getRouteCoordinates(), mData.getOrte(), id, 
					mData.getVisitStatus(),false);
		else
			mGUI.styleMap(mData.getRouteCoordinates(), mData.getOrte(), id, 
					mData.getVisitStatus(),true);
	}
	
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