package de.fhdw.bfwi412a.geopfad;

import android.view.View;
import android.view.View.OnClickListener;

public class ActivityAddLocationEventToListenerMapping implements OnClickListener{
	
	private ActivityAddLocationApplicationLogic mAddLocAppLogic;
	private ActivityAddLocationGUI mAddLocGUI;
	
	public ActivityAddLocationEventToListenerMapping(ActivityAddLocationApplicationLogic addLocAppLogic, ActivityAddLocationGUI addLocGui) {
		mAddLocAppLogic = addLocAppLogic;
		mAddLocGUI = addLocGui;
		mAddLocGUI.getmBtnbildurl().setOnClickListener(this);
		mAddLocGUI.getmBtnCoordination().setOnClickListener(this);
		mAddLocGUI.getmBtnAnlegen().setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.btnbildurl:
			mAddLocAppLogic.changeToFilechooser();
			break;
		case R.id.btnAddLocationCoordination:
			mAddLocAppLogic.setCoordination();
			break;
		case R.id.btnAnlegen:
			mAddLocAppLogic.setOrt();
			break;
		}
	}
}
