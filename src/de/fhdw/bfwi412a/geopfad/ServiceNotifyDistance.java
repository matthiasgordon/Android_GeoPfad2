package de.fhdw.bfwi412a.geopfad;

import java.util.List;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class ServiceNotifyDistance extends Service implements LocationListener {

	NotificationManager mManager;
	PendingIntent mContentIntent;
	LocationManager mLocationManager;
	private String mProvider;
	Criteria mCriteria;
	Intent mIntent;
	List<Ort> mOrte;
	int mPosition;
	Context mContext;
	DistanceCalculator mDistCalc;

	@Override
		public IBinder onBind(Intent intent) {
		return null;
	}

	@Override

	public void onCreate() {
		mContext = this;
		mDistCalc = new DistanceCalculator();
		mManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
		mOrte = Orte_DOM_Parser.getOrteFromFile(this);
		super.onCreate();
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		mCriteria = new Criteria();
		mProvider = mLocationManager.getBestProvider(mCriteria, false);
	}

	@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
		mLocationManager.requestLocationUpdates(mProvider, 400, 1, this);
		getDistanceForEachLocation();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
		public void onDestroy() {
		mLocationManager.removeUpdates(this);
		super.onDestroy();
	}

	public void getDistanceForEachLocation() {
		double mDistance;
		for(int i=0;i<mOrte.size();i++) {
			mDistance = mDistCalc.getDistance(mOrte.get(i).getLat(), mOrte.get(i).getLng(), mContext);
			if(mDistance <= 50 && mDistance != -1) {
				mPosition = i;
				Notification notification = buildNotification(mOrte.get(i).getName(), mPosition);
				mManager.notify(8, notification);
			}
		}
	}

	public Notification buildNotification(String ortsName, int position) {
		mContentIntent = PendingIntent.getActivity(this, 0, setUpIntent(position), PendingIntent.FLAG_CANCEL_CURRENT);
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
		mBuilder.setAutoCancel(true);
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.setContentTitle("Ein Ort ist in der Naehe");
		mBuilder.setContentText("Folgender Ort ist in der Naehe: " + ortsName);
		mBuilder.setContentIntent(mContentIntent);
		Notification mNotification = mBuilder.build();
		return mNotification;
	}

	public Intent setUpIntent(int position) {
		mIntent = new Intent (this, ActivityLocations.class);
		mIntent.putExtra("Ortname", mOrte.get(position).getName());
		mIntent.putExtra("imageUrl", mOrte.get(position).getImgUrl());
		mIntent.putExtra("imageUrl2", mOrte.get(position).getImgUrl2());
		mIntent.putExtra("imageUrl3", mOrte.get(position).getImgUrl3());
		mIntent.putExtra("extImageUrl", mOrte.get(position).getExtImgUrl());
		mIntent.putExtra("about", mOrte.get(position).getAbout());
		mIntent.putExtra("latitude", mOrte.get(position).getLat());
		mIntent.putExtra("longitude", mOrte.get(position).getLng());
		mIntent.putExtra("visitKey", mOrte.get(position).getVisitKey());
		return mIntent;
	}


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