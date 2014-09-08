package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.view.View.OnClickListener;
/** Class implemented by: Marc Niedermeier
 * ActivityStartEventToListenerMapping starts functions in AppLogic 
 * when the User makes an event */

public class ActivityStartEventToListenerMapping implements OnClickListener {

	private ActivityStartGUI mGUI;
	private ActivityStartApplicationLogic mAppLogic;
	
	public ActivityStartEventToListenerMapping(ActivityStartGUI gui, ActivityStartApplicationLogic appLogic) {
		mGUI = gui;
		mAppLogic = appLogic;
		mGUI.getToActivityMainButton().setOnClickListener(this);
		mGUI.getBtnWeather().setOnClickListener(this);
	}

	/** onClick-method of OnClickListener is overwritten; checks which GUI-element 
	 * is clicked by case-statement and start the corresponding method in AppLogic
	 * @param v View that was clicked by the user*/
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.ToActivityMainButton:
			mAppLogic.onToActivityMain();
			break;
		case R.id.btnWeather:
			mAppLogic.openWeatherDialog();
			break;
		}
	}
}