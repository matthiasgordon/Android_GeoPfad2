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
import android.support.v4.view.ViewPager;

/**
 * Class implemented by: Matthias Gordon
 */

public class ActivityMainGUI {

	private ViewPager mViewPager;
	private ActionBar.Tab mTab1;
	private ActionBar.Tab mTab2;	
	
	public ActivityMainGUI (ActivityMain act)
	{
		/**
		 * The ViewPager enables the possibility to swipe between the two fragments.
		 */
		mViewPager=(ViewPager) act.findViewById(R.id.pager);
		act.getActionBar().setTitle(R.string.bar_title);
	}

	public ViewPager getViewPager() {
		return mViewPager;
	}

	public ActionBar.Tab getTab1() {
		return mTab1;
	}

	public ActionBar.Tab getTab2() {
		return mTab2;
	}

	/**
	 * Two tabs are initialized and the names of them is being set.
	 * @param actionBar the ActionBar of the activity
	 */
	public void initializeTabs (ActionBar actionBar) {
		mTab1 = actionBar.newTab();
		mTab1.setText("Karte");
		
		mTab2 = actionBar.newTab();
		mTab2.setText("Liste");
	}
	
	/**
	 * This method adds the tabs to the ActionBar. It has to be called after the TabListener
	 * is set onto the tabs. Thats the reason why it is called in the EventToListener-Class.
	 * @param actionBar the ActionBar of the activity
	 */
	public void addTabs(ActionBar actionBar) {
		actionBar.addTab(mTab1);
		actionBar.addTab(mTab2);
	}

}