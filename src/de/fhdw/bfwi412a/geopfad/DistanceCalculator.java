package de.fhdw.bfwi412a.geopfad;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

public class DistanceCalculator implements android.location.GpsStatus.Listener{
	
	LocationManager mLocationManager;
	private String mProvider;
	Criteria criteria;
	
	public DistanceCalculator() {
		criteria = new Criteria();
	}
	
	public Location getLiveLocation(Context context) {
		mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		mProvider = mLocationManager.getBestProvider(criteria, false);
		Location liveLocation = mLocationManager.getLastKnownLocation(mProvider);
		return liveLocation;
	}
	
	public double getDistance(double toLat, double toLng, Context context) {
		Location liveLocation = getLiveLocation(context);
		if(liveLocation != null) {
		double liveLat = liveLocation.getLatitude();
		double liveLng = liveLocation.getLongitude();
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
		return -1;
	}

	@Override
	public void onGpsStatusChanged(int event) {
		// TODO Auto-generated method stub
		
	}
	
}
