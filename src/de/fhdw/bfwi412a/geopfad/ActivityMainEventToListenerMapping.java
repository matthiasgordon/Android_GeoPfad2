package de.fhdw.bfwi412a.geopfad;

import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ActivityMainEventToListenerMapping implements OnPageChangeListener {
	private ActivityMainGUI mGUI;

	public ActivityMainEventToListenerMapping(ActivityMainGUI gui)
	{
		mGUI = gui;
		mGUI.getViewPager().setOnPageChangeListener(this);
	}
		
		@Override
		public void onPageSelected(int arg0) {
			mGUI.getActionBar().setSelectedNavigationItem(arg0);
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}
	
}
