package de.fhdw.bfwi412a.geopfad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.LocationManager;
import android.net.Uri;

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
	}
	
	public LocationManager getLocationManager() {
		return mLocationManager;
	}
	
	public String getmProvider() {
		return mProvider;
	}

	public void navigateToLocation(){
		double mLat = mData.getLatitude();
		double mLng = mData.getLongitude();
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				 Uri.parse("google.navigation:q=" + mLat + "," + mLng));
		mActivity.startActivity(intent);
	}
	
	public void changeVisitStatus(){
		SharedPreferences visitStatus = mData.getVisitStatus();
		SharedPreferences.Editor editor = visitStatus.edit();
		
		if(visitStatus.getString(mData.getVisitKey(), "nein").equals("nein")){
			editor.putString(mData.mVisitKey, "ja");
			editor.commit();
		}
		else{
			editor.putString(mData.mVisitKey, "nein");
			editor.commit();
		}
		mGUI.getVisitStatus().setText(visitStatus.getString(mData.mVisitKey, "Nein"));
	}
	
	public void setDistance() {
		Double distance = mDistCalc.getDistance(mData.getLatitude(), mData.getLongitude(), mActivity);
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
	
	public boolean isProviderEnabled() {
		LocationManager service = (LocationManager) mActivity.getSystemService(Context.LOCATION_SERVICE);
		boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
		return enabled;
	}
}
