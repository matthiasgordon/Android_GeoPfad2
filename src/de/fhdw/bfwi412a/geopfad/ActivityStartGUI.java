package de.fhdw.bfwi412a.geopfad;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/** ActivityStartGUI provides all the GUI-elements of ActivityStart and serves 
 * methods to fill them */

public class ActivityStartGUI {
	private ActivityStart mActivity;
	private TextView mTemperature;
	private TextView mLocation;
	private ImageView mSchneckenBild;
	private ImageView mCurrWeather;
	private Button mToActivityMainButton;
	private Button btnWeather;
	
	public ActivityStartGUI(ActivityStart act) {
		mActivity = act;
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
	/** Method is only called when no Internet is available makes weather-GUI-elements 
	 * invisible and sets error-message to the temperature-TextView*/

	public void setWeatherInternetError(){
		btnWeather.setVisibility(View.INVISIBLE);
		mCurrWeather.setVisibility(View.INVISIBLE);
		mLocation.setVisibility(View.INVISIBLE);
		mTemperature.setText(R.string.no_internet);
	}
	
	/** Method requests the imageURL of the wanted "Schnecken"-image; 
	 * scales it with the ScalingUtilities class to the devices screen and fills ImageView
	 * @param number of visited locations*/
	
	public void setSchneckenView(int achievement){
		SchneckenImgUrlGenerator imgGenerator = new SchneckenImgUrlGenerator(achievement);
		Bitmap picture = null;
		picture = ScalingUtilities.fitScale(mActivity.getResources(),mActivity.getResources()
						.getIdentifier(imgGenerator.getImgUrl(), "drawable", 
								mActivity.getPackageName()), mActivity, 
								mActivity.getResources().getString(R.string.scale_destination_activity_start_image_snail));
		mSchneckenBild.setImageBitmap(picture);
	}	
}