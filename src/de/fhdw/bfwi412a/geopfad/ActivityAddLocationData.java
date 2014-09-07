/** class implemented by Marcel B�ttcher */
package de.fhdw.bfwi412a.geopfad;

import java.io.File;

import android.os.Environment;

public class ActivityAddLocationData {

	private final int IMAGE_URL = 100;
	private String xmlDirectoryName;
	private File geopfadDirectory;
	private String xmlFileName;
	private File orteXml;
	private String extrasImageUrl;
	private ActivityAddLocation mAddLoc;
	
	public ActivityAddLocationData(ActivityAddLocation addLoc){
		mAddLoc = addLoc;
		extrasImageUrl = mAddLoc.getResources().getString(R.string.intent_extras_image_url);
		xmlDirectoryName = mAddLoc.getResources().getString(R.string.xml_directory_name);
		geopfadDirectory = new File(Environment.getExternalStorageDirectory().getPath() + xmlDirectoryName);
		xmlFileName = mAddLoc.getResources().getString(R.string.xml_file_name);
		orteXml = new File(geopfadDirectory + xmlFileName);
		
	}
	

	public int getIMAGE_URL() {
		return IMAGE_URL;
	}

	public ActivityAddLocation getmAddLoc() {
		return mAddLoc;
	}

	public String getExtrasImageUrl() {
		return extrasImageUrl;
	}

	public String getXmlDirectoryName() {
		return xmlDirectoryName;
	}

	public File getGeopfadDirectory() {
		return geopfadDirectory;
	}

	public String getXmlFileName() {
		return xmlFileName;
	}

	public File getOrteXml() {
		return orteXml;
	}
}
