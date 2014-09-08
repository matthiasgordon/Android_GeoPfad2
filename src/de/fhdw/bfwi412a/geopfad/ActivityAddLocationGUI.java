/** class implemented by Marcel Böttcher */
package de.fhdw.bfwi412a.geopfad;

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
