package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;
import android.widget.Toast;


public class ActivityStartApplicationLogic {
	private ActivityStart mActivity;
	private ActivityStartData mData;
	private InternetConnectionCheck mConnected;
	static final int REQUESTCODECOUNTERVALUE = 1;
	
	public ActivityStartApplicationLogic(ActivityStart act, ActivityStartGUI gui, ActivityStartData data) {
		mActivity = act;
		mData = data;
		mConnected = new InternetConnectionCheck(mActivity);
	}

	/** Method is called when the button to ActivityMain is clicked; 
	 * starts ActivityMain*/
	
	public void onToActivityMainButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), ActivityMain.class);
		mData.getActivity().startActivityForResult(intent, REQUESTCODECOUNTERVALUE);
	}
	
	/** Method is called when weather-button is clicked;
	 * checks if internet is available;
	 * if available it starts a WeatherDialogTask, else it makes an error-toast */

	public void openWeatherDialog() {
		if(mConnected.isConnected()){
			WeatherDialogTask loader = new WeatherDialogTask(mActivity);
			loader.execute();
		}
		else{
			Toast.makeText(mActivity, R.string.no_internet,
			        Toast.LENGTH_SHORT).show();
		}
	}
}