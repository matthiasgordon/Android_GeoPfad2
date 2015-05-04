/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	Böttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - AäR hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation verändert werden.
**
**	Ohne ausdrückliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zugänglich gemacht werden.
**
**	Eine Vervielfältigung und Veröffentlichung des Quellcodes ohne ausdrückliche
**	Genehmigung - auch in Auszügen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;

import de.fhdw.bfwi412a.geopfad.R;
import de.fhdw.bfws412a.geopfad.weather.WeatherDialogTask;
import android.content.Intent;
import android.widget.Toast;

/**Class implemented by: Marc Niedermeier
 * Class serves all the logic which is needed for ActivityStart
 * */

public class ActivityStartApplicationLogic {
	private ActivityStart mActivity;
	private ActivityStartData mData;
	private InternetConnectionCheck mConnected;
	
	public ActivityStartApplicationLogic(ActivityStart act, ActivityStartGUI gui, ActivityStartData data) {
		mActivity = act;
		mData = data;
		mConnected = new InternetConnectionCheck(mActivity);
	}

	/** Method is called when the button to ActivityMain is clicked; 
	 * starts ActivityMain*/
	
	public void onToActivityMain() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), ActivityMain.class);
		mData.getActivity().startActivity(intent);
	}
	
	public void onToActivityAbout() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), ActivityAbout.class);
		mData.getActivity().startActivity(intent);
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