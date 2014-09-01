package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.AdapterView.OnItemClickListener;

public class ListFragmentEventToListenerMapping implements OnItemClickListener, SearchView.OnQueryTextListener {
	
	ListFragment mFrag;
	ListFragmentData mData;
	ListFragmentGUI mGUI;
	ListFragmentApplicationLogic mAppLogic;
	
	public ListFragmentEventToListenerMapping(ListFragment frag, ListFragmentData data, ListFragmentGUI gui, ListFragmentApplicationLogic applogic) {
		mFrag = frag;
		mAppLogic = applogic;
		mData = data;
		mGUI = gui;
		mGUI.getListOrte().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		mAppLogic.showDetailView(position);
	}

	@Override
	public boolean onQueryTextChange(String mEntry) {
		List <Ort> Orte = mData.getOrte();
		List <Ort> shownOrte = new ArrayList <Ort>();
		for(Ort currOrt : Orte){
			if(currOrt.getName().toUpperCase(Locale.GERMAN)
					.contains(mEntry.toUpperCase(Locale.GERMAN))){
				shownOrte.add(currOrt);
			}		
		}
			mGUI.fillListView(mFrag.getView(), shownOrte);
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String arg0) {
		return false;
	}
}
