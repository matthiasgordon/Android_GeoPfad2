package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.ColorRes;
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
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapFragmentGUI {
	
	BitmapDescriptor mMarkerIcon;
	SupportMapFragment mFragment;
	GoogleMap mMap;
	Spinner mSpinner;
	
	MapFragmentGUI(MapFragment mfrag, View view){
		mMarkerIcon = BitmapDescriptorFactory.fromResource(R.drawable.reisszwecke_klein);
		FragmentManager mFragmentManager = mfrag.getActivity().getSupportFragmentManager();
		if(mFragment == null){
			mFragment = (SupportMapFragment) mFragmentManager.findFragmentById(R.id.map);
		}
		mMap = mFragment.getMap();
		mSpinner = (Spinner) view.findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mfrag.getActivity(),
		R.array.string_spinner, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		mSpinner.setAdapter(adapter);
	}

	public GoogleMap getMap() {
		return mMap;
	}

	public Spinner getSpinner() {
		return mSpinner;
	}

	public void styleMap(List <LatLng> mRouteCoordinates, List <Ort> mOrte, 
			int mMarkerId, SharedPreferences mVisitStatus){
		if(mMap != null){
			mMap.clear();
			mMap.addPolyline(new PolylineOptions()
			.addAll(mRouteCoordinates)
			.width(6))
			.setColor(Color.argb(99, 255, 255, 0));
			setupMarkers(mMarkerId, mOrte, mVisitStatus);
			mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(50.99876752, 7.14546919), 14));
			mMap.setMyLocationEnabled(true);
//			mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			
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
}