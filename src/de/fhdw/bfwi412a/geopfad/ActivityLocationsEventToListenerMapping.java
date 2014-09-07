package de.fhdw.bfwi412a.geopfad;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/** Class implemented by: Johanna Korten*/

public class ActivityLocationsEventToListenerMapping implements OnClickListener, LocationListener {

	private ActivityLocationsGUI mGUI;
	private ActivityLocationsApplicationLogic mAppLogic;
	
	public ActivityLocationsEventToListenerMapping(ActivityLocationsGUI gui, ActivityLocationsApplicationLogic appLogic) {
		mGUI = gui;
		mAppLogic = appLogic;
		mGUI.getBtnNavigation().setOnClickListener(this);
		mGUI.getBtnVisit().setOnClickListener(this);
		mGUI.getBtnShowOnMap().setOnClickListener(this);
		mAppLogic.getLocationManager().requestLocationUpdates(mAppLogic.getmProvider(), 400, 1, this);
	}
	
	/**executes methods if the buttons or checkbox is clicked by the user
	 * */
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btnNavigation:
			mAppLogic.navigateToLocation();
			break;
		case R.id.btnVisit:
			mAppLogic.changeVisitStatus();
			break;
		case R.id.btnShowOnMap:
			mAppLogic.showOnMap();
			break;
		}
	}

	@Override
	public void onLocationChanged(Location location) {
		mAppLogic.setDistance();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

}
