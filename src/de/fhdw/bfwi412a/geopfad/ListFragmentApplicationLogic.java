package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.content.Intent;

public class ListFragmentApplicationLogic {

	private ListFragment mFrag;
	private ListFragmentGUI mGUI;
	private ListFragmentData mData;
	
	public ListFragmentApplicationLogic(ListFragment frag, ListFragmentData data, ListFragmentGUI gui) {
		mFrag = frag;
		mData = data;
		mGUI = gui;
	}
	
	public void showDetailView(int position){
		List <Ort> orte = mData.getOrte();
		Intent intent = new Intent(mData.getActivity(), ActivityLocations.class);
		intent.putExtra("Ortname", orte.get(position).getName());
		intent.putExtra("imageUrl", orte.get(position).getImgUrl());
		intent.putExtra("imageUrl2", orte.get(position).getImgUrl2());
		intent.putExtra("imageUrl3", orte.get(position).getImgUrl3());
		intent.putExtra("extImageUrl", orte.get(position).getExtImgUrl());
		intent.putExtra("about", orte.get(position).getAbout());
		intent.putExtra("latitude", orte.get(position).getLat());
		intent.putExtra("longitude", orte.get(position).getLng());
		intent.putExtra("visitKey", orte.get(position).getVisitKey());

		
		mData.getActivity().startActivity(intent);	
	}
	
	public void addLocation() {
		Intent intent = new Intent(mFrag.getActivity(), AddLocation.class);
		intent.putExtra("listLength", String.valueOf(mGUI.getmListLength()+1));
		mFrag.startActivity(intent);
	}
	
}
