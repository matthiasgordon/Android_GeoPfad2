package de.fhdw.bfwi412a.geopfad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Class implemented by: Matthias Gordon
 * The class extends a FragmentPagerAdapter which sets the right fragments
 * to the ViewPager
 */
class FragmentAdapter extends FragmentPagerAdapter
{
	private String mMapData;
	
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public FragmentAdapter(FragmentManager fm, String MapData) {
		super(fm);
		mMapData = MapData;
	}

	/**The method is passing the fragment depending on the fragmentID.
	 * If there is any MapData passed to the constructor it is passed to the MapFragment
	 * ID 0 = MapFragment ---> the left fragment
	 * ID 1 = ListFragment ---> the right fragment
	 * @param fragmentID the ID of the ViewPager page
	 * @return fragment the fragment that belongs to the page
	 */
	@Override
	public Fragment getItem(int fragmentID) {
		Fragment fragment=null;
		
		if(fragmentID == 0) {
			if(mMapData != null){
				fragment=new MapFragment(mMapData);
			}
			
			else {
				fragment=new MapFragment();
			}		
		}
		
		if(fragmentID == 1)
		{
			fragment=new ListFragment();
		}
		return fragment;
	}

	/**
	 * The method passes the number of fragments to the FragmentPagerAdapter
	 * @return number of fragments
	 */
	@Override
	public int getCount() {
		return 2;
	}
	
}