
package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;
import android.os.Bundle;

/**
 * Class implemented by: Matthias Gordon
 * No data is needed for the ActivityMain.
 */

public class ActivityMainData {

	ActivityMain mActivity;
	String mLocationName;
	
	public ActivityMainData(ActivityMain act){
		mActivity = act;
		Intent intent = mActivity.getIntent();
		Bundle Ortname = intent.getExtras();
		if(Ortname!=null){
		mLocationName = Ortname.getString("Ortsname");
		}
	}

	public String getLocationName() {
		return mLocationName;
	}
}
