package de.fhdw.bfwi412a.geopfad;

import android.app.Dialog;
import android.content.Context;

public class WaitDialog extends Dialog{
	
	public WaitDialog(Context context) {
		super(context);
		setContentView(R.layout.wait_dialog);
	}
}