package de.fhdw.bfwi412a.geopfad;

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
