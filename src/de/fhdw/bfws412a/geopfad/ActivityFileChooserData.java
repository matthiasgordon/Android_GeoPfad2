/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	B�ttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - A�R hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation ver�ndert werden.
**
**	Ohne ausdr�ckliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zug�nglich gemacht werden.
**
**	Eine Vervielf�ltigung und Ver�ffentlichung des Quellcodes ohne ausdr�ckliche
**	Genehmigung - auch in Ausz�gen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;

import java.io.File;

import de.fhdw.bfwi412a.geopfad.R;

/** This class appropiate the path at what point the file explorer should open the external storage
 * and save the actual path 
 */
public class ActivityFileChooserData {

	private ActivityFileChooser mFileChooser;
	private File currentDir;
    private FileArrayAdapter adapter;
    private String url;
    private String mStartDirectory;
	
	public ActivityFileChooserData(ActivityFileChooser fileChooser) {
		mFileChooser = fileChooser;
		mStartDirectory = mFileChooser.getResources().getString(R.string.filechooser_startdirectory);
		currentDir = new File(mStartDirectory);
		
	}

	public ActivityFileChooser getmFileChooser() {
		return mFileChooser;
	}

	public File getCurrentDir() {
		return currentDir;
	}

	public FileArrayAdapter getAdapter() {
		return adapter;
	}

	public String getUrl() {
		return url;
	}
	
	public String getmStartDirectory() {
		return mStartDirectory;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCurrentDir(File currentDir) {
		this.currentDir = currentDir;
	}

	public void setAdapter(FileArrayAdapter adapter) {
		this.adapter = adapter;
	}
	
	
}
