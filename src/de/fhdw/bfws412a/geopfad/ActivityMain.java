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
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Class implemented by: Matthias Gordon 
 * The ActivityMain displays two fragments and a tab-navigation. With the tabs you can navigate
 * from one fragment to the other. Also it is possible to swipe to change the displayed fragment.
 * The displayed fragments are the MapFragment and the ListFragment.
 */

/**
 * The extends FragmentActivity is needed because two fragments are embedded into the activity.
 */
public class ActivityMain extends FragmentActivity {
	
	private ActivityMainGUI mGUI;
	private ActivityMainData mData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}
	
	private void initData () {
		mData = new ActivityMainData(this);
	}

	private void initGUI () {
		setContentView(R.layout.activity_main);
		mGUI = new ActivityMainGUI(this);
		/**
		 * The FragmentAdapter has to been set on the ViewPager so that it knows which Fragments
		 * to show.
		 */
		mGUI.getViewPager().setAdapter(new FragmentAdapter (getSupportFragmentManager(), mData.getLocationName()));
		
		/**
		 * The ActionBar of the Activity is set to "Navigation-Mode-Tabs" which enables
		 * the possibility to add a tab-navigation.
		 */
		this.getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mGUI.initializeTabs(this.getActionBar());
	}
	
	private void initApplicationLogic () {
		
	}
	
	private void initEventToListenerMapping () {
		new ActivityMainEventToListenerMapping(this, mGUI);
	}
}