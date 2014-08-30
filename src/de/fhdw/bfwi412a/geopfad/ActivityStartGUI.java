package de.fhdw.bfwi412a.geopfad;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Button;

public class ActivityStartGUI {

	Button mToActivityMainButton;
	final ActionBar mActionBar;
	
	public ActivityStartGUI(ActivityStart act) {
		mActionBar = act.getActionBar();
		mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0979BB")));
		mActionBar.setIcon(R.drawable.actionbar_icon_white);
		mToActivityMainButton = (Button) act.findViewById(R.id.ToActivityMainButton);
	}

	public Button getToActivityMainButton() {
		return mToActivityMainButton;
	}
	
	
	
}
