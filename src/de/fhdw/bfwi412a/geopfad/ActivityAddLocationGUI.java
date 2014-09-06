package de.fhdw.bfwi412a.geopfad;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityAddLocationGUI {
	ActivityAddLocation mAddLoc;
	ActivityAddLocationData mAddLocData;
	Button mBtnAnlegen;
	Button mBtnbildurl;
	Button mBtnCoordination;
	String mOrtId;
	EditText mEtOrtName;
	EditText mEtAbout;
	EditText mEtLat;
	EditText mEtLng;
	TextView mImageUrl;
	ImageView imgPreview;
	
	public ActivityAddLocationGUI(ActivityAddLocation addLoc, ActivityAddLocationData addLocData) {
		mAddLoc = addLoc;
		mAddLocData = addLocData;
		
		mBtnAnlegen = (Button)mAddLoc.findViewById(R.id.btnAnlegen);
		mBtnbildurl = (Button)mAddLoc.findViewById(R.id.btnbildurl);
		mBtnCoordination = (Button)mAddLoc.findViewById(R.id.btnAddLocationCoordination);
		
		mOrtId = mAddLoc.getIntent().getExtras().getString("listLength");
		mEtOrtName = (EditText)mAddLoc.findViewById(R.id.etxtAddLocationName);
		mEtAbout = (EditText)mAddLoc.findViewById(R.id.etxtAddLocationAbout);
		mEtLat = (EditText)mAddLoc.findViewById(R.id.etxtAddLocationLatitude);
		mEtLng = (EditText)mAddLoc.findViewById(R.id.etxtAddLocationLongitude);
		mImageUrl = (TextView)mAddLoc.findViewById(R.id.bildurl);
		imgPreview = (ImageView)mAddLoc.findViewById(R.id.imgAddLocationPreview);
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
		return imgPreview;
	}
	
}
