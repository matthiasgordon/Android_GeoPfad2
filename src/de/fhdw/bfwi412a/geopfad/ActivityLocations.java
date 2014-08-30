package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class ActivityLocations extends Activity {

	Context context = ActivityLocations.this;
	ActivityLocationsData mData;
	ActivityLocationsGUI mGUI;
	ActivityLocationsApplicationLogic mAppLogic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}
	
	private void initData () {
		mData = new ActivityLocationsData(this);
	}

	private void initGUI () {
		setContentView(R.layout.activity_locations);
		mGUI = new ActivityLocationsGUI(this, this, mData);
		mGUI.getActionBar().setTitle(mData.getTitle());
		mGUI.getImageUrl().setImageResource(this.getResources()
				.getIdentifier(mData.getImageUrl(), "drawable", this.getPackageName())
				);
		mGUI.getImageUrl2().setImageResource(this.getResources()
				.getIdentifier(mData.getImageUrl2(), "drawable", this.getPackageName())
				);
		mGUI.getImageUrl3().setImageResource(this.getResources()
				.getIdentifier(mData.getImageUrl3(), "drawable", this.getPackageName())
				);
		mGUI.getAbout().setText(mData.getAbout());
		mGUI.getVisitStatus().setText(mData.getVisitStatus()
				.getString(mData.getVisitKey(), "Nein"));
	}
	
	private void initApplicationLogic () {
		mAppLogic = new ActivityLocationsApplicationLogic(this, mData, mGUI);
	}
	
	private void initEventToListenerMapping () {
		new ActivityLocationsEventToListenerMapping(mGUI, mAppLogic);
	}
	
	
}
