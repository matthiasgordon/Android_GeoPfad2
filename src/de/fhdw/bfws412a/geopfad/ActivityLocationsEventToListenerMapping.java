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

import de.fhdw.bfwi412a.geopfad.R;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/** Class implemented by: Johanna Korten
 *implements interfaces
 **/

public class ActivityLocationsEventToListenerMapping implements OnClickListener, LocationListener {

	private ActivityLocationsGUI mGUI;
	private ActivityLocationsApplicationLogic mAppLogic;
	
	public ActivityLocationsEventToListenerMapping(ActivityLocationsGUI gui, ActivityLocationsApplicationLogic appLogic) {
		mGUI = gui;
		mAppLogic = appLogic;
		mGUI.getBtnNavigation().setOnClickListener(this);
		mGUI.getBtnVisit().setOnClickListener(this);
		mGUI.getBtnShowOnMap().setOnClickListener(this);
		mAppLogic.getLocationManager().requestLocationUpdates(mAppLogic.getmProvider(), 400, 1, this);
	}
	
	/**executes methods if the buttons or checkbox is clicked by the user
	 * */
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btnNavigation:
			mAppLogic.navigateToLocation();
			break;
		case R.id.btnVisit:
			mAppLogic.changeVisitStatus();
			break;
		case R.id.btnShowOnMap:
			mAppLogic.showOnMap();
			break;
		}
	}

	/**
	 * LocationListener implemented by: Matthias Gordon
	 * if location is changed the distance is being refreshed
	 */
	@Override
	public void onLocationChanged(Location location) {
		mAppLogic.setDistance();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

}
