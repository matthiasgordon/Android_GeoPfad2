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
	
	public void onToActivityMainButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), ActivityMain.class);
		mData.getActivity().startActivityForResult(intent, REQUESTCODECOUNTERVALUE);
	}

	public void openWeatherDialog() {
		if(mConnected.isConnected()){
			WeatherDialogTask loader = new WeatherDialogTask(mActivity);
			loader.execute();
		}
		else{
			Toast.makeText(mActivity, "Kein Internet -> Wetterdaten nicht verfügbar!",
			        Toast.LENGTH_SHORT).show();
		}
	}
}