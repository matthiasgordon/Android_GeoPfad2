package de.fhdw.bfwi412a.geopfad;

import com.sonyericsson.util.ScalingUtilities;

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
		mGUI = new ActivityLocationsGUI(this, this, mData);
		mGUI.getActionBar().setTitle(mData.getTitle());
		if(mData.getImageUrl() != null){
			Bitmap picture = ScalingUtilities.fitScale(getResources(),getResources().getIdentifier(mData.getImageUrl(), "drawable", this.getPackageName()), context, "location");
			mGUI.getImageUrl().setImageBitmap(picture);
		//mGUI.getImageUrl().setImageResource(this.getResources().getIdentifier(mData.getImageUrl(), "drawable", this.getPackageName()));
		}
		if(mData.getImageUrl2() != null){
			Bitmap picture = ScalingUtilities.fitScale(getResources(),getResources().getIdentifier(mData.getImageUrl2(), "drawable", this.getPackageName()), context, "location");
			mGUI.getImageUrl2().setImageBitmap(picture);
		}
		if(mData.getImageUrl3() != null){
			Bitmap picture = ScalingUtilities.fitScale(getResources(),getResources().getIdentifier(mData.getImageUrl3(), "drawable", this.getPackageName()), context, "location");
			mGUI.getImageUrl3().setImageBitmap(picture);
		}
		if(mData.getExtImageUrl() != null){	
		Bitmap picture = ScalingUtilities.fitScaleExtern(mData.getExtImageUrl(), context, "location");
        Log.v("Path", mData.getExtImageUrl());
		mGUI.getmExtImageUrl().setImageBitmap(picture);
		}
		if(mData.getAbout() != null){
		mGUI.getAbout().setText(mData.getAbout());
		}
		if(mData.getVisitStatus() != null){
		mGUI.getVisitStatus().setText(mData.getVisitStatus()
				.getString(mData.getVisitKey(), "Nein"));
		}
	}
	
	private void initApplicationLogic () {
		mAppLogic = new ActivityLocationsApplicationLogic(this, mData, mGUI);
	}
	
	private void initEventToListenerMapping () {
		new ActivityLocationsEventToListenerMapping(mGUI, mAppLogic);
	}
	
	
}
