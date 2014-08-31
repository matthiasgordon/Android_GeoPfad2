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
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddLocation extends Activity {


		static final int IMAGE_URL = 100;
		static final File ORTE_XML = new File(Environment.getExternalStorageDirectory().getPath() + "/orte.xml");
		ActionBar mActionBar;
		ListFragmentGUI mListFragmentGUI;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.add_location);
			
			final String xmlFile = "neueOrte";
			Button btnAnlegen = (Button)findViewById(R.id.btnAnlegen);
			Button btnbildurl = (Button)findViewById(R.id.btnbildurl);
			final String ortId = this.getIntent().getExtras().getString("listLength");
			final EditText etOrtName = (EditText) findViewById(R.id.etxtName);
			final EditText etAbout = (EditText) findViewById(R.id.etxtAbout);
			final TextView imageUrl = (TextView) findViewById(R.id.bildurl);
			
			mActionBar = this.getActionBar();
			mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0979BB")));
			mActionBar.setIcon(R.drawable.actionbar_icon_white);
			
			
			btnbildurl.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(AddLocation.this, FileChooser.class);
					startActivityForResult(intent, IMAGE_URL);
				}
			});
			
			
			
			btnAnlegen.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						String ortName = etOrtName.getText().toString();
						String about = etAbout.getText().toString();
						String extImageUrl = imageUrl.getText().toString();
					    //FileOutputStream fos = new  FileOutputStream("neueOrte.xml");
						if(!extImageUrl.equals("")){
							if(ORTE_XML.exists()){
				
								DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
						        //Create the documentBuilder
						        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
						        //Create the Document  by parsing the file
						        Document document = documentBuilder.parse(ORTE_XML);
						         //Get the root element of the xml Document;
						        
						        System.out.println(document);
						    	
						    	Node node =  document.getElementsByTagName("orte").item(0);
						    	
						    	org.w3c.dom.Element newOrt = document.createElement("ort");
						    	
						    	org.w3c.dom.Element newOrtId = document.createElement("id");
						    	newOrtId.appendChild(document.createTextNode(ortId));
						    	newOrt.appendChild(newOrtId);
						    	
						    	org.w3c.dom.Element newOrtName = document.createElement("name");
						    	newOrtName.appendChild(document.createTextNode(ortName));
						    	newOrt.appendChild(newOrtName);
						    	
						    	org.w3c.dom.Element newAbout = document.createElement("about");
						    	newAbout.appendChild(document.createTextNode(about));
						    	newOrt.appendChild(newAbout);
						    	
						    	org.w3c.dom.Element newExtImageUrl = document.createElement("extImageUrl");
						    	newExtImageUrl.appendChild(document.createTextNode(extImageUrl));
						    	newOrt.appendChild(newExtImageUrl);
						    	
						    	node.appendChild(newOrt);
						    	
						    	TransformerFactory factory = TransformerFactory.newInstance();
						    	Transformer transformer = factory.newTransformer();
	
						    	DOMSource source = new DOMSource(document);
						    	StreamResult result = new StreamResult(ORTE_XML);
						    	transformer.transform(source, result);
						    	
						    	String message = "Ort wurde hinzugefügt!";
								Toast.makeText(AddLocation.this, message,
								        Toast.LENGTH_LONG).show();
						    	finish();
					
							}
							
						    else {
						    	 FileOutputStream fileos= new FileOutputStream(ORTE_XML);//getApplicationContext().openFileOutput(xmlFile, Context.MODE_PRIVATE);
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
								    xmlSerializer.endTag(null, "ort");
								    xmlSerializer.endTag(null, "orte");
								    xmlSerializer.endDocument();
								    xmlSerializer.flush();
								    String dataWrite = writer.toString();
								    fileos.write(dataWrite.getBytes());
								    fileos.close();
						    }
						}
						else {
							String bildFehler = "Bitte fügen Sie ein Bild hinzu!";
							Toast.makeText(AddLocation.this, bildFehler,
							        Toast.LENGTH_LONG).show();
						}
					    
					}
					catch (FileNotFoundException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					catch (IllegalArgumentException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					catch (IllegalStateException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					}
					catch (IOException e) {
					    // TODO Auto-generated catch block
					    e.printStackTrace();
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
				
			});	
		}	
		
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  if (resultCode == RESULT_OK && requestCode == IMAGE_URL) {
		    if (data.hasExtra("bildurl")) {
		    	TextView url = (TextView) findViewById(R.id.bildurl);
		    	url.setText(data.getExtras().getString("bildurl"));		      
		    }
		  }
		} 
}
