package de.fhdw.bfwi412a.geopfad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragment extends Fragment {
	
	MapFragmentData mData;
	MapFragmentGUI mGUI;
	MapFragmentApplicationLogic mApplicationLogic;
	
	public MapFragment () {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.map_fragment, container, false);
		initData();
		initGUI(mView);
		initApplicationLogic();
		initEventToListenerMapping();
		return mView;
	}	

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		initGUI(getView());
	}
	
	private void initData () {
		mData = new MapFragmentData(this);
	}

	private void initGUI (View view) {
		mGUI = new MapFragmentGUI(this, view);
		mGUI.styleMap(mData.getRouteCoordinates(), mData.getOrte(), 0, mData.getVisitStatus());
	}
	
	private void initApplicationLogic () {
		mApplicationLogic = new MapFragmentApplicationLogic(mData, mGUI);
	}
	
	private void initEventToListenerMapping () {
		new MapFragmentEventToListener(mGUI, mApplicationLogic);
	}
}