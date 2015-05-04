/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	B�ttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - A�R hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation ver�ndert werden.
**
**	Ohne ausdr�ckliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zug�nglich gemacht werden.
**
**	Eine Vervielf�ltigung und Ver�ffentlichung des Quellcodes ohne ausdr�ckliche
**	Genehmigung - auch in Ausz�gen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad.weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;

/** class implemented by Marc Niedermeier:
 * Weather DataLoader loads a XML-File from the network parses and stores it by using a
 * WeatherPullParser */
public class WeatherDataLoader {
	
	
	/**Method that loads an InputStream from a given URLString givs it to the WeatherPullParser
	 * and closes the InputStream
	 * @param urlString is the URL which holds the weather data in a XML-string
	 * @return parsedWeatherData is a list of Weather objects that hold the parsed weather data*/
    public List <Weather> loadXmlFromNetwork(String urlString, Context context) throws XmlPullParserException, IOException {
        Context mContext = context;
    	InputStream stream = null;
        List<Weather> parsedWeatherData = new ArrayList<Weather>();
        try {
            stream = downloadUrl(urlString);
            
            XmlPullParserFactory mXmlFactoryObject = XmlPullParserFactory.newInstance();
            XmlPullParser myparser = mXmlFactoryObject.newPullParser();
            myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            myparser.setInput(stream, null);
            
            WeatherPullParser mParser = new WeatherPullParser(mContext);
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
    
    /** Method that downloads an InputStream from a given URL string
     * @param urlString URL that serves the weather data in a XML file
     * @return stream is the downloaded InputStream*/

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