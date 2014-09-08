/** class implemented by Marcel Böttcher */
package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/** The class allows the user to independently add new locations.*/
public class ActivityAddLocation extends Activity {

	private ActivityAddLocationData mAddLocData;
	private ActivityAddLocationGUI mAddLocGUI;
	private ActivityAddLocationApplicationLogic mAddLocAppLogic;
		
		ListFragmentGUI mListFragmentGUI;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.add_location);
			initData();
			initGUI();
			initApplicationLogic();
			initEventToListenerMapping();
		}
			
		private void initData() {
			mAddLocData = new ActivityAddLocationData(this);
		}

		private void initGUI () {
			mAddLocGUI = new ActivityAddLocationGUI(this, mAddLocData);
		}
		
		private void initApplicationLogic () {
			mAddLocAppLogic = new ActivityAddLocationApplicationLogic(this, mAddLocData, mAddLocGUI);
		}
	
		private void initEventToListenerMapping () {
			new ActivityAddLocationEventToListenerMapping(mAddLocAppLogic, mAddLocGUI);
		}
		
		/** The method is called if an image was selected in the file explorer, .*/
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  if (resultCode == RESULT_OK && requestCode == mAddLocData.getIMAGE_URL()) {
		    if (data.hasExtra(mAddLocData.getExtrasImageUrl())) {
		    	TextView url = mAddLocGUI.getmImageUrl();
		    	url.setText(data.getExtras().getString(mAddLocData.getExtrasImageUrl()));	
		    	ImageView imgPreview = mAddLocGUI.getImgPreview();
		    	imgPreview.setImageBitmap(ScalingUtilities.fitScaleExtern(data.getExtras()
		    			.getString(mAddLocData.getExtrasImageUrl()), this, getResources()
		    			.getString(R.string.scale_destination_activity_addlocation_image_preview)));
		    }
		  }
		} 
		
		/** Gives a Result to ActivityMain*/
		@Override
		public void finish() {
		  /** Activity finished ok, return the data */
		  setResult(RESULT_OK);
		  super.finish();
		}
}
