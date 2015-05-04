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
import android.app.Activity;
import android.os.Bundle;

/** Class implemented by: Johanna Korten*/

public class ActivityLocations extends Activity {

	private ActivityLocationsData mData;
	private ActivityLocationsGUI mGUI;
	private ActivityLocationsApplicationLogic mAppLogic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}
	
	/** 
	 * implemented by Marcel Böttcher
	 * when this activity is going to close 
	 * the Bitmap Sources of the ImageViews
	 * will be delete*/
	@Override
	public void onDestroy() {
		mGUI.getImageUrl().setImageBitmap(null);
		mGUI.getImageUrl2().setImageBitmap(null);
		mGUI.getImageUrl3().setImageBitmap(null);
		mGUI.getExtImageUrl().setImageBitmap(null);
		super.onDestroy();
	}
	
	private void initData () {
		mData = new ActivityLocationsData(this);
	}

	private void initGUI () {
		setContentView(R.layout.activity_locations);
		mGUI = new ActivityLocationsGUI(this, mData);
		this.getActionBar().setTitle(mData.getTitle());
		mGUI.getVisitStatus().setText(mData.getVisitStatus().getString
				(mData.getVisitKey(), this.getResources().getString(R.string.notvisited)));
		if(mGUI.getVisitStatus().getText().toString().equals(this.getResources().getString(R.string.notvisited))){
			mGUI.getBtnVisit().setChecked(false);
		}
		else{
			mGUI.getBtnVisit().setChecked(true);
		}
		mGUI.scalePictures();
	}
	
	private void initApplicationLogic () {
		mAppLogic = new ActivityLocationsApplicationLogic(this, mData, mGUI);
	}
	
	private void initEventToListenerMapping () {
		new ActivityLocationsEventToListenerMapping(mGUI, mAppLogic);
	}
	
}
