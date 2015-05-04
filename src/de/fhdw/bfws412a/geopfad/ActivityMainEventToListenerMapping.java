/*	
**	Copyright 4. Mai 2015 Entwicklerteam:
**	-	B�ttcher, Marcel [egitarre1@gmail.com]
**	-	Glawe, Patrick [patrickglawe@arcor.de]
**	-	Gordon, Matthias [gordon.matthias@googlemail.com]
**	-	Korten, Johanna [johanna.korten@bg.fhdw.de]
**	-	Niedermeier, Marc [marc-niedermeier@web.de]
**	-	Wiegand, Matthias [matthias@compicture.de]
**
**	Der Stadtentwicklungsbetrieb Bergisch Gladbach - A�R hat ein Nutzungsrecht 
**	am Quellcode. Dieser darf im Rahmen der Weiterentwicklung der GEOpfad - 
**	Applikation ver�ndert werden.
**
**	Ohne ausdr�ckliche Zustimmung der Verfasser darf der Quellcode Dritten nicht
**	zug�nglich gemacht werden.
**
**	Eine Vervielf�ltigung und Ver�ffentlichung des Quellcodes ohne ausdr�ckliche
**	Genehmigung - auch in Ausz�gen - ist nicht erlaubt.
**
**	Weitere Informationen entnehmen Sie bitte der README.md
*/

package de.fhdw.bfws412a.geopfad;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager.OnPageChangeListener;

/**
 * Class implemented by: Matthias Gordon
 */

/**
 * The OnPageChangeListener which is set on the ViewPager recognizes if the user changes the
 * fragment via swiping.
 * The TabListener which is set on the tabs recognizes clicks on the tabs.
 */
public class ActivityMainEventToListenerMapping implements OnPageChangeListener, TabListener {
	private ActivityMainGUI mGUI;
	private ActivityMain mAct;

	public ActivityMainEventToListenerMapping(ActivityMain act, ActivityMainGUI gui)
	{
		mAct = act;
		mGUI = gui;
		mGUI.getViewPager().setOnPageChangeListener(this);
		mGUI.getTab1().setTabListener(this);
		mGUI.getTab2().setTabListener(this);
		mGUI.addTabs(mAct.getActionBar());
	}
		
		/**
		 * Once the user selects a fragment via swiping the listener calls this method
		 * and sets the corresponding tab as selected.
		 */
		@Override
		public void onPageSelected(int selectedFragmentID) {
			mAct.getActionBar().setSelectedNavigationItem(selectedFragmentID);
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}

		/**
		 * Once the user selects a fragment via tapping on a tab the listener calls this
		 * method and the corresponding fragment is selected.
		 */
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			mGUI.getViewPager().setCurrentItem(tab.getPosition());
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			
		}
	
}
