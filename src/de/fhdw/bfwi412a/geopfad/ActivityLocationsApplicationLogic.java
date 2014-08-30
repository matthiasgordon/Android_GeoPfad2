package de.fhdw.bfwi412a.geopfad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.LocationManager;
import android.net.Uri;
import android.location.Location;

public class ActivityLocationsApplicationLogic {
	
	private ActivityLocationsData mData;
	private ActivityLocationsGUI mGUI;
	ActivityLocations mActivity;
	private LocationManager mLocationManager;
	private String mProvider;
	Criteria criteria;
	

	public ActivityLocationsApplicationLogic(ActivityLocations act, ActivityLocationsData data, ActivityLocationsGUI gui) {
		mData = data;
		mGUI = gui;
		mActivity = act;
		mLocationManager = (LocationManager) act.getSystemService(Context.LOCATION_SERVICE);
		criteria = new Criteria();
		mProvider = mLocationManager.getBestProvider(criteria, false);
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
	
	public void setLivePosition() {
		Location liveLocation = mLocationManager.getLastKnownLocation(mProvider);
		if(liveLocation != null) {
		mData.setLiveLatitude(liveLocation.getLatitude());
		mData.setLiveLongitude(liveLocation.getLongitude());
		}
	}
	
	public double calculateDistance(double liveLat, double liveLng, double toLat, double toLng) {
		if(mData.getLiveLaditude() != 0) {
		    int r = 6371000; // average radius of the earth in m
		    double dLat = Math.toRadians(toLat - liveLat);
		    double dLon = Math.toRadians(toLng - liveLng);
		    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
		      Math.cos(Math.toRadians(liveLat)) * Math.cos(Math.toRadians(toLat)) 
		      * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		    double d = r * c;
		    return d;
		}
		return 0;
	}
	
	public void setDistance() {
		if(mData.getLiveLaditude() !=0){
			Double distance = calculateDistance(mData.getLiveLaditude(), mData.getLiveLongitude(), mData.getLatitude(), mData.getLongitude());
			Double distance_rounded = Math.rint(distance*100)/100;
			
			if (distance_rounded>1000) {
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
