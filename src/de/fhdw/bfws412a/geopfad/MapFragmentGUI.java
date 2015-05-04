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

import de.fhdw.bfwi412a.geopfad.R;

/**Class implemented by: Marc Niedermeier 
 * MapFrgmentGUI loads and provides all GUI-elements;
 * serves methods to fill/style the GUI*/

public class MapFragmentGUI {
	private MapFragment mMFragment;
	private BitmapDescriptor mMarkerIcon;
	private SupportMapFragment mFragment;
	private GoogleMap mMap;
	private Spinner mSpinner;
	private String mSelLocName;
	
	/** Method saves loads all GUI elements and saves information about intent
	 * @param frag parent MapFrgment
	 * @param view View that is created by MapFragment
	 * @param sellocname Name of the Location that has to be highlighted
	 * @param isfromintent boolean that tells if intent is given to the MapFragment*/
	
	MapFragmentGUI(MapFragment mfrag, View view, String sellocname, boolean isfromintent){
		mMFragment = mfrag;
		mSelLocName = sellocname;
		mMarkerIcon = BitmapDescriptorFactory.fromResource(R.drawable.reisszwecke_klein);
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
	
	/** Method styles Map depending on which parameters is given to it 
	 * (decides which Marker are shown and how they are presented)
	 * @param mRouteCoordinates are the coordinates of the route that draw the polyline on the map
	 * @param mOrte is the list of all locations
	 * @param mMarkerId is the id of the option which is selected by the spinner
	 * @param mVisitedStatus is the SharedPreferences file for comparing if locations are visited
	 * @param mIsFromIntent decides if only one marker is highlighted or not*/

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
	
	/** Method that draws the group of markers that are wanted on the map
	 * @param mMarkerId stands for selected spinner option, decides which marker are shown:
	 * 	0: all locations are shown
	 * 	1: all visited locations are shown
	 * 	2: all unvisited locations are shown
	 * @param mOrte list of all locations
	 * @param mVisitStatus SharedPreferences filed for comparing*/
	
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
	
	/** Method for highlighting only one explicit marker
	 * @param locName name of the marker that should be highlighted
	 * @param mOrte list of all locations*/
	
	public void setupMarker(String locName, List<Ort> mOrte){
		Marker marker=null;
		for(Ort curOrt : mOrte)
			if(curOrt.getName().equals(locName))
			marker = mMap.addMarker(new MarkerOptions().position(new LatLng(curOrt.getLat(), curOrt.getLng()))
						.title(curOrt.getName())
						.icon(mMarkerIcon));
			marker.showInfoWindow();
	}
	
	/** Method that defines the spinner optionslist
	 * @param isIntent boolean that says if intent was given to MapFragment
	 * 	if isIntent=true the name of highlighted location is added to optionsmenu
	 * 	if isIntent=false normal optionslist is shown*/
	
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