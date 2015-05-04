/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	Böttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - AäR hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation verändert werden.
**
**	Ohne ausdrückliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zugänglich gemacht werden.
**
**	Eine Vervielfältigung und Veröffentlichung des Quellcodes ohne ausdrückliche
**	Genehmigung - auch in Auszügen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;


import de.fhdw.bfwi412a.geopfad.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

/**Overview of all stations will shown in a list*/
public class ListFragment extends Fragment {
	
	private ListFragmentData mData;
	private ListFragmentGUI mGUI;
	private ListFragmentApplicationLogic mAppLogic;
	private ListFragmentEventToListenerMapping mEventToListenerMapping;

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.list_fragment, container, false);
		setHasOptionsMenu(true);
		initData();
		initGUI(mView);
		initApplicationLogic();
		initEventToListenerMapping();
		return mView;
	}

	/**methods implements by: Johanna Korten
	 * get searchview and executes this when searching
	 * */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		/** Handle presses on the action bar items */
		switch (item.getItemId()) {
		case R.id.addLocation:
			mAppLogic.addLocation();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	/**methods implements by: Johanna Korten
	 * get searchview and executes this when searching
	 * */
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.location_actionbar_menu, menu);
		MenuItem searchfield = menu.findItem(R.id.action_search);
		SearchView searchview = (SearchView) searchfield.getActionView();
		searchview.setOnQueryTextListener(mEventToListenerMapping);
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	private void initData() {
		mData = new ListFragmentData(this);
	}
	
	private void initGUI(View mView) {
		mGUI = new ListFragmentGUI(mView, mData);
	}
	
	private void initApplicationLogic() {
		mAppLogic = new ListFragmentApplicationLogic(this, mData, mGUI);
	}
	
	private void initEventToListenerMapping() {
		mEventToListenerMapping = new ListFragmentEventToListenerMapping(this, mData, mGUI, mAppLogic);
	}
	
	/** The method is called when ActivityAddLocation is closed. Also this method
	 * refreshes the ListView.*/
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  if (requestCode == mAppLogic.ADD_LOCATION) {
		initData();
		initGUI(getView());
		initApplicationLogic(); 
		initEventToListenerMapping();
	  }
	} 
	
}