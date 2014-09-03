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
		setSchneckenView();
		btnWeather = (Button) mActivity.findViewById(R.id.btnWeather);
	}
		
	public TextView getTemperature() {
		return mTemperature;
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

	public void fillWeatherGUI(){
		mTemperature.setText(mData.getWeatherData().get(0).getTemperatureHigh() + "°C");
		WeatherDataTransform mTransformer= new WeatherDataTransform();
		mCurrWeather.setImageResource(mActivity.getResources()
				.getIdentifier("weather_large_" + mTransformer.getWeatherImageName(mData.getWeatherData()
						.get(0).getWeatherCode()), "drawable", mActivity.getPackageName()));
	}
	
	public void setWeatherError(){
		btnWeather.setVisibility(View.INVISIBLE);
		mCurrWeather.setVisibility(View.INVISIBLE);
		mLocation.setVisibility(View.INVISIBLE);
		mTemperature.setText("Kein Internet -> Wetterdaten nicht verfügbar!");
	}
	
	public void setSchneckenView(){
		Bitmap picture = null;
		picture = ScalingUtilities.fitScale(mActivity.getResources(),mActivity.getResources()
						.getIdentifier(getImageUrl(mData.getAchievements()), "drawable", 
								mActivity.getPackageName()), mActivity, "schnecke");
		mSchneckenBild.setImageBitmap(picture);
	}

	private String getImageUrl (int achievement){
		String imageUrl = "prozent_0";
		if(achievement > 17){
			imageUrl = "prozent_100";
		}else{
				
			switch(achievement){
			case 0:
				imageUrl = "prozent_0";
				break;
			case 1:
				imageUrl = "prozent_6";
				break;
			case 2:
				imageUrl = "prozent_12";
				break;
			case 3:
				imageUrl = "prozent_18";
				break;
			case 4:
				imageUrl = "prozent_24";
				break;
			case 5:
				imageUrl = "prozent_29";
				break;
			case 6:
				imageUrl = "prozent_35";
				break;
			case 7:
				imageUrl = "prozent_41";
				break;
			case 8:
				imageUrl = "prozent_47";
				break;
			case 9:
				imageUrl = "prozent_53";
				break;
			case 10:
				imageUrl = "prozent_59";
				break;
			case 11:
				imageUrl = "prozent_65";
				break;
			case 12:
				imageUrl = "prozent_71";
				break;
			case 13:
				imageUrl = "prozent_76";
				break;
			case 14:
				imageUrl = "prozent_82";
				break;
			case 15:
				imageUrl = "prozent_88";
				break;
			case 16:
				imageUrl = "prozent_94";
				break;
			case 17:
				imageUrl = "prozent_100";
				break;
			}
		}
			return imageUrl;
	}
	
}