package de.fhdw.bfwi412a.geopfad;

import android.app.Dialog;
import android.content.Context;

/**Class implemented by Marc Niedermeier
 * WaitDialog is displayed when the user has to wait for the WeatherForecastDialog
 * and shows only a simply wait-message*/

public class WaitDialog extends Dialog{
	
	public WaitDialog(Context context) {
		super(context);
		setContentView(R.layout.wait_dialog);
	}
}