package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.model.Marker;

/** MapFragmentEventToListener decides which methods have to be called after
 * events done by the user
 * OnItemSelectedListener for the spinner-menu
 * OnInfoWindowClickListener for the InfoWindow of the Markers on the map*/

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
	
	/** Method thats says have onclick on spinner menu has to behave normal behavior 
	 * or behaviour when one location has to be highlighted and name is added to options-menu
	 * if mIsFromIntent = false normal behaviour
	 * if mIsFromIntent = true but not = 0 than behave as your one lower in options-menu
	 * if mIsFromIntent = true and = 0 than highlight the lonely location
	 * @param arg2 position of the spinner's option-menu that is clicked
	 * */
	
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
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}
	/** Method that is called if a marker's InfoWindow is clicked
	 * @param arg0 id of the clicked marker*/

	@Override
	public void onInfoWindowClick(Marker arg0) {
		mAppLogic.onMarkerClicked(arg0);
	}
}