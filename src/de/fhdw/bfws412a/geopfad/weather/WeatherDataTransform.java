/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	Böttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - AäR hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation verändert werden.
**
**	Ohne ausdrückliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zugänglich gemacht werden.
**
**	Eine Vervielfältigung und Veröffentlichung des Quellcodes ohne ausdrückliche
**	Genehmigung - auch in Auszügen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad.weather;

import de.fhdw.bfwi412a.geopfad.R;
import android.content.Context;

/**Class implemented by: Matthias Wiegand
 * WeatherDataTransform is a helper class that helps to display the weather data
 * in the GUI*/

public class WeatherDataTransform {
	private String mImageName;
	private String mGday;
	
	/**Method that is used to transform an english day-description to a german one
	 * @param day english day desciption
	 * @return mGday german day description */
	
	public String dayToGerman(String day){
		if(day.equals("Mon"))
			mGday="Mo";
		if(day.equals("Tue"))
			mGday="Di";
		if(day.equals("Wed"))
			mGday="Mi";
		if(day.equals("Thu"))
			mGday="Do";
		if(day.equals("Fri"))
			mGday="Fr";
		if(day.equals("Sat"))
			mGday="Sa";
		if(day.equals("Sun"))
			mGday="So";
		
		return mGday;
	}
	
	/**Method that transforms a given weathercode to a string that describes the
	 * imagename of the image that fits to the displayed weather
	 * @param weathercode weathercode that has to be transfromed
	 * @return mImageName holds name of the weatherimage that has to be displayed*/
	
	public String getWeatherImageName(String weathercode, Context context){		
		if(weathercode.equals("0"))
			mImageName=context.getResources().getString(R.string.weather_thunderstorm);
		if(weathercode.equals("1"))
			mImageName=context.getResources().getString(R.string.weather_thunderstorm);
		if(weathercode.equals("2"))
			mImageName=context.getResources().getString(R.string.weather_thunderstorm);
		if(weathercode.equals("3"))
			mImageName=context.getResources().getString(R.string.weather_thunderstorm);
		if(weathercode.equals("4"))
			mImageName=context.getResources().getString(R.string.weather_thunderstorm);
		if(weathercode.equals("5"))
			mImageName=context.getResources().getString(R.string.weather_rain_snow);
		if(weathercode.equals("6"))
			mImageName=context.getResources().getString(R.string.weather_rain_snow);
		if(weathercode.equals("7"))
			mImageName=context.getResources().getString(R.string.weather_rain_snow);
		if(weathercode.equals("8"))
			mImageName=context.getResources().getString(R.string.weather_drizzle);
		if(weathercode.equals("9"))
			mImageName=context.getResources().getString(R.string.weather_drizzle);
		if(weathercode.equals("10"))
			mImageName=context.getResources().getString(R.string.weather_drizzle);
		if(weathercode.equals("11"))
			mImageName=context.getResources().getString(R.string.weather_drizzle);
		if(weathercode.equals("12"))
			mImageName=context.getResources().getString(R.string.weather_drizzle);
		if(weathercode.equals("13"))
			mImageName=context.getResources().getString(R.string.weather_flurries);
		if(weathercode.equals("14"))
			mImageName=context.getResources().getString(R.string.weather_flurries);
		if(weathercode.equals("15"))
			mImageName=context.getResources().getString(R.string.weather_snow);
		if(weathercode.equals("16"))
			mImageName=context.getResources().getString(R.string.weather_snow);
		if(weathercode.equals("17"))
			mImageName=context.getResources().getString(R.string.weather_sleet);
		if(weathercode.equals("18"))
			mImageName=context.getResources().getString(R.string.weather_sleet);
		if(weathercode.equals("19"))
			mImageName=context.getResources().getString(R.string.weather_fog);
		if(weathercode.equals("20"))
			mImageName=context.getResources().getString(R.string.weather_fog);
		if(weathercode.equals("21"))
			mImageName=context.getResources().getString(R.string.weather_fog);
		if(weathercode.equals("22"))
			mImageName=context.getResources().getString(R.string.weather_fog);
		if(weathercode.equals("23"))
			mImageName=context.getResources().getString(R.string.weather_cloudy);
		if(weathercode.equals("24"))
			mImageName=context.getResources().getString(R.string.weather_cloudy);
		if(weathercode.equals("25"))
			mImageName=context.getResources().getString(R.string.weather_cloudy);
		if(weathercode.equals("26"))
			mImageName=context.getResources().getString(R.string.weather_cloudy);
		if(weathercode.equals("27"))
			mImageName=context.getResources().getString(R.string.weather_mostly_cloudy);
		if(weathercode.equals("28"))
			mImageName=context.getResources().getString(R.string.weather_mostly_cloudy);
		if(weathercode.equals("29"))
			mImageName=context.getResources().getString(R.string.weather_partly_cloudy);
		if(weathercode.equals("29"))
			mImageName=context.getResources().getString(R.string.weather_partly_cloudy);
		if(weathercode.equals("30"))
			mImageName=context.getResources().getString(R.string.weather_partly_cloudy);
		if(weathercode.equals("31"))
			mImageName=context.getResources().getString(R.string.weather_clear);
		if(weathercode.equals("32"))
			mImageName=context.getResources().getString(R.string.weather_clear);
		if(weathercode.equals("33"))
			mImageName=context.getResources().getString(R.string.weather_clear);
		if(weathercode.equals("34"))
			mImageName=context.getResources().getString(R.string.weather_clear);
		if(weathercode.equals("35"))
			mImageName=context.getResources().getString(R.string.weather_drizzle);
		if(weathercode.equals("36"))
			mImageName=context.getResources().getString(R.string.weather_clear);
		if(weathercode.equals("37"))
			mImageName=context.getResources().getString(R.string.weather_storm);
		if(weathercode.equals("38"))
			mImageName=context.getResources().getString(R.string.weather_storm);
		if(weathercode.equals("39"))
			mImageName=context.getResources().getString(R.string.weather_storm);
		if(weathercode.equals("40"))
			mImageName=context.getResources().getString(R.string.weather_storm);
		if(weathercode.equals("41"))
			mImageName=context.getResources().getString(R.string.weather_snow);
		if(weathercode.equals("42"))
			mImageName=context.getResources().getString(R.string.weather_snow);
		if(weathercode.equals("43"))
			mImageName=context.getResources().getString(R.string.weather_snow);
		if(weathercode.equals("44"))
			mImageName=context.getResources().getString(R.string.weather_partly_cloudy);
		if(weathercode.equals("45"))
			mImageName=context.getResources().getString(R.string.weather_storm);
		if(weathercode.equals("46"))
			mImageName=context.getResources().getString(R.string.weather_snow);
		if(weathercode.equals("47"))
			mImageName=context.getResources().getString(R.string.weather_storm);
		
		return mImageName;
	}

}