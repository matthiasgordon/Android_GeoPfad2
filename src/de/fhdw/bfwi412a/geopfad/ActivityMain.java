package de.fhdw.bfwi412a.geopfad;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Class implemented by: Matthias Gordon 
 * The ActivityMain displays two fragments and a tab-navigation. With the tabs you can navigate
 * from one fragment to the other. Also it is possible to swipe to change the displayed fragment.
 * The displayed fragments are the MapFragment and the ListFragment.
 */

/**
 * The extends FragmentActivity is needed because two fragments are embedded into the activity.
 */
public class ActivityMain extends FragmentActivity {
	
	private ActivityMainGUI mGUI;
	private ActivityMainData mData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}
	
	private void initData () {
		mData = new ActivityMainData(this);
	}

	private void initGUI () {
		setContentView(R.layout.activity_main);
		mGUI = new ActivityMainGUI(this);
		/**
		 * The FragmentAdapter has to been set on the ViewPager so that it knows which Fragments
		 * to show.
		 */
		mGUI.getViewPager().setAdapter(new FragmentAdapter (getSupportFragmentManager(), mData.getLocationName()));
	}
	
	private void initApplicationLogic () {
		
	}
	
	private void initEventToListenerMapping () {
		new ActivityMainEventToListenerMapping(mGUI);
	}
}