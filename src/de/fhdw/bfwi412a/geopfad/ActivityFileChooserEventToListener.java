/** class implemented by Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;



public class ActivityFileChooserEventToListener {

	private ActivityFileChooserApplicationLogic mFileChoosAppLogic;
	private ActivityFileChooserGUI mFileChoosGUI;
	
	
	
	public ActivityFileChooserEventToListener(ActivityFileChooserApplicationLogic mFileChoosAppLogic, 
			ActivityFileChooserGUI mFileChoosGUI) {
		
		this.mFileChoosAppLogic = mFileChoosAppLogic;
		this.mFileChoosGUI = mFileChoosGUI;
		
	}



	public ActivityFileChooserApplicationLogic getmFileChoosAppLogic() {
		return mFileChoosAppLogic;
	}



	public ActivityFileChooserGUI getmFileChoosGUI() {
		return mFileChoosGUI;
	}


	
}
