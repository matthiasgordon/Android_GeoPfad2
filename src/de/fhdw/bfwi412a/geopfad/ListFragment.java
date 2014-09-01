package de.fhdw.bfwi412a.geopfad;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

public class ListFragment extends Fragment {
	
	static final int requestCode = 100;
	

	ListFragmentData mData;
	ListFragmentGUI mGUI;
	ListFragmentApplicationLogic mAppLogic;
	ListFragmentEventToListenerMapping mEventToListenerMapping;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.list_fragment, container, false);
		setHasOptionsMenu(true);
		initData();
		initGUI(mView);
		initApplicationLogic();
		initEventToListenerMapping();
		return mView;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		initData();
		initGUI(getView());
		initApplicationLogic();
		initEventToListenerMapping();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.addLocation:
			mAppLogic.addLocation();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		inflater.inflate(R.menu.location_actionbar_menu, menu);
		// get the searview
		MenuItem searchfield = menu.findItem(R.id.action_search);
		SearchView searchview = (SearchView) searchfield.getActionView();
		
		// Execute this when searching
		searchview.setOnQueryTextListener(mEventToListenerMapping);
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	private void initData() {
		mData = new ListFragmentData(this);
	}
	
	private void initGUI(View mView) {
		mGUI = new ListFragmentGUI(mView, mData);
	}
	
	private void initApplicationLogic() {
		mAppLogic = new ListFragmentApplicationLogic(this, mData, mGUI);
	}
	
	private void initEventToListenerMapping() {
		mEventToListenerMapping = new ListFragmentEventToListenerMapping(this, mData, mGUI, mAppLogic);
	}
	
}