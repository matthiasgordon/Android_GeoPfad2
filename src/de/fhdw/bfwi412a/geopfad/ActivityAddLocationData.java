package de.fhdw.bfwi412a.geopfad;

import java.io.File;

import android.os.Environment;

public class ActivityAddLocationData {

	static final int IMAGE_URL = 100;
	static final String XML_DIRECTORY_NAME = String.valueOf(R.string.xml_directory_name);
	static final File GEOPFAD_DIRECTORY = new File(Environment.getExternalStorageDirectory().getPath() + XML_DIRECTORY_NAME);
	static final String XML_FILE_NAME = String.valueOf(R.string.xml_file_name);
	static final File ORTE_XML = new File(GEOPFAD_DIRECTORY + XML_FILE_NAME);
	private String extrasImageUrl;
	private ActivityAddLocation mAddLoc;
	
	public ActivityAddLocationData(ActivityAddLocation addLoc){
		mAddLoc = addLoc;
		extrasImageUrl = String.valueOf(R.string.intent_extras_image_url);
	}
	
	public static int getImageUrl() {
		return IMAGE_URL;
	}
	public ActivityAddLocation getmAddLoc() {
		return mAddLoc;
	}

	public String getExtrasImageUrl() {
		return extrasImageUrl;
	}
	
}
