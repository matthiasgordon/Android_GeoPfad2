package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class ListFragmentGUI {
	
	private ListView mListOrte;
	private OrteAdapter ortAdapter;
	private TextView mError;
	
	ListFragmentData mData;
	
	public ListFragmentGUI(View mView, ListFragmentData data) {
		mData = data;
		fillListView(mView, mData.getOrte());
		mError = (TextView) mView.findViewById(R.id.emptyList);
		
	}

	public void fillListView (View mView, List <Ort> orte){
		ortAdapter = new OrteAdapter(mView.getContext(), R.layout.list_item, orte);
		mListOrte = (ListView) mView.findViewById(R.id.listViewOrte);
		mListOrte.setAdapter(ortAdapter);
		mListOrte.setEmptyView(mError);
	}
	
	public ListView getListOrte() {
		return mListOrte;
	}
	
}