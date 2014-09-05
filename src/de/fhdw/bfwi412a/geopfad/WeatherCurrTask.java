package de.fhdw.bfwi412a.geopfad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;
import android.view.View;

/** Class implemented by: Marc Niedermeier
 * WheaterCurrTask is an AsnycTask that loads the currentWeather if needed(tablet-version)
 * in background so the actual GUI can be loaded without delays for the user
 * @param Void not used param
 * @param Void not used param
 * @param List<Weather> doInBackgroud-method returns list of weather-objects*/

public class WeatherCurrTask extends AsyncTask<Void, Void, List<Weather>> {
    private ActivityStart mActivity; 
    private ActivityStartGUI mGUI;
	
	public WeatherCurrTask(ActivityStart activityStart, ActivityStartGUI gui) {
		mActivity = activityStart;
		mGUI = gui;
	}

	/** Method that runs before the doInBackground method has finished and sets
	 * a wait-message to the GUI*/
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		setWeatherError();
	}
	
	/**Method that runs in the background while rest of the GUI is loaded, loads and returns
	 * weather data
	 * @return weatherData that was loaded*/
	
	@Override
    protected List<Weather> doInBackground(Void... params) {
        	List<Weather> weatherData = new ArrayList<Weather>();
			try {
				WeatherDataLoader loader = new WeatherDataLoader();
				weatherData = loader.loadXmlFromNetwork("http://weather.yahooapis.com/forecastrss?w=638139&u=c");
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return weatherData;
    }
	
	/** method that is called after doInBackground method has finished; it displays
	 * the loaded weather data in the GUI
	 * @param result of the doInBackground method -> weather data*/

	@Override
	protected void onPostExecute(List<Weather> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
			fillWeatherGUI(result);
	}

	/** Method that fills the GUI with the loaded weather data
	 * @param loaded mResult of the DoInBackground method (loaded weather data)*/
	
	public void fillWeatherGUI(List<Weather> mResult){
		if(mGUI.getCurrWeather()!= null){
			mGUI.getCurrWeather().setVisibility(View.VISIBLE);
			mGUI.getLocation().setVisibility(View.VISIBLE);
			mGUI.getBtnWeather().setVisibility(View.VISIBLE);
			mGUI.getTemperature().setText(mResult.get(0).getTemperatureHigh() + "�C");
			WeatherDataTransform mTransformer= new WeatherDataTransform();
			mGUI.getCurrWeather().setImageResource(mActivity.getResources()
					.getIdentifier("weather_large_" + mTransformer.getWeatherImageName(mResult
							.get(0).getWeatherCode()), "drawable", mActivity.getPackageName()));
		}
	}
	
	/** Method that sets wait dialog in the GUI; is called befor doInBackground*/
	
	public void setWeatherError(){
		if(mGUI.getCurrWeather()!= null){
			mGUI.getCurrWeather().setVisibility(View.INVISIBLE);
			mGUI.getLocation().setVisibility(View.INVISIBLE);
			mGUI.getBtnWeather().setVisibility(View.INVISIBLE);
			mGUI.getTemperature().setText("Wetterdaten werden geladen..");
		}
	}
}