package de.fhdw.bfwi412a.geopfad;

import java.io.File;

import android.os.Environment;

public class ActivityAddLocationData {

	static final int IMAGE_URL = 100;
	static final File GEOPFAD_DIRECTORY = new File(Environment.getExternalStorageDirectory().getPath() + "/GeoPfad");
	static final File ORTE_XML = new File(GEOPFAD_DIRECTORY + "/orte.xml");
	private ActivityAddLocation mAddLoc;
	
	public ActivityAddLocationData(ActivityAddLocation addLoc){
		mAddLoc = addLoc;
	}
	
	public static int getImageUrl() {
		return IMAGE_URL;
	}
	public ActivityAddLocation getmAddLoc() {
		return mAddLoc;
	}
}
