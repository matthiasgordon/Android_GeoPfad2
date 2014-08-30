package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class ListFragmentEventToListenerMapping implements OnItemClickListener {
	
	ListFragmentGUI mGUI;
	ListFragmentApplicationLogic mAppLogic;
	
	public ListFragmentEventToListenerMapping(ListFragmentGUI gui, ListFragmentApplicationLogic applogic) {
		mAppLogic = applogic;
		mGUI = gui;
		mGUI.getListOrte().setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		mAppLogic.showDetailView(position);
	}	
}
