/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	Böttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - AäR hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation verändert werden.
**
**	Ohne ausdrückliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zugänglich gemacht werden.
**
**	Eine Vervielfältigung und Veröffentlichung des Quellcodes ohne ausdrückliche
**	Genehmigung - auch in Auszügen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
	
	 private int layout;
	 private ArrayList<Item> listOfItems;
	 private Context context;
	
	 public ItemAdapter(Context context,int layout,ArrayList<Item> listOfItems){
	 super();
	 this.context = context;
	 this.layout = layout;
	 this.listOfItems = listOfItems;
	 }
	
	 @Override
	 public int getCount() {
	 return listOfItems.size();
	 }
	
	 @Override
	 public Object getItem(int position) {
	 return listOfItems.get(position);
	 }
	
	 @Override
	 public long getItemId(int position) {
	 return position;
	 }
	
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	
	 TextView textView;
	
	 if (convertView == null){
	 textView = (TextView) LayoutInflater.from(context).inflate(layout,parent,false);
	 }else{
	 textView = (TextView) convertView; //View wiederverwenden
	 }
	
	 textView.setText(listOfItems.get(position).getText()); //Hier den Text aus dem Objekt verwenden
	
	 return textView;
	
	 }
	
	}
