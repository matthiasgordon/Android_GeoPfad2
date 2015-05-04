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

import de.fhdw.bfwi412a.geopfad.R;
import de.fhdw.bfws412a.geopfad.OrteAdapter.OrtHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

/**Class is used to generate background processes, which can take a long time, to process.*/
public class AdapterAsyncTask extends AsyncTask<String, Void, Bitmap>{

	private Ort mOrt;
	private Context context;
	private OrtHolder mOrtHolder;
	private String mKeyList;
	private String mKeyLocation;
	
	
	public AdapterAsyncTask(Context context,OrtHolder holder, Ort ort) {
	    this.mOrtHolder= holder;
	    this.context= context;
	    this.mOrt = ort;
	    mKeyList = context.getResources().getString(R.string.scale_internal_image);
	    mKeyLocation = context.getResources().getString(R.string.scale_external_image);
	}
	
	/**Generate a background processes, which scales a image*/
	@Override
	protected Bitmap doInBackground(String... params) {
		
		Bitmap mOrtBitmap = null;
		
		if(params[0].equalsIgnoreCase(mKeyList)) {
			
			mOrtBitmap = ScalingUtilities.fitScale(context.getResources(),context.getResources()
					.getIdentifier("thumb_"+mOrt.getImgUrl(), "drawable",context.getPackageName()), 
					context, 
					context.getResources().getString(R.string.scale_destination_fragment_list));	
		}
		else if(params[0].equalsIgnoreCase(mKeyLocation)){
			
			mOrtBitmap = ScalingUtilities.fitScaleExtern(mOrt.getExtImgUrl(), 
					context, 
					context.getResources().getString(R.string.scale_destination_fragment_list));
		}
		
		return mOrtBitmap;
	}
	
	/**Set the the returned Bitmap of the doInBackground method*/
	@Override
	protected void onPostExecute(Bitmap result) {

	    super.onPostExecute(result);

	        //imv.setImageBitmap(result);
	    if(result != null){
	        mOrtHolder.imgIcon.setImageBitmap(result);
	    }
	    
	}
}   

