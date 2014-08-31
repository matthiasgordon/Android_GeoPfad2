package de.fhdw.bfwi412a.geopfad;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityStartApplicationLogic {
	ActivityStart mActivity;
	ActivityStartGUI mGUI;
	ActivityStartData mData;
	static final int REQUESTCODECOUNTERVALUE = 1;
	
	public ActivityStartApplicationLogic(ActivityStart act, ActivityStartGUI gui, ActivityStartData data) {
		mActivity = act;
		mGUI = gui;
		mData = data;
	}
	
	public void onToActivityMainButtonClicked() {
		Intent intent;
		intent = new Intent();
		intent.setClass(mData.getActivity(), ActivityMain.class);
		mData.getActivity().startActivityForResult(intent, REQUESTCODECOUNTERVALUE);
	}

	public void openWeatherDialog() {
		if(mData.isOnline() && mData.LoadWeatherDataSuccess){
			final Dialog dialog = new Dialog(mActivity);
			dialog.setContentView(R.layout.weather_dialog);
			dialog.setTitle("Wettervorhersage");
			
			for(int i= 1; i<=5; i++){
				String day = "dialog_day" + i;
				String image = "imageView" + i;
				String degreeHigh = "degree_high" + i;
				String degreeLow = "degree_low" + i;
							
				TextView mDay = (TextView) dialog.findViewById(mActivity.getResources()
						.getIdentifier(day, "id", mActivity.getPackageName()));
				mDay.setText(mGUI.dayToGerman((mData.getWeatherData().get(i).getDate())));
			
				ImageView mImage = (ImageView) dialog.findViewById(mActivity.getResources()
						.getIdentifier(image, "id", mActivity.getPackageName()));
				mImage.setImageResource(mActivity.getResources()
						.getIdentifier("weather_" + mGUI.getWeatherImageName(mData.getWeatherData()
								.get(i).getWeatherCode()), "drawable", mActivity.getPackageName()));
				
				TextView mDegreeHigh = (TextView) dialog.findViewById(mActivity.getResources()
						.getIdentifier(degreeHigh, "id", mActivity.getPackageName()));
				mDegreeHigh.setText(mData.getWeatherData().get(i).getTemperatureHigh() + "°C");
				
				TextView mDegreeLow = (TextView) dialog.findViewById(mActivity.getResources()
						.getIdentifier(degreeLow, "id", mActivity.getPackageName()));
				mDegreeLow.setText(mData.getWeatherData().get(i).getTemperatureLow() + "°C");
			}
		
			Button dialogButton = (Button) dialog.findViewById(R.id.btnStop);
			// if button is clicked, close the custom dialog
			dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
	
			dialog.show();
		}
	}

}
