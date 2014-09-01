//Class implemented by: Matthias Gordon

package de.fhdw.bfwi412a.geopfad;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class ActivityMainEventToListenerMapping implements OnPageChangeListener, TabListener {
	private ActivityMainGUI mGUI;

	public ActivityMainEventToListenerMapping(ActivityMainGUI gui)
	{
		mGUI = gui;
		mGUI.getViewPager().setOnPageChangeListener(this);
		mGUI.getTab1().setTabListener(this);
		mGUI.getTab2().setTabListener(this);
		mGUI.addTabs();
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

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			mGUI.getViewPager().setCurrentItem(tab.getPosition());
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			
		}
	
}
