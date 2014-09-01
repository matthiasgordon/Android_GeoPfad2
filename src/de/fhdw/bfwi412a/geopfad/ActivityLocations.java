package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

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
		mGUI = new ActivityLocationsGUI(this, mData);
		mGUI.getActionBar().setTitle(mData.getTitle());
	}
	
	private void initApplicationLogic () {
		mAppLogic = new ActivityLocationsApplicationLogic(this, mData, mGUI);
	}
	
	private void initEventToListenerMapping () {
		new ActivityLocationsEventToListenerMapping(mGUI, mAppLogic);
	}
	
}
