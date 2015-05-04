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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**This class is the interface between the layout and the application 
 * by binding the views to objects of the application.*/
public class ActivityAddLocationGUI {
	private ActivityAddLocation mAddLoc;
	private ActivityAddLocationData mAddLocData;
	private Button mBtnAnlegen;
	private Button mBtnbildurl;
	private Button mBtnCoordination;
	private String mOrtId;
	private EditText mEtOrtName;
	private EditText mEtAbout;
	private EditText mEtLat;
	private EditText mEtLng;
	private TextView mImageUrl;
	private ImageView mImgPreview;
	private String mVisitKey;
	
	public ActivityAddLocationGUI(ActivityAddLocation addLoc, ActivityAddLocationData addLocData) {
		mAddLoc = addLoc;
		mAddLocData = addLocData;
		
		mBtnAnlegen = (Button)mAddLoc.findViewById(R.id.btnAnlegen);
		mBtnbildurl = (Button)mAddLoc.findViewById(R.id.btnbildurl);
		mBtnCoordination = (Button)mAddLoc.findViewById(R.id.btnAddLocationCoordination);
		
		mOrtId = mAddLoc.getIntent().getExtras().
				getString(mAddLoc.getResources().
						getString(R.string.intent_extras_list_length));
		mEtOrtName = (EditText)mAddLoc.findViewById(R.id.etxtAddLocationName);
		mEtAbout = (EditText)mAddLoc.findViewById(R.id.etxtAddLocationAbout);
		mEtLat = (EditText)mAddLoc.findViewById(R.id.etxtAddLocationLatitude);
		mEtLng = (EditText)mAddLoc.findViewById(R.id.etxtAddLocationLongitude);
		mImageUrl = (TextView)mAddLoc.findViewById(R.id.bildurl);
		mImgPreview = (ImageView)mAddLoc.findViewById(R.id.imgAddLocationPreview);
		addLoc.getActionBar().setTitle(R.string.bar_title);
	}

	public ActivityAddLocation getmAddLoc() {
		return mAddLoc;
	}

	public ActivityAddLocationData getmAddLocData() {
		return mAddLocData;
	}

	public Button getmBtnAnlegen() {
		return mBtnAnlegen;
	}

	public Button getmBtnbildurl() {
		return mBtnbildurl;
	}

	public Button getmBtnCoordination() {
		return mBtnCoordination;
	}

	public String getmOrtId() {
		return mOrtId;
	}

	public EditText getmEtOrtName() {
		return mEtOrtName;
	}

	public EditText getmEtAbout() {
		return mEtAbout;
	}

	public EditText getmEtLat() {
		return mEtLat;
	}

	public EditText getmEtLng() {
		return mEtLng;
	}

	public TextView getmImageUrl() {
		return mImageUrl;
	}

	public ImageView getImgPreview() {
		return mImgPreview;
	}

	public String getmVisitKey() {
		return mVisitKey;
	}

	public void setmVisitKey(String mVisitKey) {
		this.mVisitKey = mVisitKey;
	}
	
}
