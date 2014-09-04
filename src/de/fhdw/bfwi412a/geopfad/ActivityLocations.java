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
	
	@Override
	public void onDestroy() {
		mGUI.mImageUrl.setImageBitmap(null);
		mGUI.mImageUrl2.setImageBitmap(null);
		mGUI.mImageUrl3.setImageBitmap(null);
		mGUI.mExtImageUrl.setImageBitmap(null);
		super.onDestroy();
	}
	
	private void initData () {
		mData = new ActivityLocationsData(this);
	}

	private void initGUI () {
		setContentView(R.layout.activity_locations);
		mGUI = new ActivityLocationsGUI(this, mData);
		mGUI.getActionBar().setTitle(mData.getTitle());
		mGUI.getVisitStatus().setText(mData.getVisitStatus().getString
				(mData.mVisitKey, this.getResources().getString(R.string.notvisited)));
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
