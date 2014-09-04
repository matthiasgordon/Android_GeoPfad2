package de.fhdw.bfwi412a.geopfad;

import android.app.ActionBar;
import android.support.v4.view.ViewPager;

/**
 * Class implemented by: Matthias Gordon
 */

public class ActivityMainGUI {

	private ViewPager mViewPager;
	private ActionBar.Tab mTab1;
	private ActionBar.Tab mTab2;	
	
	public ActivityMainGUI (ActivityMain act)
	{
		/**
		 * The ViewPager enables the possibility to swipe between the two fragments.
		 */
		mViewPager=(ViewPager) act.findViewById(R.id.pager);
	}

	public ViewPager getViewPager() {
		return mViewPager;
	}

	public ActionBar.Tab getTab1() {
		return mTab1;
	}

	public ActionBar.Tab getTab2() {
		return mTab2;
	}

	/**
	 * Two tabs are initialized and the names of them is being set.
	 * @param actionBar the ActionBar of the activity
	 */
	public void initializeTabs (ActionBar actionBar) {
		mTab1 = actionBar.newTab();
		mTab1.setText("Karte");
		
		mTab2 = actionBar.newTab();
		mTab2.setText("Liste");
	}
	
	/**
	 * This method adds the tabs to the ActionBar. It has to be called after the TabListener
	 * is set onto the tabs. Thats the reason why it is called in the EventToListener-Class.
	 * @param actionBar the ActionBar of the activity
	 */
	public void addTabs(ActionBar actionBar) {
		actionBar.addTab(mTab1);
		actionBar.addTab(mTab2);
	}

}