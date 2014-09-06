package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

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
		
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  if (resultCode == RESULT_OK && requestCode == ActivityAddLocationData.IMAGE_URL) {
		    if (data.hasExtra("bildurl")) {
		    	TextView url = (TextView) findViewById(R.id.bildurl);
		    	url.setText(data.getExtras().getString("bildurl"));	
		    	ImageView imgPreview = (ImageView) findViewById(R.id.imgAddLocationPreview);
		    	imgPreview.setImageBitmap(ScalingUtilities.fitScaleExtern(data.getExtras().getString("bildurl"), this, "preview"));
		    }
		  }
		} 
		
		@Override
		public void finish() {
		  // Activity finished ok, return the data
		  setResult(RESULT_OK);
		  super.finish();
		}
}
