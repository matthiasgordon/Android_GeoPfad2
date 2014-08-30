package de.fhdw.bfwi412a.geopfad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Context;



public class Orte_DOM_Parser {

	public static List<Ort> getOrteFromFile(Context context) {
    	
    	List<Ort> listOrte;
		listOrte = new ArrayList<Ort>();
		Ort curOrt = null;
    	
		ArrayList<InputStream> arrayInputStream = new ArrayList<InputStream>();
        InputStream inputStreamLocal = context.getResources().openRawResource(R.raw.orte);
        arrayInputStream.add(inputStreamLocal);
        
        if(AddLocation.ORTE_XML.exists()){
	        FileInputStream fileInputStreamExtern;
			try {
				fileInputStreamExtern = new FileInputStream(AddLocation.ORTE_XML);
				InputStream inputStreamExtern = fileInputStreamExtern;
		        arrayInputStream.add(inputStreamExtern);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
        }
        
        //String urlString = "https://dl.dropboxusercontent.com/s/3baizol2r780o7o/orte.xml";
        //InputStream is = getInputStreamFromURL(urlString);
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;

        for(InputStream inputStream : arrayInputStream){
       
		        try{
					db = dbf.newDocumentBuilder();
		
					//parse rss feed
			        Document doc;
				    doc = db.parse(inputStream);
				    doc.normalize();
		
			        
			        
				     if (inputStream != null)
				     {
				        	
				    	
				    	//get all elements named "entry"
				        NodeList nl = doc.getElementsByTagName("ort");
				        
				        //check if NodeList has child elements
				        if (nl != null && nl.getLength() > 0) {
				        	
				        	//if true, loop through all elements
				        	for (int i = 0 ; i < nl.getLength(); i++) {
				        		
				        		curOrt = new Ort();
				        		//get each entry
				        		Element entry = (Element) nl.item(i);
				        		
				        		//read the title of each entry
				        		Element title = (Element) entry.getElementsByTagName("name").item(0);
				        		Element image = (Element) entry.getElementsByTagName("image").item(0);
				        		Element image2 = (Element) entry.getElementsByTagName("image2").item(0);
				        		Element image3 = (Element) entry.getElementsByTagName("image3").item(0);
				        		Element about = (Element) entry.getElementsByTagName("about").item(0);
				        		Element link = (Element) entry.getElementsByTagName("link").item(0);
				        		Element latitude = (Element) entry.getElementsByTagName("latitude").item(0);
				        		Element longitude = (Element) entry.getElementsByTagName("longitude").item(0);
				        		Element visitKey = (Element) entry.getElementsByTagName("visitKey").item(0);
				        		
				        		//add both new TextView and LinearLayout
					        	curOrt.setName(title.getFirstChild().getNodeValue());	//layout.addView(tv_title);
					        	
					        	if(image != null){
					        	String imageName = image.getFirstChild().getNodeValue();
					        	curOrt.setImgUrl(imageName);
					        	String imageName2 = image2.getFirstChild().getNodeValue();
					        	curOrt.setImgUrl2(imageName2);
					        	String imageName3 = image3.getFirstChild().getNodeValue();
					        	curOrt.setImgUrl3(imageName3);
					        	
					        	curOrt.setAbout(about.getFirstChild().getNodeValue());
					        	curOrt.setLink(link.getFirstChild().getNodeValue());
					        	curOrt.setLat(Double.parseDouble(latitude.getFirstChild().getNodeValue()));
					        	curOrt.setLng(Double.parseDouble(longitude.getFirstChild().getNodeValue()));
					        	curOrt.setVisitKey(visitKey.getFirstChild().getNodeValue());
					        	}
					        	listOrte.add(curOrt);
				        	
				        	}
				        }
				   }
		        
			} catch (SAXException e) {
			    // TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        }
	     return listOrte;
   }  
    
    
//	public static InputStream getInputStreamFromURL(String urlString){
//		InputStream in = null;    
//        URL url = null;
//		
//        try {
//			url = new URL(urlString);
//			in = url.openStream();
//		} catch (MalformedURLException e1) {
//			e1.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		return in;
//	}
}
