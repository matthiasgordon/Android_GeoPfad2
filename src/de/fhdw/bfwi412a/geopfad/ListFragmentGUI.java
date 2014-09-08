/** class implemented by Marcel Böttcher und Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**This class is the interface between the layout and the application 
 * by binding the views of objects to the application.*/
public class ListFragmentGUI {
	
	private ListView mListOrte;
	private OrteAdapter ortAdapter;
	private TextView mError;
	private int mListLength;
	private ListFragmentData mData;
	
	public ListFragmentGUI(View mView, ListFragmentData data) {
		mData = data;
		fillListView(mView, mData.getOrte());
		mError = (TextView) mView.findViewById(R.id.emptyList);
		
	}

	/**The ListView is filled with the location data of the xml files from the internal and external memory.*/
	public void fillListView (View mView, List <Ort> orte){
		ortAdapter = new OrteAdapter(mView.getContext(), R.layout.list_item, orte);
		mListOrte = (ListView) mView.findViewById(R.id.listViewOrte);
		mListOrte.setAdapter(ortAdapter);
		mListOrte.setEmptyView(mError);
		setmListLength(mListOrte.getCount());
	}
	
	public ListView getListOrte() {
		return mListOrte;
	}

	public int getmListLength() {
		return mListLength;
	}

	public void setmListLength(int mListLength) {
		this.mListLength = mListLength;
	}
	
}