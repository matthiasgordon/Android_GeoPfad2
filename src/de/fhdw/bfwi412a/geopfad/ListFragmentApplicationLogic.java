package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ListFragmentApplicationLogic {

	public final int ADD_LOCATION = 100;
	
	private ListFragment mFrag;
	private ListFragmentGUI mGUI;
	private ListFragmentData mData;
	
	public ListFragmentApplicationLogic(ListFragment frag, ListFragmentData data, ListFragmentGUI gui) {
		mFrag = frag;
		mData = data;
		mGUI = gui;
	}
	
	public void showDetailView(View view){
		List <Ort> orte = mData.getOrte();
		TextView txtOrtID = (TextView)view.findViewWithTag("ID");
		int mOrtID = Integer.parseInt(txtOrtID.getText().toString())-1;
		
		Intent intent = new Intent(mData.getActivity(), ActivityLocations.class);
		intent.putExtra("Ortname", orte.get(mOrtID).getName());
		intent.putExtra("imageUrl", orte.get(mOrtID).getImgUrl());
		intent.putExtra("imageUrl2", orte.get(mOrtID).getImgUrl2());
		intent.putExtra("imageUrl3", orte.get(mOrtID).getImgUrl3());
		intent.putExtra("extImageUrl", orte.get(mOrtID).getExtImgUrl());
		intent.putExtra("about", orte.get(mOrtID).getAbout());
		intent.putExtra("latitude", orte.get(mOrtID).getLat());
		intent.putExtra("longitude", orte.get(mOrtID).getLng());
		intent.putExtra("visitKey", orte.get(mOrtID).getVisitKey());

		
		mData.getActivity().startActivity(intent);	
	}
	
	public void addLocation() {
		Intent intent = new Intent(mFrag.getActivity(), AddLocation.class);
		intent.putExtra("listLength", String.valueOf(mGUI.getmListLength()+1));
		mFrag.startActivityForResult(intent, ADD_LOCATION);
	}
	
}
