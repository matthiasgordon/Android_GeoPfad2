/** class implemented by Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ActivityFileChooserApplicationLogic {

	private ActivityFileChooserData mFileChooserData;
	private ActivityFileChooser mFileChooser;
	private File mCurrentDir;
	
	 public ActivityFileChooserApplicationLogic(
			 ActivityFileChooser fileChooser,
			ActivityFileChooserData fileChooserData) {
		
		mFileChooserData = fileChooserData;
		mFileChooser = fileChooser;
		mCurrentDir = mFileChooserData.getCurrentDir();
		fill(mCurrentDir);
	}


	/**The first method is called fill. The purpose of fill is to get all the files and folder for the current directory we are in
     * The Method work like this:
     * get an array of all the files and directories in the current we are in 
     * create 2 ListArrays. One for folders and one for files.
     * sort files and directories into the appropriate ListArray.
     * sort the ListArrays alphabetically and pass to one ListArray.
     * pass this ListArray to our custom ArrayAdapter
     */
    void fill(File f)
    {	
    	FileArrayAdapter adapter = mFileChooserData.getAdapter();
    	
        File[]dirs = f.listFiles();
         mFileChooser.setTitle("Aktueller Ordner: "+f.getName()); //zeigt den Aktuellen Ordner an
         List<FileChooserOption>dir = new ArrayList<FileChooserOption>(); //array der Ordner
         List<FileChooserOption>fls = new ArrayList<FileChooserOption>(); //array der Dateien
         try{
             for(File ff: dirs)
             {
                if(ff.isDirectory())
                    dir.add(new FileChooserOption(ff.getName(),"Ordner",ff.getAbsolutePath())); 
                else
                {
                    fls.add(new FileChooserOption(ff.getName(),"Dateigröße: "+ff.length()+ " Bytes",ff.getAbsolutePath()));
                }
             }
         }catch(Exception e)
         {
             
         }
         Collections.sort(dir);
         Collections.sort(fls);
         dir.addAll(fls);
         if(!f.getName().equalsIgnoreCase("sdcard"))
         dir.add(0,new FileChooserOption("..","Ordnerebene hoch",f.getParent()));
         adapter = new FileArrayAdapter(mFileChooser,R.layout.file_view,dir);
         mFileChooserData.setAdapter(adapter);
         mFileChooser.setListAdapter(adapter);
    }
}
