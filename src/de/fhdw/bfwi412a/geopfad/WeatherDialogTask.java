package de.fhdw.bfwi412a.geopfad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;

public class WeatherDialogTask extends AsyncTask<Void, Void, List<Weather>>{
    private Context mContext;
    private WaitDialog mWaitDialog;
	
	public WeatherDialogTask(Context context) {
		mContext = context;
		mWaitDialog = new WaitDialog(mContext);
	}

	@Override
	protected void onPreExecute() {
		mWaitDialog.show();
		super.onPreExecute();

	}
	
	@Override
    protected List<Weather> doInBackground(Void... params) {
        	List<Weather> mWeatherData = new ArrayList<Weather>();
			try {
				WeatherDataLoader loader = new WeatherDataLoader();
				mWeatherData = loader.loadXmlFromNetwork("http://weather.yahooapis.com/forecastrss?w=638139&u=c");
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return mWeatherData;
    }

	@Override
	protected void onPostExecute(List<Weather> result) {
		super.onPostExecute(result);
		mWaitDialog.dismiss();
		Dialog mWeatherDialog = new WeatherForecastDialog(mContext, result);
		mWeatherDialog.show();
	}
}