package de.fhdw.bfwi412a.geopfad;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class WeatherDataLoader {
	
    public List <Weather> loadXmlFromNetwork(String urlString) throws XmlPullParserException, IOException {
        InputStream stream = null;
        List<Weather> parsedWeatherData = new ArrayList<Weather>();
        try {
            stream = downloadUrl(urlString);
            
            XmlPullParserFactory mXmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myparser = mXmlFactoryObject.newPullParser();
            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            myparser.setInput(stream, null);
            
            WeatherBGPullParser mParser = new WeatherBGPullParser();
            mParser.parseXMLAndStoreIt(myparser);
            
            stream.close();
            parsedWeatherData = mParser.getWeatherData();

        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return parsedWeatherData;       
    }

    private InputStream downloadUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Starts the query
        conn.connect();
        InputStream stream = conn.getInputStream();
        return stream;
    }
}