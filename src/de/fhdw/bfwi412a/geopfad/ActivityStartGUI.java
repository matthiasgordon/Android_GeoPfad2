package de.fhdw.bfwi412a.geopfad;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityStartGUI {

	ActivityStartData mData;
	TextView mTemperature;
	TextView mLocation;
	ImageView mSchneckenBild;
	ImageView mCurrWeather;
	Button mToActivityMainButton;
	Button btnWeather;
	
	public ActivityStartGUI(ActivityStart act, ActivityStartData data) {
		mData = data;
		mTemperature = (TextView) act.findViewById(R.id.currDegree);
		mCurrWeather = (ImageView) act.findViewById(R.id.imgWeather);
		mLocation = (TextView) act.findViewById(R.id.Location);
		
		mToActivityMainButton = (Button) act.findViewById(R.id.ToActivityMainButton);
		
		mSchneckenBild = (ImageView) act.findViewById(R.id.schneckeView);
//		mSchneckenBild.setImageResource(act.getResources()
//		.getIdentifier(getImageUrl(mData.getAchievements()), "drawable", act.getPackageName()));
		Bitmap picture = null;
		picture = ScalingUtilities.fitScale(act.getResources(),act.getResources()
						.getIdentifier(getImageUrl(mData.getAchievements()), "drawable", 
								act.getPackageName()), act, "schnecke");
		mSchneckenBild.setImageBitmap(picture);
		
		btnWeather = (Button) act.findViewById(R.id.btnWeather);
		if(mTemperature != null && mCurrWeather != null){	
			if (mData.isOnline() && mData.LoadWeatherDataSuccess){
				mTemperature.setText(mData.getWeatherData().get(0).getTemperatureHigh() + "°C");
				mCurrWeather.setImageResource(act.getResources()
						.getIdentifier("weather_large_" + getWeatherImageName(mData.getWeatherData()
								.get(0).getWeatherCode()), "drawable", act.getPackageName()));
			}else{
				btnWeather.setVisibility(View.INVISIBLE);
				mCurrWeather.setVisibility(View.INVISIBLE);
				mLocation.setVisibility(View.INVISIBLE);
				mTemperature.setText("Kein Internet -> Wetterdaten nicht verfügbar!");
			}
		}
	}

	public Button getToActivityMainButton() {
		return mToActivityMainButton;
	}

	public ImageView getSchneckenBild() {
		return mSchneckenBild;
	}
	
	public Button getBtnWeather() {
		return btnWeather;
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
	
	public String dayToGerman(String day){
		String gDay="";
		if(day.equals("Mon"))
			gDay="Mo";
		if(day.equals("Tue"))
			gDay="Di";
		if(day.equals("Wed"))
			gDay="Mi";
		if(day.equals("Thu"))
			gDay="Do";
		if(day.equals("Fri"))
			gDay="Fr";
		if(day.equals("Sat"))
			gDay="Sa";
		if(day.equals("Sun"))
			gDay="So";
		
		return gDay;
	}
	
	public String getWeatherImageName(String weathercode){
		String imageName="";
		
		if(weathercode.equals("0"))
			imageName="thunderstorm";
		if(weathercode.equals("1"))
			imageName="thunderstorm";
		if(weathercode.equals("2"))
			imageName="thunderstorm";
		if(weathercode.equals("3"))
			imageName="thunderstorm";
		if(weathercode.equals("4"))
			imageName="thunderstorm";
		if(weathercode.equals("5"))
			imageName="rain_snow";
		if(weathercode.equals("6"))
			imageName="rain_snow";
		if(weathercode.equals("7"))
			imageName="rain_snow";
		if(weathercode.equals("8"))
			imageName="drizzle";
		if(weathercode.equals("9"))
			imageName="drizzle";
		if(weathercode.equals("10"))
			imageName="drizzle";
		if(weathercode.equals("11"))
			imageName="drizzle";
		if(weathercode.equals("12"))
			imageName="drizzle";
		if(weathercode.equals("13"))
			imageName="flurries";
		if(weathercode.equals("14"))
			imageName="flurries";
		if(weathercode.equals("15"))
			imageName="snow";
		if(weathercode.equals("16"))
			imageName="snow";
		if(weathercode.equals("17"))
			imageName="sleet";
		if(weathercode.equals("18"))
			imageName="sleet";
		if(weathercode.equals("19"))
			imageName="fog";
		if(weathercode.equals("20"))
			imageName="fog";
		if(weathercode.equals("21"))
			imageName="fog";
		if(weathercode.equals("22"))
			imageName="fog";
		if(weathercode.equals("23"))
			imageName="cloudy";
		if(weathercode.equals("24"))
			imageName="cloudy";
		if(weathercode.equals("25"))
			imageName="cloudy";
		if(weathercode.equals("26"))
			imageName="cloudy";
		if(weathercode.equals("27"))
			imageName="mostly_cloudy";
		if(weathercode.equals("28"))
			imageName="mostly_cloudy";
		if(weathercode.equals("29"))
			imageName="partly_cloudy";
		if(weathercode.equals("29"))
			imageName="partly_cloudy";
		if(weathercode.equals("30"))
			imageName="partly_cloudy";
		if(weathercode.equals("31"))
			imageName="clear";
		if(weathercode.equals("32"))
			imageName="clear";
		if(weathercode.equals("33"))
			imageName="clear";
		if(weathercode.equals("34"))
			imageName="clear";
		if(weathercode.equals("35"))
			imageName="drizzle";
		if(weathercode.equals("36"))
			imageName="clear";
		if(weathercode.equals("37"))
			imageName="storm";
		if(weathercode.equals("38"))
			imageName="storm";
		if(weathercode.equals("39"))
			imageName="storm";
		if(weathercode.equals("40"))
			imageName="storm";
		if(weathercode.equals("41"))
			imageName="snow";
		if(weathercode.equals("42"))
			imageName="snow";
		if(weathercode.equals("43"))
			imageName="snow";
		if(weathercode.equals("44"))
			imageName="partly_cloudy";
		if(weathercode.equals("45"))
			imageName="storm";
		if(weathercode.equals("46"))
			imageName="snow";
		if(weathercode.equals("47"))
			imageName="storm";
		
		return imageName;
	}
}