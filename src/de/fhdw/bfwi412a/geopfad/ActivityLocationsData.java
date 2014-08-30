package de.fhdw.bfwi412a.geopfad;

import android.content.SharedPreferences;
import android.os.Bundle;

public class ActivityLocationsData {
	public static final String PREFS_NAME = "MYPrefernceFile";
	
	ActivityLocations mActivity;
	Bundle mOrtInfo;
	String mTitle;
	String mImageUrl;
	String mImageUrl2;
	String mImageUrl3;
	String mAbout;
	double mLatitude;
	double mLongitude;
	double mLiveLatitude;
	double mLiveLongitude;
	final String mVisitKey;
	private SharedPreferences mVisitStatus;

	
	public ActivityLocationsData(ActivityLocations actLocations) {
		mActivity = actLocations;
		mOrtInfo = mActivity.getIntent().getExtras();
		mTitle = mOrtInfo.getString("Ortname");
		mImageUrl = mOrtInfo.getString("imageUrl");
		mImageUrl2 = mOrtInfo.getString("imageUrl2");
		mImageUrl3 = mOrtInfo.getString("imageUrl3");
		mAbout = mOrtInfo.getString("about");
		mVisitKey = mOrtInfo.getString("visitKey");
		mLatitude = mOrtInfo.getDouble("latitude");
		mLongitude = mOrtInfo.getDouble("longitude");
		mVisitStatus = mActivity.getSharedPreferences(PREFS_NAME, 0);
	}

	public ActivityLocations getActivity() {
		return mActivity;
	}

	public void setActivity(ActivityLocations mActivity) {
		this.mActivity = mActivity;
	}

	public Bundle getOrtInfo() {
		return mOrtInfo;
	}

	public void setOrtInfo(Bundle mOrtInfo) {
		this.mOrtInfo = mOrtInfo;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTitel) {
		this.mTitle = mTitel;
	}

	public String getImageUrl() {
		return mImageUrl;
	}

	public void setImageUrl(String mImageUrl) {
		this.mImageUrl = mImageUrl;
	}
	public String getImageUrl2() {
		return mImageUrl2;
	}

	public void setImageUrl2(String mImageUrl2) {
		this.mImageUrl2 = mImageUrl2;
	}

	public String getImageUrl3() {
		return mImageUrl3;
	}

	public void setImageUrl3(String mImageUrl3) {
		this.mImageUrl3 = mImageUrl3;
	}

	public String getAbout() {
		return mAbout;
	}

	public void setAbout(String mAbout) {
		this.mAbout = mAbout;
	}
	
	public String getVisitKey() {
		return mVisitKey;
	}

	public double getLatitude() {
		return mLatitude;
	}

	public void setLatitude(double mLatitude) {
		this.mLatitude = mLatitude;
	}

	public double getLongitude() {
		return mLongitude;
	}

	public void setLongitude(double mLongitude) {
		this.mLongitude = mLongitude;
	}
	
	public double getLiveLaditude() {
		return mLiveLatitude;
	}

	public void setLiveLatitude(double mLiveLatitude) {
		this.mLiveLatitude = mLiveLatitude;
	}


	public double getLiveLongitude() {
		return mLiveLongitude;
	}

	public void setLiveLongitude(double mLiveLongitude) {
		this.mLiveLongitude = mLiveLongitude;
	}
	
	public SharedPreferences getVisitStatus() {
		return mVisitStatus;
	}	
}
