package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;

import com.google.android.gms.maps.model.Marker;

public class MapFragmentApplicationLogic {
	
	MapFragmentData mData;
	MapFragmentGUI mGUI;
	private IntentBuilder mIntentBuilder;
	
	public MapFragmentApplicationLogic(MapFragmentData data, MapFragmentGUI gui) {
		mData = data;
		mGUI = gui;
		mIntentBuilder = new IntentBuilder();
	}
	
	public void changeMarkers(int id){
		if(id != -1)
			mGUI.styleMap(mData.getRouteCoordinates(), mData.getOrte(), id, mData.getVisitStatus(),false);
		else
			mGUI.styleMap(mData.getRouteCoordinates(), mData.getOrte(), id, mData.getVisitStatus(),true);
	}
	
	public void onMarkerClicked(Marker mMarker){
		int i=0;
		for (Ort curOrt : mData.getOrte()){
			if(curOrt.getName().equals(mMarker.getTitle())){
				Intent intent = mIntentBuilder.buildIntentForActivityLocations(mData.getActivity(), mData.getOrte(), i);
//				Intent intent = new Intent(mData.getActivity(), ActivityLocations.class);
//				intent.putExtra("Ortname", curOrt.getName());
//				intent.putExtra("imageUrl", curOrt.getImgUrl());
//				intent.putExtra("imageUrl2", curOrt.getImgUrl2());
//				intent.putExtra("imageUrl3", curOrt.getImgUrl3());
//				intent.putExtra("about", curOrt.getAbout());
//				intent.putExtra("latitude", curOrt.getLat());
//				intent.putExtra("longitude", curOrt.getLng());
//				intent.putExtra("visitKey", curOrt.getVisitKey());
				
				mData.getActivity().startActivity(intent);
			}
			i++;
		}
	}
}