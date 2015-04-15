/** class implemented by Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;

public class ActivityFileChooserGUI {

	private ActivityFileChooser mFileChoos;

	public ActivityFileChooserGUI(ActivityFileChooser mFileChoos) {
		
		this.mFileChoos = mFileChoos;
		mFileChoos.getActionBar().setTitle(R.string.bar_title);
	}

	public ActivityFileChooser getmFileChoos() {
		return mFileChoos;
	}

	public void setmFileChoos(ActivityFileChooser mFileChoos) {
		this.mFileChoos = mFileChoos;
	}
	
	
}
