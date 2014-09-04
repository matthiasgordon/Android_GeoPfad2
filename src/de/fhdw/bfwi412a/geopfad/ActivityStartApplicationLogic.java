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
	InternetConnectionCheck mConnected;
	static final int REQUESTCODECOUNTERVALUE = 1;
	
	public ActivityStartApplicationLogic(ActivityStart act, ActivityStartGUI gui, ActivityStartData data) {
		mActivity = act;
		mGUI = gui;
		mData = data;
		mConnected = new InternetConnectionCheck(mActivity);
	}
	
	public void onToActivityMainButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), ActivityMain.class);
		mData.getActivity().startActivityForResult(intent, REQUESTCODECOUNTERVALUE);
	}

//	public void styleWeatherGUI(){
//		if(mGUI.getTemperature() != null && mGUI.getTemperature() != null){
//			if(isOnline())
//				mGUI.fillWeatherGUI();
//			else
//				mGUI.setWeatherError();
//			}
//	}
	
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
	
//	public boolean isOnline() {
//	    ConnectivityManager cm =
//	        (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
//	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
//	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
//	        return true;
//	    }
//	    return false;
//	}

	public void fillSchneckenView(){
		mGUI.setSchneckenView(getImageUrl(mData.getAchievements()));
	}
	
	private String getImageUrl (int achievement){
		String imageUrl = "prozent_0";
		if(achievement > 17){
			imageUrl = "prozent_100";
		}else{
				
			switch(achievement){
			case 0:
				imageUrl = "prozent_0";
				break;
			case 1:
				imageUrl = "prozent_6";
				break;
			case 2:
				imageUrl = "prozent_12";
				break;
			case 3:
				imageUrl = "prozent_18";
				break;
			case 4:
				imageUrl = "prozent_24";
				break;
			case 5:
				imageUrl = "prozent_29";
				break;
			case 6:
				imageUrl = "prozent_35";
				break;
			case 7:
				imageUrl = "prozent_41";
				break;
			case 8:
				imageUrl = "prozent_47";
				break;
			case 9:
				imageUrl = "prozent_53";
				break;
			case 10:
				imageUrl = "prozent_59";
				break;
			case 11:
				imageUrl = "prozent_65";
				break;
			case 12:
				imageUrl = "prozent_71";
				break;
			case 13:
				imageUrl = "prozent_76";
				break;
			case 14:
				imageUrl = "prozent_82";
				break;
			case 15:
				imageUrl = "prozent_88";
				break;
			case 16:
				imageUrl = "prozent_94";
				break;
			case 17:
				imageUrl = "prozent_100";
				break;
			}
		}
			return imageUrl;
	}
}