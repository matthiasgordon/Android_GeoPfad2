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

import java.util.ArrayList;
import java.util.List;

import de.fhdw.bfwi412a.geopfad.R;

/**Class implemented by: Marc Niedermeier 
 * ActivityStartData loads the Data and provides it for the Activity except for the 
 * weather data which is loaded by an asynctask*/

public class ActivityStartData {
	private static final String PREFS_NAME = "MYPrefernceFile";
	
	private ActivityStart mActivity;
	private List<Ort> mOrte;
	private int mAchievements;
	
	/** The constructor loads locations with the Orte_DOM_Parser and saves achievements by the 
	 * countAchievements-method*/
	
	public ActivityStartData(ActivityStart act) {
		mActivity = act;
		mOrte = Orte_DOM_Parser.getOrteFromFile(act);
		mAchievements = countAchievements(mOrte);
	}
	
	public ActivityStart getActivity() {
		return mActivity;
	}

	public List<Ort> getOrte() {
		return mOrte;
	}

	public int getAchievements() {
		return mAchievements;
	}

	/** This method counts the visited location by comparing the visit attribute for
	 * each location in the SharedPreferences-File with the @string visited
	 * @param orte the list of locations that are compared to the @string visited
	 * @return number of visited locations*/
	
	private int countAchievements(List <Ort> orte){
		List <String> test = new ArrayList <String>();
		for (Ort currOrt : orte){
			String visited = mActivity.getSharedPreferences(PREFS_NAME, 0)
					.getString(currOrt.getVisitKey(),"Fehler");
			if(visited.equals(mActivity.getResources().getString(R.string.visited))){
				test.add(visited);
			}
		}
		return test.size();
	}
}