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
import android.view.View;
import android.view.View.OnClickListener;
/** Class implemented by: Marc Niedermeier
 * ActivityStartEventToListenerMapping starts functions in AppLogic 
 * when the User makes an event */

public class ActivityStartEventToListenerMapping implements OnClickListener {

	private ActivityStartGUI mGUI;
	private ActivityStartApplicationLogic mAppLogic;
	
	public ActivityStartEventToListenerMapping(ActivityStartGUI gui, ActivityStartApplicationLogic appLogic) {
		mGUI = gui;
		mAppLogic = appLogic;
		mGUI.getToActivityMainButton().setOnClickListener(this);
		mGUI.getBtnWeather().setOnClickListener(this);
	}

	/** onClick-method of OnClickListener is overwritten; checks which GUI-element 
	 * is clicked by case-statement and start the corresponding method in AppLogic
	 * @param v View that was clicked by the user*/
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		
		case R.id.ToActivityMainButton:
			mAppLogic.onToActivityMain();
			break;
		case R.id.btnWeather:
			mAppLogic.openWeatherDialog();
			break;
		}
	}
}