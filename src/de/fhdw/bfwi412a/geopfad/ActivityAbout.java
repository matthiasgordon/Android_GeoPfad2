package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.os.Bundle;

public class ActivityAbout extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		getActionBar().setTitle(R.string.bar_title);
		
	}
}