package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

public class ActivityStartData {
	public static final String PREFS_NAME = "MYPrefernceFile";
	
	private ActivityStart mActivity;
	List<Ort> mOrte;
	List <Weather> mWeatherData;
	int mAchievements;
	boolean LoadWeatherDataSuccess = true;
	
	public ActivityStartData(ActivityStart act) {
		mActivity = act;
		mOrte = Orte_DOM_Parser.getOrteFromFile(act);
		mAchievements = countAchievements(mOrte);
		WeatherBGPullParser parser = new WeatherBGPullParser();
		mWeatherData = parser.getWeatherData();
		if(mWeatherData == null)
			LoadWeatherDataSuccess = false;
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

	public List<Weather> getWeatherData() {
		return mWeatherData;
	}

	public boolean isLoadWeatherDataSuccess() {
		return LoadWeatherDataSuccess;
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