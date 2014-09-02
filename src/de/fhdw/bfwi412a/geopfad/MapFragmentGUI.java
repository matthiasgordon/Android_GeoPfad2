package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapFragmentGUI {
	
	BitmapDescriptor mMarkerIcon;
	SupportMapFragment mFragment;
	GoogleMap mMap;
	Spinner mSpinner;
	String mSelLocName;
	boolean mIsFromIntent;
	
	MapFragmentGUI(MapFragment mfrag, View view, String sellocname, boolean isfromintent){
		mMarkerIcon = BitmapDescriptorFactory.fromResource(R.drawable.reisszwecke_klein);
		
		mSelLocName = sellocname;
		mIsFromIntent = isfromintent;
		FragmentManager mFragmentManager = mfrag.getActivity().getSupportFragmentManager();
		if(mFragment == null){
			mFragment = (SupportMapFragment) mFragmentManager.findFragmentById(R.id.map);
		}
		mMap = mFragment.getMap();

		String[] arrayList = mfrag.getResources().getStringArray(R.array.string_spinner);
		List <String> liste = new ArrayList<String> ();
		for(int i=0; i<arrayList.length; i++){
			liste.add(arrayList[i]);
		}
		if(mIsFromIntent)
			liste.add(0, mSelLocName);
		mSpinner = (Spinner) view.findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String> (mfrag.getActivity(),android.R.layout.simple_spinner_dropdown_item, liste);
		  mSpinner.setAdapter(adapter);
		
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mfrag.getActivity(),
//		R.array.string_spinner, android.R.layout.simple_spinner_item);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		mSpinner.setAdapter(adapter);
	}

	public GoogleMap getMap() {
		return mMap;
	}

	public Spinner getSpinner() {
		return mSpinner;
	}

	public void styleMap(List <LatLng> mRouteCoordinates, List <Ort> mOrte, 
			int mMarkerId, SharedPreferences mVisitStatus, boolean mIsFromIntent){
		if(mMap != null){
			mMap.clear();
			mMap.addPolyline(new PolylineOptions()
			.addAll(mRouteCoordinates)
			.width(6))
			.setColor(Color.argb(99, 255, 255, 0));
			if(mIsFromIntent){
				setupMarker(mSelLocName, mOrte);}
			else{
			setupMarkers(mMarkerId, mOrte, mVisitStatus);}
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.99876752, 7.14546919), 14));
			mMap.setMyLocationEnabled(true);
		}
	}
	
	public void setupMarkers(int mMarkerId, List <Ort> mOrte, 
			SharedPreferences mVisitStatus){
		switch(mMarkerId){
		case 0:
			for (Ort curOrt : mOrte){
				mMap.addMarker(new MarkerOptions().position(new LatLng(curOrt.getLat(), curOrt.getLng()))
						.title(curOrt.getName()))
						.setIcon(mMarkerIcon);	
			}
			break;
		case 1:
			for (Ort curOrt : mOrte){
				if(mVisitStatus.getString(curOrt.getVisitKey(), "nein").equals("ja")){
				mMap.addMarker(new MarkerOptions().position(new LatLng(curOrt.getLat(), curOrt.getLng()))
						.title(curOrt.getName()))
						.setIcon(mMarkerIcon);
				}
			}
			break;
		case 2:
			for (Ort curOrt : mOrte){
				if(mVisitStatus.getString(curOrt.getVisitKey(), "nein").equals("nein")){
				mMap.addMarker(new MarkerOptions().position(new LatLng(curOrt.getLat(), curOrt.getLng()))
						.title(curOrt.getName()))
						.setIcon(mMarkerIcon);
				}
			}
			break;
		}	
	}
	
	public void setupMarker(String locName, List<Ort> mOrte){
		Marker marker=null;
		for(Ort curOrt : mOrte)
			if(curOrt.getName().equals(locName))
			marker = mMap.addMarker(new MarkerOptions().position(new LatLng(curOrt.getLat(), curOrt.getLng()))
						.title(curOrt.getName())
						.icon(mMarkerIcon));
			marker.showInfoWindow();
	}
}