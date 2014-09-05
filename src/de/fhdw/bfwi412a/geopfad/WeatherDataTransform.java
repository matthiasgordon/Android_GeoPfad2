package de.fhdw.bfwi412a.geopfad;
/**Class implemented by: Marc Niedermeier
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
	
	public String getWeatherImageName(String weathercode){		
		if(weathercode.equals("0"))
			mImageName="thunderstorm";
		if(weathercode.equals("1"))
			mImageName="thunderstorm";
		if(weathercode.equals("2"))
			mImageName="thunderstorm";
		if(weathercode.equals("3"))
			mImageName="thunderstorm";
		if(weathercode.equals("4"))
			mImageName="thunderstorm";
		if(weathercode.equals("5"))
			mImageName="rain_snow";
		if(weathercode.equals("6"))
			mImageName="rain_snow";
		if(weathercode.equals("7"))
			mImageName="rain_snow";
		if(weathercode.equals("8"))
			mImageName="drizzle";
		if(weathercode.equals("9"))
			mImageName="drizzle";
		if(weathercode.equals("10"))
			mImageName="drizzle";
		if(weathercode.equals("11"))
			mImageName="drizzle";
		if(weathercode.equals("12"))
			mImageName="drizzle";
		if(weathercode.equals("13"))
			mImageName="flurries";
		if(weathercode.equals("14"))
			mImageName="flurries";
		if(weathercode.equals("15"))
			mImageName="snow";
		if(weathercode.equals("16"))
			mImageName="snow";
		if(weathercode.equals("17"))
			mImageName="sleet";
		if(weathercode.equals("18"))
			mImageName="sleet";
		if(weathercode.equals("19"))
			mImageName="fog";
		if(weathercode.equals("20"))
			mImageName="fog";
		if(weathercode.equals("21"))
			mImageName="fog";
		if(weathercode.equals("22"))
			mImageName="fog";
		if(weathercode.equals("23"))
			mImageName="cloudy";
		if(weathercode.equals("24"))
			mImageName="cloudy";
		if(weathercode.equals("25"))
			mImageName="cloudy";
		if(weathercode.equals("26"))
			mImageName="cloudy";
		if(weathercode.equals("27"))
			mImageName="mostly_cloudy";
		if(weathercode.equals("28"))
			mImageName="mostly_cloudy";
		if(weathercode.equals("29"))
			mImageName="partly_cloudy";
		if(weathercode.equals("29"))
			mImageName="partly_cloudy";
		if(weathercode.equals("30"))
			mImageName="partly_cloudy";
		if(weathercode.equals("31"))
			mImageName="clear";
		if(weathercode.equals("32"))
			mImageName="clear";
		if(weathercode.equals("33"))
			mImageName="clear";
		if(weathercode.equals("34"))
			mImageName="clear";
		if(weathercode.equals("35"))
			mImageName="drizzle";
		if(weathercode.equals("36"))
			mImageName="clear";
		if(weathercode.equals("37"))
			mImageName="storm";
		if(weathercode.equals("38"))
			mImageName="storm";
		if(weathercode.equals("39"))
			mImageName="storm";
		if(weathercode.equals("40"))
			mImageName="storm";
		if(weathercode.equals("41"))
			mImageName="snow";
		if(weathercode.equals("42"))
			mImageName="snow";
		if(weathercode.equals("43"))
			mImageName="snow";
		if(weathercode.equals("44"))
			mImageName="partly_cloudy";
		if(weathercode.equals("45"))
			mImageName="storm";
		if(weathercode.equals("46"))
			mImageName="snow";
		if(weathercode.equals("47"))
			mImageName="storm";
		
		return mImageName;
	}

}