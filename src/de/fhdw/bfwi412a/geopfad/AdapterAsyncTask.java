/** class implemented by Marcel Böttcher und Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;

import de.fhdw.bfwi412a.geopfad.OrteAdapter.OrtHolder;
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

