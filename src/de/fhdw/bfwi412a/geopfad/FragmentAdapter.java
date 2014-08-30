package de.fhdw.bfwi412a.geopfad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class MyAdapter extends FragmentPagerAdapter
{

	public MyAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		Fragment fragment=null;
		if(arg0 == 0)
		{
			fragment=new MapFragment();
		}
		
		if(arg0 == 1)
		{
			fragment=new ListFragment();
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return 2;
	}
	
}