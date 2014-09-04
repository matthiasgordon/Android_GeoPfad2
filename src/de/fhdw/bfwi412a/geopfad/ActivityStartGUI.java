package de.fhdw.bfwi412a.geopfad;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityStartGUI {
	ActivityStart mActivity;
	ActivityStartData mData;
	TextView mTemperature;
	TextView mLocation;
	ImageView mSchneckenBild;
	ImageView mCurrWeather;
	Button mToActivityMainButton;
	Button btnWeather;
	
	public ActivityStartGUI(ActivityStart act, ActivityStartData data) {
		mActivity = act;
		mData = data;
		mTemperature = (TextView) mActivity.findViewById(R.id.currDegree);
		mCurrWeather = (ImageView) mActivity.findViewById(R.id.imgWeather);
		mLocation = (TextView) mActivity.findViewById(R.id.Location);
		mToActivityMainButton = (Button) mActivity.findViewById(R.id.ToActivityMainButton);
		mSchneckenBild = (ImageView) mActivity.findViewById(R.id.schneckeView);
		btnWeather = (Button) mActivity.findViewById(R.id.btnWeather);
	}
		
	public TextView getTemperature() {
		return mTemperature;
	}

	public TextView getLocation() {
		return mLocation;
	}

	public ImageView getSchneckenBild() {
		return mSchneckenBild;
	}

	public ImageView getCurrWeather() {
		return mCurrWeather;
	}

	public Button getToActivityMainButton() {
		return mToActivityMainButton;
	}

	public Button getBtnWeather() {
		return btnWeather;
	}
//
//	public void fillWeatherGUI(List<Weather> mResult){
//		mTemperature.setText(mResult.get(0).getTemperatureHigh() + "°C");
//		WeatherDataTransform mTransformer= new WeatherDataTransform();
//		mCurrWeather.setImageResource(mActivity.getResources()
//				.getIdentifier("weather_large_" + mTransformer.getWeatherImageName(mResult
//						.get(0).getWeatherCode()), "drawable", mActivity.getPackageName()));
//	}
//	
//	public void fillWeatherGUI(List<Weather> mResult){
//		mGUI.getTemperature().setText(mResult.get(0).getTemperatureHigh() + "°C");
//		WeatherDataTransform mTransformer= new WeatherDataTransform();
//		mGUI.getCurrWeather().setImageResource(mActivity.getResources()
//				.getIdentifier("weather_large_" + mTransformer.getWeatherImageName(mResult
//						.get(0).getWeatherCode()), "drawable", mActivity.getPackageName()));
//	
	public void setWeatherError(){
		btnWeather.setVisibility(View.INVISIBLE);
		mCurrWeather.setVisibility(View.INVISIBLE);
		mLocation.setVisibility(View.INVISIBLE);
		mTemperature.setText("Kein Internet -> Wetterdaten nicht verfügbar!");
	}
	
	public void setSchneckenView(String imageUrl){
		Bitmap picture = null;
		picture = ScalingUtilities.fitScale(mActivity.getResources(),mActivity.getResources()
						.getIdentifier(imageUrl, "drawable", 
								mActivity.getPackageName()), mActivity, "schnecke");
		mSchneckenBild.setImageBitmap(picture);
	}	
}