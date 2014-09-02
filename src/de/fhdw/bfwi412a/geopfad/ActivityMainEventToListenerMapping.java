package de.fhdw.bfwi412a.geopfad;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager.OnPageChangeListener;

/**
 * Class implemented by: Matthias Gordon
 */

/**
 * The OnPageChangeListener which is set on the ViewPager recognizes if the user changes the
 * fragment via swiping.
 * The TabListener which is set on the tabs recognizes clicks on the tabs.
 */
public class ActivityMainEventToListenerMapping implements OnPageChangeListener, TabListener {
	private ActivityMainGUI mGUI;

	public ActivityMainEventToListenerMapping(ActivityMainGUI gui)
	{
		mGUI = gui;
		mGUI.getViewPager().setOnPageChangeListener(this);
		mGUI.getTab1().setTabListener(this);
		mGUI.getTab2().setTabListener(this);
		mGUI.addTabs(mGUI.getActionBar());
	}
		
		/**
		 * Once the user selects a fragment via swiping the listener calls this method
		 * and sets the corresponding tab as selected.
		 */
		@Override
		public void onPageSelected(int selectedFragmentID) {
			mGUI.getActionBar().setSelectedNavigationItem(selectedFragmentID);
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}

		/**
		 * Once the user selects a fragment via tapping on a tab the listener calls this
		 * method and the corresponding fragment is selected.
		 */
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
