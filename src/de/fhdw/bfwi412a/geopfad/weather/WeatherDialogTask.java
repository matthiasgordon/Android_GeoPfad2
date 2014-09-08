package de.fhdw.bfwi412a.geopfad.weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;

/** Class implemented by: Marc Niedermeier
 * WheaterDialogTask is an AsnycTask that loads the weatherforecast if needed(dialog is requested)
 * in background so the actual GUI can be loaded without delays for the user
 * @param Void not used param
 * @param Void not used param
 * @param List<Weather> doInBackgroud-method returns list of weather-objects*/

public class WeatherDialogTask extends AsyncTask<Void, Void, List<Weather>>{
    private Context mContext;
    private WaitDialog mWaitDialog;
    private String mUrl = "http://weather.yahooapis.com/forecastrss?w=638139&u=c";
	
	public WeatherDialogTask(Context context) {
		mContext = context;
		mWaitDialog = new WaitDialog(mContext);
	}

	/** Method that runs before the doInBackground method has finished and sets
	 * a wait-message to the GUI; shows a wait-Dialog*/
	
	@Override
	protected void onPreExecute() {
		mWaitDialog.show();
		super.onPreExecute();

	}
	
	/**Method that runs in the background while rest of the GUI is loaded, loads and returns
	 * weather data
	 * @return weatherData that was loaded*/
	
	@Override
    protected List<Weather> doInBackground(Void... params) {
        	List<Weather> weatherData = new ArrayList<Weather>();
			try {
				WeatherDataLoader loader = new WeatherDataLoader();
				weatherData = loader.loadXmlFromNetwork(mUrl, mContext);
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return weatherData;
    }
	
	/** method that is called after doInBackground method has finished; 
	 * closes the wait-dialog;
	 * displays the loaded weather data in the weatherForecastDialog;
	 * @param result of the doInBackground method -> weather data*/

	@Override
	protected void onPostExecute(List<Weather> result) {
		super.onPostExecute(result);
		mWaitDialog.dismiss();
		Dialog mWeatherDialog = new WeatherForecastDialog(mContext, result);
		mWeatherDialog.show();
	}
}