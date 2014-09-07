/** class implemented by Marcel Böttcher */
package de.fhdw.bfwi412a.geopfad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.util.Xml;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityAddLocationApplicationLogic {

	private ActivityAddLocationGUI mAddLocGui;
	private ActivityAddLocation mAddLoc;
	private ActivityAddLocationData mAddLocData;
	
	public ActivityAddLocationApplicationLogic(ActivityAddLocation act, ActivityAddLocationData data, ActivityAddLocationGUI gui) {
		mAddLocData = data;
		mAddLocGui = gui;
		mAddLoc = act;
	}
	
	public void setCoordination(){
		EditText mEtAddLocLat = mAddLocGui.getmEtLat();
		EditText mEtAddLocLng = mAddLocGui.getmEtLng();
		
			LocationManager service = (LocationManager) mAddLoc.getSystemService(Context.LOCATION_SERVICE);
				boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
			DistanceCalculator mDC = new DistanceCalculator();
			Location mLiveLocation = mDC.getLiveLocation(mAddLoc);
			if(mLiveLocation != null){
				mEtAddLocLat.setText(String.valueOf(mLiveLocation.getLatitude()));
				mEtAddLocLng.setText(String.valueOf(mLiveLocation.getLongitude()));
			}
			else if(enabled) {
				String mGPSFehler = mAddLoc.getResources().getString(R.string.alert_gps_no_signal);
				Toast.makeText(mAddLoc, mGPSFehler,
				        Toast.LENGTH_SHORT).show();
			}
			else {
				String mGPSFehler = mAddLoc.getResources().getString(R.string.alert_gps_turn_on);
				Toast.makeText(mAddLoc, mGPSFehler,
				        Toast.LENGTH_SHORT).show();
			}
	}
	
	public void changeToFilechooser(){
	Intent intent = new Intent(mAddLocData.getmAddLoc(), ActivityFileChooser.class);
	mAddLoc.startActivityForResult(intent, mAddLocData.getIMAGE_URL());
	}
	
	public void setOrt(){
		try {
			final File GEOPFAD_DIRECTORY= mAddLocData.getGeopfadDirectory();
			final File ORTE_XML = mAddLocData.getOrteXml();
			String ortId = mAddLocGui.getmOrtId();
			String ortName = mAddLocGui.getmEtOrtName().getText().toString();
			String about = mAddLocGui.getmEtAbout().getText().toString();
			String extImageUrl = mAddLocGui.getmImageUrl().getText().toString();
			String ortLat = mAddLocGui.getmEtLat().getText().toString();
			String ortLng = mAddLocGui.getmEtLng().getText().toString();
		  
			if(!ortName.equals("") && !about.equals("") && !extImageUrl.equals("") &&
					!ortLat.equals("") && !ortLng.equals("")){
				
				if(!GEOPFAD_DIRECTORY.exists()){
					GEOPFAD_DIRECTORY.mkdir();
				}
				
				if(ORTE_XML.exists()){
	
					DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			        /** Create the documentBuilder */
			        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			        /** Create the Document  by parsing the file */
			        Document document = documentBuilder.parse(ORTE_XML);
			         /** Get the root element of the xml Document; */
			        
			        System.out.println(document);
			    	
			    	Node node =  document.getElementsByTagName("orte").item(0);
			    	
			    	Element newOrt = document.createElement("ort");
			    	
			    	Element newOrtId = document.createElement("id");
			    	newOrtId.appendChild(document.createTextNode(ortId));
			    	newOrt.appendChild(newOrtId);
			    	
			    	Element newOrtName = document.createElement("name");
			    	newOrtName.appendChild(document.createTextNode(ortName));
			    	newOrt.appendChild(newOrtName);
			    	
			    	Element newAbout = document.createElement("about");
			    	newAbout.appendChild(document.createTextNode(about));
			    	newOrt.appendChild(newAbout);
			    	
			    	Element newLat = document.createElement("latitude");
			    	newLat.appendChild(document.createTextNode(ortLat));
			    	newOrt.appendChild(newLat);
			    	
			    	Element newLng = document.createElement("longitude");
			    	newLng.appendChild(document.createTextNode(ortLng));
			    	newOrt.appendChild(newLng);
			    	
			    	Element newExtImageUrl = document.createElement("extImageUrl");
			    	newExtImageUrl.appendChild(document.createTextNode(extImageUrl));
			    	newOrt.appendChild(newExtImageUrl);
			    	
			    	node.appendChild(newOrt);
			    	
			    	TransformerFactory factory = TransformerFactory.newInstance();
			    	Transformer transformer = factory.newTransformer();

			    	DOMSource source = new DOMSource(document);
			    	StreamResult result = new StreamResult(ORTE_XML);
			    	transformer.transform(source, result);
			    	
			    	String message = "Ort wurde hinzugefügt!";
					Toast.makeText(mAddLoc, message,
					        Toast.LENGTH_LONG).show();
					mAddLoc.finish();
		
				}
				
			    else {
			    	 FileOutputStream fileos= new FileOutputStream(ORTE_XML);
					    XmlSerializer xmlSerializer = Xml.newSerializer();              
					    StringWriter writer = new StringWriter();
					    xmlSerializer.setOutput(writer);
					    xmlSerializer.startDocument("UTF-8", true);
					    xmlSerializer.startTag(null, "orte");
					    xmlSerializer.startTag(null, "ort");
					    xmlSerializer.startTag(null, "id");
					    xmlSerializer.text(ortId);
					    xmlSerializer.endTag(null, "id");
					    xmlSerializer.startTag(null, "name");
					    xmlSerializer.text(ortName);
					    xmlSerializer.endTag(null, "name");
					    xmlSerializer.startTag(null, "extImageUrl");
					    xmlSerializer.text(extImageUrl);
					    xmlSerializer.endTag(null, "extImageUrl");
					    xmlSerializer.startTag(null,"about");
					    xmlSerializer.text(about);
					    xmlSerializer.endTag(null, "about"); 
					    xmlSerializer.startTag(null,"latitude");
					    xmlSerializer.text(ortLat);
					    xmlSerializer.endTag(null, "latitude");
					    xmlSerializer.startTag(null,"longitude");
					    xmlSerializer.text(ortLng);
					    xmlSerializer.endTag(null, "longitude");
					    xmlSerializer.endTag(null, "ort");
					    xmlSerializer.endTag(null, "orte");
					    xmlSerializer.endDocument();
					    xmlSerializer.flush();
					    String dataWrite = writer.toString();
					    fileos.write(dataWrite.getBytes());
					    fileos.close();
					    
					    String message = "Ort wurde hinzugefügt!";
						Toast.makeText(mAddLoc, message,
						        Toast.LENGTH_LONG).show();
				    	mAddLoc.finish();
			    }
			}
			else {
				String bildFehler = "Bitte füllen Sie alle Felder aus!";
				Toast.makeText(mAddLoc, bildFehler,
				        Toast.LENGTH_LONG).show();
			}
		    
		}
		catch (FileNotFoundException e) {
		    /**  TODO Auto-generated catch block */
		    e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
		    /**  TODO Auto-generated catch block */
		    e.printStackTrace();
		}
		catch (IllegalStateException e) {
		    /** TODO Auto-generated catch block */
		    e.printStackTrace();
		}
		catch (IOException e) {
		    /** TODO Auto-generated catch block */
		    e.printStackTrace();
		} catch (ParserConfigurationException e) {
			/** TODO Auto-generated catch block */
			e.printStackTrace();
		} catch (SAXException e) {
			/** TODO Auto-generated catch block */
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			/** TODO Auto-generated catch block */
			e.printStackTrace();
		} catch (TransformerException e) {
			/** TODO Auto-generated catch block */
			e.printStackTrace();
		}
	
	}

}
