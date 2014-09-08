/** class implemented by Marcel Böttcher and Matthias Gordon */
package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.content.Context;
import android.content.Intent;

public class IntentBuilder {
	
	public Intent buildIntentForActivityLocations(Context context, List <Ort> orte, int position) {
		Intent intent = new Intent (context, ActivityLocations.class);
		intent.putExtra("Ortname", orte.get(position).getName());
		intent.putExtra("imageUrl", orte.get(position).getImgUrl());
		intent.putExtra("imageUrl2", orte.get(position).getImgUrl2());
		intent.putExtra("imageUrl3", orte.get(position).getImgUrl3());
		intent.putExtra("extImageUrl", orte.get(position).getExtImgUrl());
		intent.putExtra("about", orte.get(position).getAbout());
		intent.putExtra("latitude", orte.get(position).getLat());
		intent.putExtra("longitude", orte.get(position).getLng());
		intent.putExtra("visitKey", orte.get(position).getVisitKey());
		return intent;
	}
}