package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.Marker;

public class MapFragmentEventToListener implements OnItemSelectedListener, OnInfoWindowClickListener{

	private MapFragmentGUI mGUI;
	private MapFragmentApplicationLogic mAppLogic;
	private boolean mIsFromIntent;
	
	public MapFragmentEventToListener(MapFragmentGUI gui, MapFragmentApplicationLogic appLogic,
			boolean isFromIntent){
	
		mGUI = gui;
		mAppLogic = appLogic;
		mIsFromIntent = isFromIntent;
		mGUI.getSpinner().setOnItemSelectedListener(this);
		mGUI.getMap().setOnInfoWindowClickListener(this);
	}
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		if(mIsFromIntent == false)
			mAppLogic.changeMarkers(arg2);
		else{
			if(mIsFromIntent && arg2 != 0){
				arg2 = arg2 -1;
				mAppLogic.changeMarkers(arg2);
			}
			else
				mAppLogic.changeMarkers(-1);
		}
//		if(arg2 == 0 && !mIsFromIntent)
//		arg2 = arg2 +1;
//		mAppLogic.changeMarkers(arg2);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}

	@Override
	public void onInfoWindowClick(Marker arg0) {
		mAppLogic.onMarkerClicked(arg0);
	}
}
