/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	B�ttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - A�R hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation ver�ndert werden.
**
**	Ohne ausdr�ckliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zug�nglich gemacht werden.
**
**	Eine Vervielf�ltigung und Ver�ffentlichung des Quellcodes ohne ausdr�ckliche
**	Genehmigung - auch in Ausz�gen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;

import java.util.List;

import android.content.Context;
import android.content.Intent;

public class IntentBuilder {
	
	public Intent buildIntentForActivityLocations(Context context, List <Ort> orte, int position) {
		Intent intent = new Intent (context, ActivityLocations.class);
		intent.putExtra("Ortname", orte.get(position).getName());
		intent.putExtra("imageUrl", orte.get(position).getImgUrl());
		intent.putExtra("imageUrl2", orte.get(position).getImgUrl2());
		intent.putExtra("imageUrl3", orte.get(position).getImgUrl3());
		intent.putExtra("extImageUrl", orte.get(position).getExtImgUrl());
		intent.putExtra("about", orte.get(position).getAbout());
		intent.putExtra("latitude", orte.get(position).getLat());
		intent.putExtra("longitude", orte.get(position).getLng());
		intent.putExtra("visitKey", orte.get(position).getVisitKey());
		return intent;
	}
}