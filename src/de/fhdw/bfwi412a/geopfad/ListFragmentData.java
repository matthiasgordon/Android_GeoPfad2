/** class implemented by Marcel Böttcher und Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;

import java.util.List;

import android.support.v4.app.FragmentActivity;

/**In the class an object "List <location>" mOrte is generated. 
 * This object receives the data read out of the Orte_DOM_Parser.*/
public class ListFragmentData {
	
	private List<Ort> mOrte;
	private FragmentActivity mActivity;
	
	public ListFragmentData(ListFragment mFrag) {
		
		mOrte = Orte_DOM_Parser.getOrteFromFile(mFrag.getActivity());
		mActivity = mFrag.getActivity();
	}

	public List<Ort> getOrte() {
		return mOrte;
	}

	public FragmentActivity getActivity() {
		return mActivity;
	}	
}
