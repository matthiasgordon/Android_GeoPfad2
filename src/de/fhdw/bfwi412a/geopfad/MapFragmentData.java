package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.model.LatLng;

/** Class implemented by: Marc Niedermeier 
 * MapFramentData provides Data (locations, coordinates, and SharedPreferences file)
 * for MapFragment*/

public class MapFragmentData {
	public static final String PREFS_NAME = "MYPrefernceFile";
	
	private FragmentActivity mActivity;
	private List <Ort> mOrte;
	private List <LatLng> mRouteCoordinates = new ArrayList <LatLng> ();
	private SharedPreferences mVisitStatus;

	/** Constructor gets locations from Orte_DOM_Parser and 
	 * routecoordinates from the own Coordinates class;
	 * save SharedPreferences file mVisitSatus*/

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