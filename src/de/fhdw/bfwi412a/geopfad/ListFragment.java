package de.fhdw.bfwi412a.geopfad;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

public class ListFragment extends Fragment implements SearchView.OnQueryTextListener {
	
	static final int requestCode = 100;
	

	ListFragmentData mData;
	ListFragmentGUI mGUI;
	ListFragmentApplicationLogic mAppLogic;
	ListFragmentEventToListenerMapping mEventToListenerMapping;

	public ListFragment () {
		
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View mView = inflater.inflate(R.layout.list_fragment, container, false);
		setHasOptionsMenu(true);
		initData();
		initGUI(mView);
		initApplicationLogic();
		initEventToListenerMapping();
		return mView;
	}

	private void initData() {
		mData = new ListFragmentData(this);
	}
	
	private void initGUI(View mView) {
		mGUI = new ListFragmentGUI(mView, mData);
	}
	
	private void initApplicationLogic() {
		mAppLogic = new ListFragmentApplicationLogic(mData, mGUI);
	}
	
	private void initEventToListenerMapping() {
		mEventToListenerMapping = new ListFragmentEventToListenerMapping(mGUI, mAppLogic);
	}

	public void addLocation() {
		Intent intent = new Intent(getActivity(), AddLocation.class);
		startActivityForResult(intent, requestCode);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.addLocation:
	            addLocation();
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
	    searchview.setOnQueryTextListener(this);

	    super.onCreateOptionsMenu(menu, inflater);
	}
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		 if (resultCode == 0 && requestCode == ListFragment.requestCode) {
			
		 }
		
	}

	@Override
	public boolean onQueryTextChange(String mEntry) {
		// TODO Auto-generated method stub
		List <Ort> Orte = mData.getOrte();
		List <Ort> shownOrte = new ArrayList <Ort>();
		for(Ort currOrt : Orte){
			if(currOrt.getName().toUpperCase(Locale.GERMAN)
					.contains(mEntry.toUpperCase(Locale.GERMAN))){
				shownOrte.add(currOrt);
			}		
		}
//		if(shownOrte.size() == 0){
//			shownOrte.add(new Ort("Error"));
//		}
			mGUI.fillListView(getView(), shownOrte);
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}