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

import java.util.List;

import de.fhdw.bfwi412a.geopfad.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Class implemented by: Matthias Gordon
 * The class contains a service which is started by the ActivityStart (first activity).
 * Its purpose is to run in the background and notify the user if he gets near to a location.
 * The class needs a LocationListener so that it can always measure the distance to the
 * locations when the user changes his position.
 */
public class ServiceNotifyDistance extends Service implements LocationListener {

	private static final String PREFS_NAME = "MYPrefernceFile";
	private SharedPreferences mVisitStatus;
	private NotificationManager mManager;
	private LocationManager mLocationManager;
	private IntentBuilder mIntentBuilder;
	private String mProvider;
	private Criteria mCriteria;
	private List<Ort> mOrte;
	private Context mContext;
	private DistanceCalculator mDistCalc;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	/**
	 * The method is called when the service is started for the first time in a runtime.
	 * 
	 */
	@Override
	public void onCreate() {
		mContext = this;
		mDistCalc = new DistanceCalculator();
		mIntentBuilder = new IntentBuilder();
		mManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
		mOrte = Orte_DOM_Parser.getOrteFromFile(this);
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		mCriteria = new Criteria();
		mProvider = mLocationManager.getBestProvider(mCriteria, false);
		super.onCreate();
	}

	/**
	 * This method is called each time the service is started. It requests location updates
	 * and then calls the method to calculate the distances.
	 */
	@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
		mLocationManager.requestLocationUpdates(mProvider, 400, 1, this);
		getDistanceForEachLocation();
		return super.onStartCommand(intent, flags, startId);
	}

	/**
	 * This method is called by the onDestroy method of ActivityStart. It gives the system a
	 * signal that location updates are not longer needed. The reason for this is that GPS
	 * and comparing distances all the time in the background would drain the battery very
	 * quickly. 
	 */
	@Override
		public void onDestroy() {
		mLocationManager.removeUpdates(this);
		super.onDestroy();
	}

	/**
	 * The method calculates each distance for every saved location from the live GPS position
	 * using the getDistance method of the DistanceCalculor class. If one of the distances is
	 * less then 50 meter a notification is shown. Also the location gets marked as visited.
	 */
	public void getDistanceForEachLocation() {
		double distance;
		for(int i=0;i<mOrte.size();i++) {
			distance = mDistCalc.getDistance(mOrte.get(i).getLat(), mOrte.get(i).getLng(), mContext);
			if(distance <= 50 && distance != -1) {
				String distanceText = String.valueOf(Math.rint(distance*100)/100);
				Notification notification = buildNotification(mOrte.get(i).getName(), i, distanceText);
				mManager.notify(i, notification);
				mVisitStatus = getSharedPreferences(PREFS_NAME, 0);
				SharedPreferences.Editor editor = mVisitStatus.edit();
				editor.putString(mOrte.get(i).getVisitKey(), this.getResources().getString(R.string.visited));
				editor.commit();
			}
		}
	}

	/**
	 * The method builds the notification for the getDistanceForEachLocation method.
	 * The intent for the notification is build by the IntentBuilder
	 * @param locationName the name of the location is passed so that it can written in the headline of the notification
	 * @param position this is the position of the location in the list of locations
	 * @param distanceText the text with the distance in meters
	 * @return notification the completed notification which can be passed
	 */
	public Notification buildNotification(String locationName, int position, String distanceText) {
		PendingIntent mContentIntent = PendingIntent.getActivity(this, 0, mIntentBuilder.buildIntentForActivityLocations
				(mContext, mOrte, position), PendingIntent.FLAG_CANCEL_CURRENT);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
		mBuilder.setAutoCancel(true);
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.setContentTitle( locationName + " ist in der Nähe.");
		mBuilder.setContentText("Luftlinie zum Ort: " + distanceText + "m.");
		mBuilder.setContentIntent(mContentIntent);
		Notification notification = mBuilder.build();
		return notification;
	}

	/**
	 * Whenever the user changes its position the getDistanceForEachLocation method is being called.
	 */
	@Override
	public void onLocationChanged(Location location) {
		getDistanceForEachLocation();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(this, provider.toUpperCase() + " wurde aktiviert",
        Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(this, "Bitte " + provider.toUpperCase() + " aktivieren",
        Toast.LENGTH_SHORT).show();
	}
}