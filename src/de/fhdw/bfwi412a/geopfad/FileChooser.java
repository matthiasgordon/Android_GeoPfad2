package de.fhdw.bfwi412a.geopfad;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("SdCardPath") 
public class FileChooser extends ListActivity {
	    
	    private File currentDir;
	    private FileArrayAdapter adapter;
	    private String url;
	   
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    	
	        super.onCreate(savedInstanceState);
	        currentDir = new File("/sdcard/");
	        fill(currentDir);
	        
	    }
	    
	    
	    void fill(File f)
	    {
	        File[]dirs = f.listFiles();
	         this.setTitle("Aktueller Ordner: "+f.getName());
	         List<FileChooserOption>dir = new ArrayList<FileChooserOption>();
	         List<FileChooserOption>fls = new ArrayList<FileChooserOption>();
	         try{
	             for(File ff: dirs)
	             {
	                if(ff.isDirectory())
	                    dir.add(new FileChooserOption(ff.getName(),"Folder",ff.getAbsolutePath()));
	                else
	                {
	                    fls.add(new FileChooserOption(ff.getName(),"File Size: "+ff.length(),ff.getAbsolutePath()));
	                }
	             }
	         }catch(Exception e)
	         {
	             
	         }
	         Collections.sort(dir);
	         Collections.sort(fls);
	         dir.addAll(fls);
	         if(!f.getName().equalsIgnoreCase("sdcard"))
	             dir.add(0,new FileChooserOption("..","Parent Directory",f.getParent()));
	         adapter = new FileArrayAdapter(FileChooser.this,R.layout.file_view,dir);
	         //ListView lv= (ListView) findViewById(R.id.listView1);
	         this.setListAdapter(adapter);
	    }
	    @Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        // TODO Auto-generated method stub
	        super.onListItemClick(l, v, position, id);
	        FileChooserOption o = adapter.getItem(position);
	        if(o.getData().equalsIgnoreCase("folder")||o.getData().equalsIgnoreCase("parent directory")){
	                currentDir = new File(o.getPath());
	                fill(currentDir);
	        }
	        else
	        {
	            onFileClick(o);
	        }
	        
	    }
	    private void onFileClick(FileChooserOption o)
	    {
	        Toast.makeText(this, "File Clicked: "+o.getName(), Toast.LENGTH_SHORT).show();
	    	url = o.getName();
//	    	TextView text1 = (TextView)findViewById(R.id.textView1);
//	    	text1.setText(url);
	    	
	    	finish();
	    	//bildurl.setText(url);
	    	
	    	
	    	/*Intent intent = new Intent(FileChooser.this, MainActivity.class);
			startActivity(intent);*/
	    }

		public void setCurrentDir(File currentDir) {
			this.currentDir = currentDir;
		}

		public File getCurrentDir() {
			return currentDir;
		}

		public String getUrl() {
			return url;
		}
		
		@Override
		public void finish() {
		  // Prepare data intent 
		  Intent data = new Intent();
		  data.putExtra("bildurl", url);
		  // Activity finished ok, return the data
		  setResult(RESULT_OK, data);
		  super.finish();
		}
}
