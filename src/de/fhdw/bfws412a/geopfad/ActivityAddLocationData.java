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

import java.io.File;

import de.fhdw.bfwi412a.geopfad.R;
import android.os.Environment;

/** In this class, the storage paths are provided for the folder and the file 
 * that are in the external memory or yet to be created.*/
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

