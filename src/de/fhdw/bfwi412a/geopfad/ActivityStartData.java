package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

public class ActivityStartData {
	private static final String PREFS_NAME = "MYPrefernceFile";
	
	private ActivityStart mActivity;
	private List<Ort> mOrte;
	private int mAchievements;
	
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