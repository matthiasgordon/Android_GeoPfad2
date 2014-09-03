package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherForecastDialog extends Dialog implements android.view.View.OnClickListener{

	ActivityStartGUI mGUI;
	List <Weather> WeatherData;
	Context mContext;
	
	public WeatherForecastDialog(Context context, ActivityStartGUI gui, List <Weather> data) {
		super(context);
		mContext = context;
		setContentView(R.layout.weather_dialog);
		setTitle("Wettervorhersage");
		mGUI = gui;
		WeatherData = data;
		loadGUIandData();
	}
	
	public void loadGUIandData(){
		
		for(int i= 1; i<=5; i++){
			String day = "dialog_day" + i;
			String image = "imageView" + i;
			String degreeHigh = "degree_high" + i;
			String degreeLow = "degree_low" + i;
						
			TextView mDay = (TextView) this.findViewById(mContext.getResources()
					.getIdentifier(day, "id", mContext.getPackageName()));
			mDay.setText(mGUI.dayToGerman((WeatherData.get(i).getDate())));
		
			ImageView mImage = (ImageView) this.findViewById(mContext.getResources()
					.getIdentifier(image, "id", mContext.getPackageName()));
			mImage.setImageResource(mContext.getResources()
					.getIdentifier("weather_" + mGUI.getWeatherImageName(WeatherData.get(i)
							.getWeatherCode()), "drawable", mContext.getPackageName()));
			
			TextView mDegreeHigh = (TextView) this.findViewById(mContext.getResources()
					.getIdentifier(degreeHigh, "id", mContext.getPackageName()));
			mDegreeHigh.setText(WeatherData.get(i).getTemperatureHigh() + "°C");
			
			TextView mDegreeLow = (TextView) this.findViewById(mContext.getResources()
					.getIdentifier(degreeLow, "id", mContext.getPackageName()));
			mDegreeLow.setText(WeatherData.get(i).getTemperatureLow() + "°C");
		}
		Button dialogButton = (Button) this.findViewById(R.id.btnStop);
		dialogButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		this.dismiss();
	}

}