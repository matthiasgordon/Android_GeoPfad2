package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

/** Class implemented by: Marc Niedermeier
 * Parser class that parses the Yahoo!-Weather XML and returns a List of 
 * weather data*/ 
import org.xmlpull.v1.XmlPullParser;


public class WeatherPullParser {

private List <Weather> mWeatherData = new ArrayList <Weather>();
   
public WeatherPullParser(){
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
                  if(name.equals("yweather:condition")){ 	
                	  Weather currWeather = new Weather();
                	  currWeather.setDate(myParser.getAttributeValue(null,"date"));
                	  currWeather.setTemperatureHigh(myParser.getAttributeValue(null,"temp"));
                	  currWeather.setTemperatureLow("aktuelles Wetter");
                	  currWeather.setWeatherCode(myParser.getAttributeValue(null,"code"));
                	  mWeatherData.add(currWeather);
                  }
                  else if(name.equals("yweather:forecast")){
                	  Weather currWeather = new Weather();
                	  currWeather.setDate(myParser.getAttributeValue(null,"day"));
                	  currWeather.setTemperatureHigh(myParser.getAttributeValue(null,"high"));
                	  currWeather.setTemperatureLow(myParser.getAttributeValue(null,"low"));
                	  currWeather.setWeatherCode(myParser.getAttributeValue(null,"code"));
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