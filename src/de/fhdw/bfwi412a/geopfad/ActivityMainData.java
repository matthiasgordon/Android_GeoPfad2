
package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;
import android.os.Bundle;

/**
 * Class implemented by: Matthias Gordon
 * 
 */
public class ActivityMainData {

	private ActivityMain mAct;
	private String mLocationName;
	
	public ActivityMainData(ActivityMain act) {
		mAct = act;
		Intent intent = mAct.getIntent();
		Bundle Ortname = intent.getExtras();
		if(Ortname!=null){
		mLocationName = Ortname.getString("Ortsname");
		}
	}

	public String getLocationName() {
		return mLocationName;
	}
}
