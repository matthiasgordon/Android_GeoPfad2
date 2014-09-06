package de.fhdw.bfwi412a.geopfad;

import java.io.File;

public class ActivityFileChooserData {

	private ActivityFileChooser mFileChooser;
	private File currentDir;
    private FileArrayAdapter adapter;
    private String url;
    private String mStartDirectory;
	
	public ActivityFileChooserData(ActivityFileChooser fileChooser) {
		mFileChooser = fileChooser;
		mStartDirectory = String.valueOf(R.string.filechooser_startdirectory);
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
