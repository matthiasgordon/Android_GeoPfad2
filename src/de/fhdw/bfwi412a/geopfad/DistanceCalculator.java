package de.fhdw.bfwi412a.geopfad;
/**Class implemented by: Matthias Wiegand
 * DistanceCalculator expects the current air line distance to a location*/

import android.content.Context;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;

public class DistanceCalculator implements GpsStatus.Listener{
	
	private LocationManager mLocationManager;
	private String mProvider;
	private Criteria criteria;
	private int mStatus;
	
	public DistanceCalculator() {
		criteria = new Criteria();
	}
	/**
	 * get current coordinates
	 * */
	public Location getLiveLocation(Context context) {
		mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		mLocationManager.addGpsStatusListener(this);
		Location liveLocation = null;
		switch (mStatus){
		case 0:
			mProvider = mLocationManager.getBestProvider(criteria, false);
			liveLocation = mLocationManager.getLastKnownLocation(mProvider);
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}

		return liveLocation;
	}
	/**Calculate Distance to location
	 * @param coordinates of the location and current coordinates
	 * @return Distance as double
	 * */
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
		
	       switch (event) 
	       {
	          case GpsStatus.GPS_EVENT_SATELLITE_STATUS:
	        	  mStatus = 0;
	          break;
	          case GpsStatus.GPS_EVENT_FIRST_FIX:
	        	  mStatus = 0;// this means you  found GPS Coordinates                          
	          break;
	          case GpsStatus.GPS_EVENT_STARTED:
	        	  mStatus = 2;
	          break;
	          case GpsStatus.GPS_EVENT_STOPPED:
	        	  mStatus = 3;
	          break;
	        }
		
	}
	
}
