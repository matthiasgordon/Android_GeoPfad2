package de.fhdw.bfwi412a.geopfad;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLocationsGUI {
	
	ActivityLocationsApplicationLogic mAppLogic;
	ActivityLocations mActLoc;
	ActivityLocationsData mData;
	SharedPreferences VisitStatus;
	TextView mAbout;
	ImageView mImageUrl;
	ImageView mImageUrl2;
	ImageView mImageUrl3;
	ImageView mExtImageUrl;
	TextView mVisitStatus;
	TextView mDistance;
	CheckBox mBtnVisit;
	Button mBtnNavigation;
	Button mBtnShowOnMap;

	public ActivityLocationsGUI(ActivityLocations actloc, ActivityLocationsData data) {
		mActLoc = actloc;
		mData = data;
		mAbout = (TextView) mActLoc.findViewById(R.id.textView2);
		mImageUrl = (ImageView) mActLoc.findViewById(R.id.imageView1);
		mImageUrl2 = (ImageView) mActLoc.findViewById(R.id.imageView2);
		mImageUrl3 = (ImageView) mActLoc.findViewById(R.id.imageView3);
		mExtImageUrl = (ImageView) mActLoc.findViewById(R.id.extImageView);
		mVisitStatus = (TextView) mActLoc.findViewById(R.id.txtVisitStatus);
		mDistance = (TextView) mActLoc.findViewById(R.id.txtDistance);
		mBtnVisit = (CheckBox) mActLoc.findViewById(R.id.btnVisit);
		mBtnShowOnMap = (Button) mActLoc.findViewById(R.id.btnShowOnMap);
		mBtnNavigation = (Button) mActLoc.findViewById(R.id.btnNavigation);
	}

	public TextView getAbout() {
		return mAbout;
	}

	public ImageView getImageUrl() {
		return mImageUrl;
	}
	public ImageView getImageUrl2() {
		return mImageUrl2;
	}

	public ImageView getImageUrl3() {
		return mImageUrl3;
	}
	
	public ImageView getmExtImageUrl() {
		return mExtImageUrl;
	}
	
	public TextView getVisitStatus() {
		return mVisitStatus;
	}
	
	public TextView getDistance() {
		return mDistance;
	}
	
	public CheckBox getBtnVisit(){
		return mBtnVisit;
	}

	public Button getBtnNavigation() {
		return mBtnNavigation;
	}
	
	public Button getBtnShowOnMap() {
		return mBtnShowOnMap;
	}

	public void scalePictures() {
		Bitmap picture = null;
		if(mData.getImageUrl() != null){
			picture = ScalingUtilities.fitScale(mActLoc.getResources(),mActLoc.getResources()
					.getIdentifier(mData.getImageUrl(), "drawable", mActLoc.getPackageName()), mActLoc, 
					mActLoc.getResources().getString(R.string.scale_destination_activity_location));
			mImageUrl.setImageBitmap(picture);
		}
		if(mData.getImageUrl2() != null){
			picture = ScalingUtilities.fitScale(mActLoc.getResources(),mActLoc.getResources()
					.getIdentifier(mData.getImageUrl2(), "drawable", mActLoc.getPackageName()), mActLoc, 
					mActLoc.getResources().getString(R.string.scale_destination_activity_location));
			mImageUrl2.setImageBitmap(picture);
		}
		if(mData.getImageUrl3() != null){
			picture = ScalingUtilities.fitScale(mActLoc.getResources(),mActLoc.getResources()
					.getIdentifier(mData.getImageUrl3(), "drawable", mActLoc.getPackageName()), mActLoc, 
					mActLoc.getResources().getString(R.string.scale_destination_activity_location));
			mImageUrl3.setImageBitmap(picture);
			
		}
		if(mData.getExtImageUrl() != null){	
		picture = ScalingUtilities.fitScaleExtern(mData.getExtImageUrl(), mActLoc, 
				mActLoc.getResources().getString(R.string.scale_destination_activity_location));
        Log.v("Path", mData.getExtImageUrl());
		mExtImageUrl.setImageBitmap(picture);
		}
		if(mData.getAbout() != null){
		mAbout.setText(mData.getAbout());
		}
		if(mData.getVisitStatus() != null){
		mVisitStatus.setText(mData.getVisitStatus()
				.getString(mData.getVisitKey(), mActLoc.getResources().getString(R.string.notvisited)));
		}
	}	
}