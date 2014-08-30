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

PendingIntent contentIntent;

LocationManager locationManager;

Location liveLocation;

private String provider;

Criteria criteria;

Intent intent;

List<Ort> orte;

int position;

@Override

public IBinder onBind(Intent intent) {

return null;

}


@Override

public void onCreate() {

mManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);

orte = Orte_DOM_Parser.getOrteFromFile(this);

super.onCreate();

locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

criteria = new Criteria();

provider = locationManager.getBestProvider(criteria, false);

liveLocation = locationManager.getLastKnownLocation(provider);

}

@Override

public int onStartCommand(Intent intent, int flags, int startId) {

locationManager.requestLocationUpdates(provider, 400, 1, this);

return super.onStartCommand(intent, flags, startId);

}

@Override

public void onDestroy() {

locationManager.removeUpdates(this);

super.onDestroy();

}

public void callgetDistanceForEachLocation() {

liveLocation = locationManager.getLastKnownLocation(provider);

double mDistance;

for(int i=0;i<orte.size();i++) {

mDistance = getDistance(liveLocation.getLatitude(), liveLocation.getLongitude(), orte.get(i).getLat(), orte.get(i).getLng());

if(mDistance <= 50) {

position = i;

Notification notification = buildNotification(orte.get(i).getName(), position);

mManager.notify(8, notification);

}

}

}

public static double getDistance(double liveLat, double liveLng, double toLat, double toLng) {

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

public Notification buildNotification(String ort, int position) {

contentIntent = PendingIntent.getActivity(this, 0, setUpIntent(position), PendingIntent.FLAG_CANCEL_CURRENT);

NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

mBuilder.setAutoCancel(true);

mBuilder.setSmallIcon(R.drawable.ic_launcher);

mBuilder.setContentTitle("Ein Ort ist in der Nähe");

mBuilder.setContentText("Folgender Ort ist in der Nähe: " + ort);

mBuilder.setContentIntent(contentIntent);

Notification mNotification = mBuilder.build();

return mNotification;

}

public Intent setUpIntent(int position) {

intent = new Intent (this, ActivityLocations.class);

intent.putExtra("Ortname", orte.get(position).getName());

intent.putExtra("imageUrl", orte.get(position).getImgUrl());

intent.putExtra("about", orte.get(position).getAbout());

intent.putExtra("latitude", orte.get(position).getLat());

intent.putExtra("longitude", orte.get(position).getLng());

intent.putExtra("visitKey", orte.get(position).getVisitKey());

return intent;

}


@Override

public void onLocationChanged(Location location) {

callgetDistanceForEachLocation();

}


@Override

public void onStatusChanged(String provider, int status, Bundle extras) {

// TODO Auto-generated method stub

}


@Override

  public void onProviderEnabled(String provider) {

    Toast.makeText(this, provider + " wurde aktiviert",

        Toast.LENGTH_SHORT).show();

  }

  @Override

  public void onProviderDisabled(String provider) {

    Toast.makeText(this, "Bitte " + provider + " aktivieren",

        Toast.LENGTH_SHORT).show();

  }

}