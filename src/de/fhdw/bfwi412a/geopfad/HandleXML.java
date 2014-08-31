package de.fhdw.bfwi412a.geopfad;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;


public class HandleXML {

   private String mUrlString = null;
   private List <String> mWeatherDates = new ArrayList <String>();
   private List <String> mWeatherTempsHigh = new ArrayList <String>();
   private List <String> mWeatherTempsLow = new ArrayList <String>();
   private List <String> mWeatherCodes = new ArrayList <String>();
   private XmlPullParserFactory mXmlFactoryObject;
   public volatile boolean parsingComplete = true;
   private boolean InternetAcces = true;
   
public HandleXML(String url){
    this.mUrlString = url;
}

public List<String> getWeatherDates() {
	return mWeatherDates;
}

public List<String> getWeatherTempsHigh() {
	return mWeatherTempsHigh;
}

public List<String> getWeatherTempsLow() {
	return mWeatherTempsLow;
}

public List<String> getWeatherCodes() {
	return mWeatherCodes;
}

public boolean isInternetAcces() {
	return InternetAcces;
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


public void fetchXML(){
      Thread thread = new Thread(new Runnable(){
         @Override
         public void run() {
            try {
               URL url = new URL(mUrlString);
               HttpURLConnection conn = (HttpURLConnection) 
               url.openConnection();
                  conn.setReadTimeout(10000 /* milliseconds */);
                  conn.setConnectTimeout(15000 /* milliseconds */);
                  conn.setRequestMethod("GET");
                  conn.setDoInput(true);
                  conn.connect();
            InputStream stream = conn.getInputStream();

            mXmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myparser = mXmlFactoryObject.newPullParser();

            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES
            , false);
            myparser.setInput(stream, null);
            parseXMLAndStoreIt(myparser);
            stream.close();
            } catch (Exception e) {
            	InternetAcces = false;
                parsingComplete = false;
               e.printStackTrace();
            }
        }
    });

    thread.start(); 
   }

}