package de.fhdw.bfwi412a.geopfad;

import de.fhdw.bfwi412a.geopfad.OrteAdapter.OrtHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

public class AdapterAsyncTask extends AsyncTask<String, Void, Bitmap>{

	private Ort mOrt;
	private Context context;
	private OrtHolder mOrtHolder;
	private final String mKeyList = "intern";
	private final String mKeyLocation = "extern";
	
	
	public AdapterAsyncTask(Context context,OrtHolder holder, Ort ort) {
	    this.mOrtHolder= holder;
	    this.context= context;
	    this.mOrt = ort;
	}
	
	@Override
	protected Bitmap doInBackground(String... params) {
		
		Bitmap mOrtBitmap = null;
		
		if(params[0].equalsIgnoreCase(mKeyList)) {
			
			mOrtBitmap = ScalingUtilities.fitScale(context.getResources(),context.getResources().getIdentifier("thumb_"+mOrt.getImgUrl(), "drawable", context.getPackageName()), context, "list");	
		}
		else if(params[0].equalsIgnoreCase(mKeyLocation)){
			
			mOrtBitmap = ScalingUtilities.fitScaleExtern(mOrt.getExtImgUrl(), context, "list");
		}
		
		return mOrtBitmap;
	}
	
	@Override
	protected void onPostExecute(Bitmap result) {

	    super.onPostExecute(result);

	        //imv.setImageBitmap(result);
	    if(result != null){
	        mOrtHolder.imgIcon.setImageBitmap(result);
	    }
	    
	}
}   

