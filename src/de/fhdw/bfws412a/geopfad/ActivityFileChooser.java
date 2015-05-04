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
import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("SdCardPath") 
public class ActivityFileChooser extends ListActivity {
	
		private ActivityFileChooserApplicationLogic mFileChoosLogic;
		private ActivityFileChooserData mFileChoosData;
		private ActivityFileChooserGUI mFileChoosGUI;
		
	    /** Called when the activity is first created */
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        initData();
	        initGUI();
	        initApplicationLogic();
	        initEventToListenerMapping();
	        
	    }
	    
	    private void initData() {
			mFileChoosData = new ActivityFileChooserData(this);
		}

		private void initGUI () {
			mFileChoosGUI = new ActivityFileChooserGUI(this);
		}
		
		private void initApplicationLogic () {
			mFileChoosLogic = new ActivityFileChooserApplicationLogic(this, mFileChoosData);
		}
	
		private void initEventToListenerMapping () {
			new ActivityFileChooserEventToListener(mFileChoosLogic, mFileChoosGUI);
		}

	    /** We need to handle users clicking on files and folders */
	    @Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        
	        super.onListItemClick(l, v, position, id);
	        FileArrayAdapter adapter = mFileChoosData.getAdapter();
	        
	        FileChooserOption o = adapter.getItem(position);
	        if(o.getData().equalsIgnoreCase("Ordner")||o.getData().equalsIgnoreCase("Ordnerebene hoch")){
	                mFileChoosData.setCurrentDir(new File(o.getPath()));
	                mFileChoosLogic.fill(mFileChoosData.getCurrentDir());
	        }
	        else
	        {
	            onFileClick(o);
	        }
	    
	    /** The "file URL" is put in the variable url */   
	    }
	    
	    private void onFileClick(FileChooserOption o)
	    {
	        Toast.makeText(this, "Datei: "+o.getName()+" ausgewaehlt", Toast.LENGTH_SHORT).show();
	    	mFileChoosData.setUrl(o.getPath());
	    	
	    	finish();
	    }
		
	    /** implemented by Marcel B�ttcher*/
		@Override
		public void finish() {
		  /** Prepare data intent */
			String url = mFileChoosData.getUrl();
			
			if(url !=null){
			  Intent data = new Intent();
			  data.putExtra(getResources().getString(R.string.intent_extras_image_url), url);
			  /** Activity finished ok, return the data */
			  setResult(RESULT_OK, data);
			}
			else {
				setResult(RESULT_CANCELED);
			}
		  super.finish();
		}
		
		/** implemented by Marcel B�ttcher*/
		@Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case android.R.id.home:
	            finish();
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
}