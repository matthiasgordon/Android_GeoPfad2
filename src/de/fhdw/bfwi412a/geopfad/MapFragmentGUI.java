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
	private MapFragment mMFragment;
	private BitmapDescriptor mMarkerIcon;
	private SupportMapFragment mFragment;
	private GoogleMap mMap;
	private Spinner mSpinner;
	private String mSelLocName;
	
	MapFragmentGUI(MapFragment mfrag, View view, String sellocname, boolean isfromintent){
		mMarkerIcon = BitmapDescriptorFactory.fromResource(R.drawable.reisszwecke_klein);
		mMFragment = mfrag;
		mSelLocName = sellocname;
		FragmentManager mFragmentManager = mfrag.getActivity().getSupportFragmentManager();
		if(mFragment == null){
			mFragment = (SupportMapFragment) mFragmentManager.findFragmentById(R.id.map);
		}
		mMap = mFragment.getMap();
		mSpinner = (Spinner) view.findViewById(R.id.spinner1);
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
				if(mVisitStatus.getString(curOrt.getVisitKey(), mFragment.getResources().getString(R.string.notvisited))
						.equals(mFragment.getResources().getString(R.string.visited))){
				mMap.addMarker(new MarkerOptions().position(new LatLng(curOrt.getLat(), curOrt.getLng()))
						.title(curOrt.getName()))
						.setIcon(mMarkerIcon);
				}
			}
			break;
		case 2:
			for (Ort curOrt : mOrte){
				if(mVisitStatus.getString(curOrt.getVisitKey(), mFragment.getResources().getString(R.string.notvisited))
						.equals(mFragment.getResources().getString(R.string.notvisited))){
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
	
	public void setSpinnerList(boolean isIntent){
		String[] arrayList = mMFragment.getResources().getStringArray(R.array.string_spinner);
		List <String> liste = new ArrayList<String> ();
		for(int i=0; i<arrayList.length; i++){
			liste.add(arrayList[i]);
		}
		if(isIntent)
			liste.add(0, mSelLocName);
		ArrayAdapter<String> adapter = new ArrayAdapter<String> (mMFragment.getActivity(),android.R.layout.simple_spinner_dropdown_item, liste);
		  mSpinner.setAdapter(adapter);
	}
}