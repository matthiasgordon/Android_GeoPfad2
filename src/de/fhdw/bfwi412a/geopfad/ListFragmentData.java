package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.support.v4.app.FragmentActivity;

public class ListFragmentData {
	
	List<Ort> mOrte;
	FragmentActivity mActivity;
	
	public ListFragmentData(ListFragment mFrag) {
		
		mOrte = Orte_DOM_Parser.getOrteFromFile(mFrag.getActivity());
		mActivity = mFrag.getActivity();
	}

	public List<Ort> getOrte() {
		return mOrte;
	}

	public FragmentActivity getActivity() {
		return mActivity;
	}	
}
