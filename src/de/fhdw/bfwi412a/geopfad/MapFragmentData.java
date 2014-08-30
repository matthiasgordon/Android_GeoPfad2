package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.model.LatLng;

public class MapFragmentData {
	public static final String PREFS_NAME = "MYPrefernceFile";
	
	private FragmentActivity mActivity;
	private List <Ort> mOrte;
	private List <LatLng> mRouteCoordinates = new ArrayList <LatLng> ();
	private SharedPreferences mVisitStatus;


	public MapFragmentData(MapFragment mfrag){
		mActivity = mfrag.getActivity();
		mOrte = Orte_DOM_Parser.getOrteFromFile(mActivity);
		mRouteCoordinates = new Coordinates().getCoordinates();
		mVisitStatus = mActivity.getSharedPreferences(PREFS_NAME, 0);
	}
	
	public FragmentActivity getActivity() {
		return mActivity;
	}

	public List<Ort> getOrte() {
		return mOrte;
	}

	public List<LatLng> getRouteCoordinates() {
		return mRouteCoordinates;
	}

	public SharedPreferences getVisitStatus() {
		return mVisitStatus;
	}
	
}
