package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ActivityStartData {
	public static final String PREFS_NAME = "MYPrefernceFile";
	
	private ActivityStart mActivity;
	List<Ort> mOrte;
	int mAchievements;
	List <Weather> mWeatherData;
	boolean LoadWeatherDataSuccess = true;
	
	public ActivityStartData(ActivityStart act) {
		mActivity = act;
		mOrte = Orte_DOM_Parser.getOrteFromFile(act);
		mAchievements = countAchievements(mOrte);
		mWeatherData = getCurrWeather();
		
	}

	private List<Weather> getCurrWeather() {
	    HandleXML obj; 
	    List <Weather> weatherData = new ArrayList<Weather>();
	    
		obj = new HandleXML("http://weather.yahooapis.com/forecastrss?w=638139&u=c");
	    obj.fetchXML();
	      while(obj.parsingComplete);
	    for(int i=0; i < obj.getWeatherCodes().size(); i++){
	    	Weather currWeather = new Weather();
	
	    	currWeather.setDate(obj.getWeatherDates().get(i));
	    	currWeather.setTemperatureHigh(obj.getWeatherTempsHigh().get(i));
	    	currWeather.setTemperatureLow(obj.getWeatherTempsLow().get(i));
	    	currWeather.setWeatherCode(obj.getWeatherCodes().get(i));
	    	weatherData.add(currWeather);
	    }
	    LoadWeatherDataSuccess = obj.isInternetAcces();
		return weatherData;
	}

	private int countAchievements(List <Ort> orte){
		List <String> test = new ArrayList <String>();
		for (Ort currOrt : orte){
			String visited = mActivity.getSharedPreferences(PREFS_NAME, 0)
					.getString(currOrt.getVisitKey(),"Fehler");
			if(visited.equals("Bereits besucht.")){
				test.add(visited);
			}
		}
		
		return test.size();
	}
	
	public boolean isOnline() {
	    ConnectivityManager cm =
	        (ConnectivityManager) mActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
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
}