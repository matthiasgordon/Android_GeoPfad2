package de.fhdw.bfwi412a.geopfad;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ActivityMain extends FragmentActivity {
	
	private ActivityMainGUI mGUI;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}
	
	private void initData () {
		
	}

	private void initGUI () {
		setContentView(R.layout.activity_main);
		mGUI = new ActivityMainGUI(this);
		mGUI.getViewPager().setAdapter(new MyAdapter (getSupportFragmentManager()));
	}
	
	private void initApplicationLogic () {
		
	}
	
	private void initEventToListenerMapping () {
		new ActivityMainEventToListenerMapping(mGUI);
	}
}