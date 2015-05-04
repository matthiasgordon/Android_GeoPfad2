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

import android.content.SharedPreferences;
import android.os.Bundle;

public class ActivityLocationsData {
	public static final String PREFS_NAME = "MYPrefernceFile";
	
	private ActivityLocations mActivity;
	private Bundle mOrtInfo;
	private String mTitle;
	private String mImageUrl;
	private String mImageUrl2;
	private String mImageUrl3;
	private String mExtImageUrl;
	private String mAbout;
	private double mLatitude;
	private double mLongitude;
	private double mLiveLatitude;
	private double mLiveLongitude;
	private final String mVisitKey;
	private SharedPreferences mVisitStatus;

	
	public ActivityLocationsData(ActivityLocations actLocations) {
		mActivity = actLocations;
		mOrtInfo = mActivity.getIntent().getExtras();
		mTitle = mOrtInfo.getString("Ortname");
		mImageUrl = mOrtInfo.getString("imageUrl");
		mImageUrl2 = mOrtInfo.getString("imageUrl2");
		mImageUrl3 = mOrtInfo.getString("imageUrl3");
		mExtImageUrl = mOrtInfo.getString("extImageUrl");
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

	
	public String getExtImageUrl() {
		return mExtImageUrl;
	}

	public void setExtImageUrl(String mExtImageUrl) {
		this.mExtImageUrl = mExtImageUrl;
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
