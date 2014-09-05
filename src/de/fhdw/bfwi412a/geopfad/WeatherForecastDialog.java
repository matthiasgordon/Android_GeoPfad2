package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**Class implemented by: Marc Niedermeier
 * WeatherForecastDialog is a dialog that shows the weatherforecast of the next 5 days
 * @param context in which the dialog is shown
 * @param data is the weather data that has to be displayed*/

public class WeatherForecastDialog extends Dialog implements android.view.View.OnClickListener{

	private Context mContext;
	private List <Weather> WeatherData;
	
	public WeatherForecastDialog(Context context, List <Weather> data) {
		super(context);
		mContext = context;
		WeatherData = data;
		setContentView(R.layout.weather_dialog);
		setTitle("Wettervorhersage");
		loadDataAndFillGUI();
	}
	
	/** Method that uses the loaded data to display it in the forecast-dialog;
	 * implements OK-Butto to finish the dialog*/
	
	public void loadDataAndFillGUI(){
		
		
		for(int i= 1; i<=5; i++){
			String day = "dialog_day" + i;
			String image = "imageView" + i;
			String degreeHigh = "degree_high" + i;
			String degreeLow = "degree_low" + i;
						
			TextView mDay = (TextView) this.findViewById(mContext.getResources()
					.getIdentifier(day, "id", mContext.getPackageName()));
			WeatherDataTransform mTransformer= new WeatherDataTransform();
			mDay.setText(mTransformer.dayToGerman((WeatherData.get(i).getDate())));
		
			ImageView mImage = (ImageView) this.findViewById(mContext.getResources()
					.getIdentifier(image, "id", mContext.getPackageName()));
			mImage.setImageResource(mContext.getResources()
					.getIdentifier("weather_" + mTransformer.getWeatherImageName(WeatherData.get(i)
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