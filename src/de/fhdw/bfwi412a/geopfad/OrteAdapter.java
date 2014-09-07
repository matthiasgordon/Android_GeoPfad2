/** class implemented by Marcel Böttcher und Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrteAdapter extends ArrayAdapter<Ort> {

	// declaring
	private Context context;
	private List<Ort> mOrte = null;
	private  int mLayoutResourceId;
	private DistanceCalculator mDistanceCalc;
		
		
	public OrteAdapter(Context context, int layoutResourceId, List<Ort> orte) {
		super(context, layoutResourceId, orte);
		mDistanceCalc = new DistanceCalculator();
		this.mLayoutResourceId = layoutResourceId;
		this.mOrte = orte;
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
				row = inflater.inflate(mLayoutResourceId, parent, false);
			
			
				holder = new OrtHolder();
				holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
				holder.txtOrtName = (TextView)row.findViewById(R.id.txtOrtName);
				holder.txtOrtEntfernung = (TextView)row.findViewById(R.id.txtOrtEntfernung);
				holder.txtOrtID = (TextView)row.findViewById(R.id.txtOrtID);
				
				row.setTag(holder);
			}
			else {
				holder = (OrtHolder)row.getTag();
				
			}
			
			Ort ort = mOrte.get(position);
			holder.txtOrtName.setText(ort.getName());
			holder.txtOrtID.setText(ort.getId());
			
			Double distance = mDistanceCalc.getDistance(ort.getLat(), ort.getLng(), context);
			
			if(distance != 0 && distance != -1) {
				Double distance_rounded = Math.rint(distance*100)/100;
				if(distance_rounded>1000) {
			    	double distance_km = distance / 1000;
			    	double distance_km_gerundet=Math.rint(distance_km*100)/100;
			    	holder.txtOrtEntfernung.setText(String.valueOf(distance_km_gerundet + " km"));
			    }
			    else {
			    	holder.txtOrtEntfernung.setText(String.valueOf(distance_rounded + " m"));
			    }
			}
			
			if(ort.getImgUrl() != null){
				new AdapterAsyncTask(context,holder,ort).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context.getResources().getString(R.string.scale_internal_image));      
			}
			else if(ort.getExtImgUrl() != null) {
				new AdapterAsyncTask(context,holder,ort).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context.getResources().getString(R.string.scale_external_image));
				holder.imgIcon.setImageResource(R.drawable.ic_launcher);
			}
			
			return row;

		}
		
	class OrtHolder {
		ImageView imgIcon;
		TextView txtOrtName;
		TextView txtOrtEntfernung;
		TextView txtOrtID;
	}
}