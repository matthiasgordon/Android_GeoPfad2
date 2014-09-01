//Class implemented by: Matthias Gordon

package de.fhdw.bfwi412a.geopfad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class FragmentAdapter extends FragmentPagerAdapter
{

	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}

	//Passing the fragment depending on the fragmentID
	//ID 0 = MapFragment ---> the left fragment
	//ID 1 = ListFragment ---> the right fragment
	@Override
	public Fragment getItem(int fragmentID) {
		Fragment fragment=null;
		if(fragmentID == 0)
		{
			fragment=new MapFragment();
		}
		
		if(fragmentID == 1)
		{
			fragment=new ListFragment();
		}
		return fragment;
	}

	//Passing the count of fragment
	@Override
	public int getCount() {
		return 2;
	}
	
}