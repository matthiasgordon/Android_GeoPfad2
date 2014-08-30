package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.Marker;

public class MapFragmentEventToListener implements OnItemSelectedListener, OnInfoWindowClickListener{

	private MapFragmentGUI mGUI;
	private MapFragmentApplicationLogic mAppLogic;
	
	public MapFragmentEventToListener(MapFragmentGUI gui, MapFragmentApplicationLogic appLogic){
	
		mGUI = gui;
		mAppLogic = appLogic;
		mGUI.getSpinner().setOnItemSelectedListener(this);
		mGUI.getMap().setOnInfoWindowClickListener(this);
	}
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		mAppLogic.changeMarkers(arg2);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		mAppLogic.changeMarkers(0);
	}

	@Override
	public void onInfoWindowClick(Marker arg0) {
		mAppLogic.onMarkerClicked(arg0);
	}
}
