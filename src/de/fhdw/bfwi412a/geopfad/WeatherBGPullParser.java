package de.fhdw.bfwi412a.geopfad;
import java.io.InputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


public class WeatherBGPullParser {

   private List <String> mWeatherDates = new ArrayList <String>();
   private List <String> mWeatherTempsHigh = new ArrayList <String>();
   private List <String> mWeatherTempsLow = new ArrayList <String>();
   private List <String> mWeatherCodes = new ArrayList <String>();
   private List <Weather> mWeatherData = new ArrayList <Weather>();
   public volatile boolean parsingComplete = true;
   private boolean InternetAcces = true;
   
public WeatherBGPullParser(){
}

public boolean isInternetAcces() {
	return InternetAcces;
}

public void setInternetAcces(boolean internetAcces) {
	InternetAcces = internetAcces;
}

public List<Weather> getWeatherData() {

	fetchXML();
	while(parsingComplete);
    for(int i=0; i < mWeatherCodes.size(); i++){
    	Weather currWeather = new Weather();

    	currWeather.setDate(mWeatherDates.get(i));
    	currWeather.setTemperatureHigh(mWeatherTempsHigh.get(i));
    	currWeather.setTemperatureLow(mWeatherTempsLow.get(i));
    	currWeather.setWeatherCode(mWeatherCodes.get(i));
    	mWeatherData.add(currWeather);
    }
	return mWeatherData;
}

public void fetchXML(){
	Thread thread = new Thread(new WeatherBGRunnable(this));
	thread.start(); 
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
                	  mWeatherDates.add(myParser.getAttributeValue(null,"date"));
                	  mWeatherTempsHigh.add(myParser.getAttributeValue(null,"temp"));
                	  mWeatherTempsLow.add("aktuelles Wetter");
                	  mWeatherCodes.add(myParser.getAttributeValue(null,"code"));
                  }
                  else if(name.equals("yweather:forecast")){
                	  mWeatherDates.add(myParser.getAttributeValue(null,"day"));
                	  mWeatherTempsHigh.add(myParser.getAttributeValue(null,"high"));
                	  mWeatherTempsLow.add(myParser.getAttributeValue(null,"low"));
                	  mWeatherCodes.add(myParser.getAttributeValue(null,"code"));
                  }
                  else{
                  }
                  break;
                  }		 
                  event = myParser.next(); 
              }
                 parsingComplete = false;
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}