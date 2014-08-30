package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;

public class ActivityStartApplicationLogic {

	ActivityStartGUI mGUI;
	ActivityStartData mData;
	static final int REQUESTCODECOUNTERVALUE = 1;
	
	public ActivityStartApplicationLogic(ActivityStartGUI gui, ActivityStartData data) {
		mGUI = gui;
		mData = data;
	}
	
	public void onToActivityMainButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), ActivityMain.class);
		mData.getActivity().startActivityForResult(intent, REQUESTCODECOUNTERVALUE);
	}

}
