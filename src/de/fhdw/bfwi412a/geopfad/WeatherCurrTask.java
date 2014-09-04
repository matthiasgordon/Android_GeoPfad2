package de.fhdw.bfwi412a.geopfad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;
import android.view.View;

public class WeatherCurrTask extends AsyncTask<Void, Void, List<Weather>> {
    ActivityStart mActivity;
    ActivityStartData mData; 
    ActivityStartGUI mGUI;
	
	public WeatherCurrTask(ActivityStart activityStart, ActivityStartData data, ActivityStartGUI gui) {
		mActivity = activityStart;
		mData = data;
		mGUI = gui;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		setWeatherError();
	}
	
	@Override
    protected List<Weather> doInBackground(Void... params) {
        	List<Weather> test = new ArrayList<Weather>();
			try {
				WeatherDataLoader loader = new WeatherDataLoader();
				test = loader.loadXmlFromNetwork("http://weather.yahooapis.com/forecastrss?w=638139&u=c");
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return test;
    }

	@Override
	protected void onPostExecute(List<Weather> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
			fillWeatherGUI(result);
	}

	public void fillWeatherGUI(List<Weather> mResult){
		if(mGUI.getCurrWeather()!= null){
			mGUI.getCurrWeather().setVisibility(View.VISIBLE);
			mGUI.getLocation().setVisibility(View.VISIBLE);
			mGUI.getBtnWeather().setVisibility(View.VISIBLE);
			mGUI.getTemperature().setText(mResult.get(0).getTemperatureHigh() + "°C");
			WeatherDataTransform mTransformer= new WeatherDataTransform();
			mGUI.getCurrWeather().setImageResource(mActivity.getResources()
					.getIdentifier("weather_large_" + mTransformer.getWeatherImageName(mResult
							.get(0).getWeatherCode()), "drawable", mActivity.getPackageName()));
		}
	}
	
	public void setWeatherError(){
		if(mGUI.getCurrWeather()!= null){
			mGUI.getCurrWeather().setVisibility(View.INVISIBLE);
			mGUI.getLocation().setVisibility(View.INVISIBLE);
			mGUI.getBtnWeather().setVisibility(View.INVISIBLE);
			mGUI.mTemperature.setText("Wetterdaten werden geladen..");
		}
	}
}