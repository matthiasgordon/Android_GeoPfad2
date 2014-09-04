package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.view.View.OnClickListener;

public class ActivityStartEventToListenerMapping implements OnClickListener {

	private ActivityStartGUI mGUI;
	private ActivityStartApplicationLogic mAppLogic;
	
	public ActivityStartEventToListenerMapping(ActivityStartGUI gui, ActivityStartApplicationLogic appLogic) {
		mGUI = gui;
		mAppLogic = appLogic;
		mGUI.getToActivityMainButton().setOnClickListener(this);
		mGUI.getBtnWeather().setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.ToActivityMainButton:
			mAppLogic.onToActivityMainButtonClicked();
			break;
		case R.id.btnWeather:
			mAppLogic.openWeatherDialog();
			break;
		}
	}
}