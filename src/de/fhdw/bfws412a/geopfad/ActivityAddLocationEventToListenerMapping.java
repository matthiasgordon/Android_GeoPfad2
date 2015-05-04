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

/**This class manages the onClick event of the button and calls the appropriate method when an event occurs.*/
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
	
	/**Calls the appropriate method when an event occurs*/
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
