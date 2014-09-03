package de.fhdw.bfwi412a.geopfad;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class WeatherBGRunnable implements Runnable {
	
	private XmlPullParserFactory mXmlFactoryObject;
	WeatherBGPullParser mParser;

	public WeatherBGRunnable (WeatherBGPullParser parser){
		mParser = parser;
	}
	@Override
	public void run() {
		try {
            URL url = new URL("http://weather.yahooapis.com/forecastrss?w=638139&u=c");
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
         mParser.parseXMLAndStoreIt(myparser);
         stream.close();
         } catch (Exception e) {
         	mParser.setInternetAcces(false);
            mParser.parsingComplete = false;
            e.printStackTrace();
         }
     }		
	}