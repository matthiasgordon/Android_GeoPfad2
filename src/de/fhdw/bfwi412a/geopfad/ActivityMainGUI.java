//Class implemented by: Matthias Gordon

package de.fhdw.bfwi412a.geopfad;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;

public class ActivityMainGUI {

	ViewPager viewPager;
	final ActionBar mActionBar;
	ActionBar.Tab mTab1;
	ActionBar.Tab mTab2;	
	
	public ActivityMainGUI (ActivityMain act)
	{
		viewPager=(ViewPager) act.findViewById(R.id.pager);
		
		mActionBar = act.getActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0979BB")));
		mActionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#E6E6E6")));
		mActionBar.setIcon(R.drawable.actionbar_icon_white);
		initializeTabs(mActionBar);
	}

	public ViewPager getViewPager() {
		return viewPager;
	}
	
	public ActionBar getActionBar() {
		return mActionBar;
	}

	public ActionBar.Tab getTab1() {
		return mTab1;
	}

	public ActionBar.Tab getTab2() {
		return mTab2;
	}

	private void initializeTabs (ActionBar actionBar) {
		mTab1 = actionBar.newTab();
		mTab1.setText("Karte");
		
		mTab2=actionBar.newTab();
		mTab2.setText("Liste");
	}
	
	public void addTabs() {
		mActionBar.addTab(mTab1);
		mActionBar.addTab(mTab2);
	}

}