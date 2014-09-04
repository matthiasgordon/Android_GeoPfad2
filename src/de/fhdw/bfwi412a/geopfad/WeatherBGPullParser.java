package de.fhdw.bfwi412a.geopfad;

import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;


public class WeatherBGPullParser {

	private List <Weather> mWeatherData = new ArrayList <Weather>();
   
public WeatherBGPullParser(){
}

public List<Weather> getWeatherData() {
	return mWeatherData;
}

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