package de.fhdw.bfwi412a.geopfad;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ActivityStart extends Activity {
	
	private ActivityStartData mData;
	private ActivityStartGUI mGUI;
	private ActivityStartApplicationLogic mAppLogic;
	
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();	
		startService(new Intent(this, ServiceNotifyDistance.class));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.start_actionbar_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
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
	
	@Override
	protected void onDestroy() {
		stopService(new Intent(this, ServiceNotifyDistance.class));
		super.onDestroy();
	}

	private void initData() {
		mData = new ActivityStartData(this);
	}
	
	private void initGUI() {
		setContentView(R.layout.activity_start);
		mGUI = new ActivityStartGUI(this, mData);
	}
	
	private void initApplicationLogic() {
		mAppLogic = new ActivityStartApplicationLogic(this,mGUI,mData);
		mAppLogic.styleWeatherGUI();
	}
	
	private void initEventToListenerMapping() {
		new ActivityStartEventToListenerMapping(mGUI, mAppLogic);
	}
}