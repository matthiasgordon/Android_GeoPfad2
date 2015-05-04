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

import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import de.fhdw.bfwi412a.geopfad.R;

import android.content.Context;
/** Class implemented by: Marc Niedermeier
 * Parser class that parses the Yahoo!-Weather XML and returns a List of 
 * weather data*/ 


public class WeatherPullParser {

private List <Weather> mWeatherData = new ArrayList <Weather>();
private Context mContext;

public WeatherPullParser(Context context){
	mContext = context;
}

public List<Weather> getWeatherData() {
	return mWeatherData;
}

/** Method that parses the Date, WeatherCode (describes condition) and the temperature
 * (highest, lowest of the day) for the current weather and the forecast of the next 5 days
 * @param myParser XMLPullParser that is given within the downloaded InputStream*/

public void parseXMLAndStoreIt(XmlPullParser myParser) {
      int event;
      String text=null;
      try {
         event = myParser.getEventType();
         while (event != XmlPullParser.END_DOCUMENT) {
            String name=myParser.getName();
            switch (event){
               case XmlPullParser.START_TAG:
               break;
               case XmlPullParser.TEXT:
               text = myParser.getText();
               break;

               case XmlPullParser.END_TAG:
                  if(name.equals(mContext.getResources().getString(R.string.curr_weather_tag))){ 	
                	  Weather currWeather = new Weather();
                	  currWeather.setDate(myParser.getAttributeValue(null,mContext.getResources()
                			  .getString(R.string.curr_weather_day)));
                	  currWeather.setTemperatureHigh(myParser.getAttributeValue(null,mContext.getResources()
                			  .getString(R.string.curr_weather_temp)));
                	  currWeather.setTemperatureLow("aktuelles Wetter");
                	  currWeather.setWeatherCode(myParser.getAttributeValue(null,mContext.getResources()
                			  .getString(R.string.weather_code)));
                	  mWeatherData.add(currWeather);
                  }
                  else if(name.equals(mContext.getResources().getString(R.string.forecast_weather_tag))){
                	  Weather currWeather = new Weather();
                	  currWeather.setDate(myParser.getAttributeValue(null,mContext.getResources()
                			  .getString(R.string.forecast_weather_day)));
                	  currWeather.setTemperatureHigh(myParser.getAttributeValue(null,mContext.getResources()
                			  .getString(R.string.forecast_weather_high)));
                	  currWeather.setTemperatureLow(myParser.getAttributeValue(null,mContext.getResources()
                			  .getString(R.string.forecast_weather_low)));
                	  currWeather.setWeatherCode(myParser.getAttributeValue(null,mContext.getResources()
                			  .getString(R.string.weather_code)));
                	  mWeatherData.add(currWeather);
                  }
                  else{
                  }
                  break;
                  }		 
                  event = myParser.next(); 
              }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}