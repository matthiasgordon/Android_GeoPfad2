package de.fhdw.bfwi412a.geopfad;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class ActivityStartApplicationLogic {
	ActivityStart mActivity;
	ActivityStartGUI mGUI;
	ActivityStartData mData;
	static final int REQUESTCODECOUNTERVALUE = 1;
	
	public ActivityStartApplicationLogic(ActivityStart act, ActivityStartGUI gui, ActivityStartData data) {
		mActivity = act;
		mGUI = gui;
		mData = data;
	}
	
	public void onToActivityMainButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), ActivityMain.class);
		mData.getActivity().startActivityForResult(intent, REQUESTCODECOUNTERVALUE);
	}
	
	public boolean isOnline() {
	    ConnectivityManager cm =
	        (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}

	public void styleWeatherGUI(){
		if(mGUI.getTemperature() != null && mGUI.getTemperature() != null){
			if(isOnline() && mData.LoadWeatherDataSuccess)
				mGUI.fillWeatherGUI();
			else
				mGUI.setWeatherError();
			}
	}
	
	public void openWeatherDialog() {
		if(isOnline() && mData.LoadWeatherDataSuccess){
			final Dialog dialog = new WeatherForecastDialog(mActivity, mGUI, mData.getWeatherData());
			dialog.show();
		}
		else{
			Toast.makeText(mActivity, "Kein Internet -> Wetterdaten nicht verfügbar!",
			        Toast.LENGTH_SHORT).show();
		}
	}
}