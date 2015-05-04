/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	Böttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - AäR hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation verändert werden.
**
**	Ohne ausdrückliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zugänglich gemacht werden.
**
**	Eine Vervielfältigung und Veröffentlichung des Quellcodes ohne ausdrückliche
**	Genehmigung - auch in Auszügen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;
/**Class implemented by: Matthias Wiegand and Matthias Gordon
 * DistanceCalculator expects the current air line distance to a location*/

import android.content.Context;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;

/**class implemented by Matthias Wiegand*/
public class DistanceCalculator implements GpsStatus.Listener{
	
	private LocationManager mLocationManager;
	private String mProvider;
	private Criteria criteria;
	private int mStatus;
	
	public DistanceCalculator() {
		criteria = new Criteria();
	}
	/**
	 * *method implemented by Marcel Böttcher and Matthias Wiegand
	 * This method returns the live coordinates, but only when a current GPS signal was received.
	 * @return liveLocation last known GPS data
	 */
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
	/**method implemented by Matthias Wiegand
	 * Calculate Distance to location
	 * if no liveLocation is passed it returns -1 as an error
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

	/**method implemented by Marcel Böttcher
	 * This method checks if a GPS signal is found.*/
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
