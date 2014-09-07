package de.fhdw.bfwi412a.geopfad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.LocationManager;
import android.net.Uri;

/** Class implemented by: Johanna Korten*
 * this class is responsible for logic of activity locations/

public class ActivityLocationsApplicationLogic {
	
	private ActivityLocationsData mData;
	private ActivityLocationsGUI mGUI;
	private DistanceCalculator mDistCalc;
	ActivityLocations mActivity;
	private LocationManager mLocationManager;
	private String mProvider;
	Criteria mCriteria;
	

	public ActivityLocationsApplicationLogic(ActivityLocations act, ActivityLocationsData data, ActivityLocationsGUI gui) {
		mData = data;
		mGUI = gui;
		mDistCalc = new DistanceCalculator();
		mActivity = act;
		mLocationManager = (LocationManager) act.getSystemService(Context.LOCATION_SERVICE);
		mCriteria = new Criteria();
		mProvider = mLocationManager.getBestProvider(mCriteria, false);
		if(isProviderEnabled() == true) {
			setDistance();
			}
	}
	
	public LocationManager getLocationManager() {
		return mLocationManager;
	}
	
	public String getmProvider() {
		return mProvider;
	}

	/**loads the latitudes and longitudes from the current location to navigate
	 * starts google maps*/
	
	public void navigateToLocation(){
		double mLat = mData.getLatitude();
		double mLng = mData.getLongitude();
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				 Uri.parse("google.navigation:q=" + mLat + "," + mLng));
		mActivity.startActivity(intent);
	}
	
	/**saves data into sharedpreferences to stay if application is restarted
	 * set checkbox checked/unchecked*/
	
	public void changeVisitStatus(){
		SharedPreferences visitStatus = mData.getVisitStatus();
		SharedPreferences.Editor editor = visitStatus.edit();
		String visited = mActivity.getResources().getString(R.string.visited);
		String notvisited = mActivity.getResources().getString(R.string.notvisited);
		
		if(visitStatus.getString(mData.getVisitKey(), notvisited).equals(notvisited)){
			editor.putString(mData.mVisitKey, visited);
			editor.commit();
		}
		else{
			editor.putString(mData.mVisitKey, notvisited);
			editor.commit();
		}
		mGUI.getVisitStatus().setText(visitStatus.getString(mData.mVisitKey, "Nicht besucht."));
		if(visitStatus.getString(mData.mVisitKey, notvisited).equals(notvisited)){
			mGUI.mBtnVisit.setChecked(false);
		}
		else{
			mGUI.mBtnVisit.setChecked(true);
		}
	}
	
	/**set distance between users current position and chosen location
	 */
	
	public void setDistance() {
		Double distance = 0.0;
		do{
			distance = mDistCalc.getDistance(mData.getLatitude(), mData.getLongitude(), mActivity);
		}
		while(distance == null);
		
		if(distance != 0 && distance != -1) {
			Double distance_rounded = Math.rint(distance*100)/100;
			if(distance_rounded>1000) {
		    	double distance_km = distance / 1000;
		    	double distance_km_gerundet=Math.rint(distance_km*100)/100;
		    	mGUI.getDistance().setText(String.valueOf(distance_km_gerundet + " km"));
		    }
		    else {
		    	mGUI.getDistance().setText(String.valueOf(distance_rounded + " m"));
		    }
		}
	}
	
	/**checks if provider (GPS) is enabled or not
	 * */
	
	public boolean isProviderEnabled() {
		LocationManager service = (LocationManager) mActivity.getSystemService(Context.LOCATION_SERVICE);
		boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
		return enabled;
	}
	
	/**commits the current location name and starts ActivityMain to show the location on map
	*/

	public void showOnMap() {
		String mLocationName = mData.getTitle();
		Intent intent = new Intent(mData.getActivity(), ActivityMain.class);
		intent.putExtra("Ortsname", mLocationName);
		mActivity.startActivity(intent);
	}
}