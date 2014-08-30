package de.fhdw.bfwi412a.geopfad;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrteAdapter extends ArrayAdapter<Ort> {

	// declaring
	private Context context;
	private List<Ort> orte = null;
	private  int layoutResourceId;
		
		
	public OrteAdapter(Context context, int layoutResourceId, List<Ort> orte) {
		super(context, layoutResourceId, orte);
		this.layoutResourceId = layoutResourceId;
		this.orte = orte;
		this.context = context;
	}
		
		/*
		 * we are overriding the getView method here - this is what defines how each
		 * list item will look.
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent){

			// assign the view we are converting to a local variable
			View row = convertView;
			OrtHolder holder;
			
			// first check to see if the view is null. if so, we have to inflate it.
			// to inflate it basically means to render, or show, the view.
			if (row == null) {
				LayoutInflater inflater = ((Activity)context).getLayoutInflater();
				row = inflater.inflate(layoutResourceId, parent, false);
			
			
				holder = new OrtHolder();
				holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
				holder.txtOrtName = (TextView)row.findViewById(R.id.txtOrtName);
				
				row.setTag(holder);
			}
			else {
				holder = (OrtHolder)row.getTag();
				
			}
			
			Ort ort = orte.get(position);
			holder.txtOrtName.setText(ort.getName());
			
			int id = context.getResources().getIdentifier("thumb_"+ort.getImgUrl(), "drawable", context.getPackageName());
			holder.imgIcon.setImageResource(id);
			
			return row;

		}
		
	static class OrtHolder {
		ImageView imgIcon;
		TextView txtOrtName;
	}

		

}