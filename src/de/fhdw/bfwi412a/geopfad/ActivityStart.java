package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/** *
 * Class implemented by: Marc Niedermeier
 * - The ActivityStart is the LauncherActivity of the GeoPfad-Application
 * - it contains weather data from Yahoo!-XML which  is parsed in an AsyncTask vie XMLPullParser
 * - shows "Schnecken"-image which shows achievement(how many locations have been visited?) of user
 * - guides to ActivityMain 
 */

public class ActivityStart extends Activity {
	
	private ActivityStartData mData;
	private ActivityStartGUI mGUI;
	private ActivityStartApplicationLogic mAppLogic;

	/** 
	 * in onCreate()-method the ServiceNotifyDistance is started 
	 * */
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();	
		startService(new Intent(this, ServiceNotifyDistance.class));
	}
	
	/** actionbar items are loaded*/
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.start_actionbar_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	/** when refresh-button is pressed entire activity is loaded again as in onCreate()*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	    case R.id.refreshWeatherData:
	      initData();
	      initGUI();
	      initApplicationLogic();
	      initEventToListenerMapping();
	      break;
	    }
		return super.onOptionsItemSelected(item);
	}
	
	/** ServiceNotifyDistance is stopped when ActivityStart is destroyed*/
	@Override
	protected void onDestroy() {
		stopService(new Intent(this, ServiceNotifyDistance.class));
		super.onDestroy();
	}

	private void initData() {
		mData = new ActivityStartData(this);
	}
	/** after data and GUI are loaded the "Schnecken"-view is filled and the WeatherCurrTask 
	 * is started, if internet is available, else an error-message will be shown in the GUI*/
	private void initGUI() {
		setContentView(R.layout.activity_start);
		mGUI = new ActivityStartGUI(this);
		mGUI.setSchneckenView(mData.getAchievements());
		InternetConnectionCheck connected = new InternetConnectionCheck(this);
		if(connected.isConnected()){
			WeatherCurrTask loader = new WeatherCurrTask(this, mGUI);
			loader.execute();
		}else
			mGUI.setWeatherInternetError();
	}
	
	private void initApplicationLogic() {
		mAppLogic = new ActivityStartApplicationLogic(this,mGUI,mData);
	}
	
	private void initEventToListenerMapping() {
		new ActivityStartEventToListenerMapping(mGUI, mAppLogic);
	}
}