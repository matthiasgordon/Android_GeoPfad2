package de.fhdw.bfwi412a.geopfad;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;

public class ActivityMainGUI implements TabListener {

	ViewPager viewPager;
	final ActionBar mActionBar;
	
	public ActivityMainGUI (ActivityMain act)
	{
		viewPager=(ViewPager) act.findViewById(R.id.pager);
		
		mActionBar = act.getActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0979BB")));
		mActionBar.setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor("#E6E6E6")));
		mActionBar.setIcon(R.drawable.actionbar_icon_white);
		addTabs(mActionBar);
	}

	public ViewPager getViewPager() {
		return viewPager;
	}
	
	public ActionBar getActionBar() {
		return mActionBar;
	}

	private void addTabs (ActionBar actionBar) {
		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("Karte");
		tab1.setTabListener(this);
		
		ActionBar.Tab tab2=actionBar.newTab();
		tab2.setText("Liste");
		tab2.setTabListener(this);
		
		actionBar.addTab(tab1);
		actionBar.addTab(tab2);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
	}
	
}