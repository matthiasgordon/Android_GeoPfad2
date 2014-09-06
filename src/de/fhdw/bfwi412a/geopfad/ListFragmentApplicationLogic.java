package de.fhdw.bfwi412a.geopfad;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ListFragmentApplicationLogic {

	public final int ADD_LOCATION = 100;
	
	private ListFragment mFrag;
	private ListFragmentGUI mGUI;
	private ListFragmentData mData;
	private IntentBuilder mIntentBuilder;
	
	public ListFragmentApplicationLogic(ListFragment frag, ListFragmentData data, ListFragmentGUI gui) {
		mFrag = frag;
		mData = data;
		mGUI = gui;
		mIntentBuilder = new IntentBuilder();
	}
	
	public void showDetailView(View view){
		TextView txtOrtID = (TextView)view.findViewWithTag("ID");
		int mOrtID = Integer.parseInt(txtOrtID.getText().toString())-1;
		
		Intent intent = mIntentBuilder.buildIntentForActivityLocations(mData.getActivity(), mData.getOrte(), mOrtID);
		mData.getActivity().startActivity(intent);	
	}
	
	public void addLocation() {
		Intent intent = new Intent(mFrag.getActivity(), ActivityAddLocation.class);
		intent.putExtra("listLength", String.valueOf(mGUI.getmListLength()+1));
		mFrag.startActivityForResult(intent, ADD_LOCATION);
	}
	
}
