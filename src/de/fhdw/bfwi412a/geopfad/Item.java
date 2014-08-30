package de.fhdw.bfwi412a.geopfad;

public class Item {

	 private String mText; //Das ist der Text der in der Liste angezeigt wird
	 private String mInfo;
	
	 public Item(String text,String info){
	 this.mText = text;
	 this.mInfo = info;
	 }
	
	 public String getText(){
	 return mText;
	 }
	
	 public String getInfo(){
	 return mInfo;
	 }
	
}