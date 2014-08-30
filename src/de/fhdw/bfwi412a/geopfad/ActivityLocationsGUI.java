package de.fhdw.bfwi412a.geopfad;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLocationsGUI {
	
	ActivityLocationsApplicationLogic mAppLogic;
	ActivityLocations mActLoc;
	ActivityLocationsData mData;
	TextView mAbout;
	ImageView mImageUrl;
	ImageView mImageUrl2;
	ImageView mImageUrl3;
	TextView mVisitText;
	TextView mVisitStatus;
	TextView mDistance;
	Button mBtnVisit;
	Button mBtnNavigation;
	final ActionBar mActionBar;

	public ActivityLocationsGUI(ActivityLocations actloc, ActivityLocations act, ActivityLocationsData data) {
		mActLoc = actloc;
		mData = data;
		mAbout = (TextView) mActLoc.findViewById(R.id.textView2);
		mImageUrl = (ImageView) mActLoc.findViewById(R.id.imageView1);
		mImageUrl2 = (ImageView) mActLoc.findViewById(R.id.imageView2);
		mImageUrl3 = (ImageView) mActLoc.findViewById(R.id.imageView3);
		mVisitText = (TextView) mActLoc.findViewById(R.id.txtVisitText);
		mVisitStatus = (TextView) mActLoc.findViewById(R.id.txtVisitStatus);
		mDistance = (TextView) mActLoc.findViewById(R.id.txtDistance);
		mBtnVisit = (Button) mActLoc.findViewById(R.id.btnVisit);
		mBtnNavigation = (Button) mActLoc.findViewById(R.id.btnNavigation);
		mActionBar = act.getActionBar();
		mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0979BB")));
		mActionBar.setIcon(R.drawable.actionbar_icon_white);
		mActionBar.setDisplayHomeAsUpEnabled(true);
	}

	public ActionBar getActionBar() {
		return mActionBar;
	}

	public ActivityLocations getActLoc() {
		return mActLoc;
	}

	public TextView getAbout() {
		return mAbout;
	}

	public ImageView getImageUrl() {
		return mImageUrl;
	}
	public ImageView getImageUrl2() {
		return mImageUrl2;
	}

	public ImageView getImageUrl3() {
		return mImageUrl3;
	}
	
	public TextView getVisitText() {
		return mVisitText;
	}
	
	public TextView getVisitStatus() {
		return mVisitStatus;
	}
	
	public TextView getDistance() {
		return mDistance;
	}
	
	public Button getBtnVisit(){
		return mBtnVisit;
	}

	public Button getBtnNavigation() {
		return mBtnNavigation;
	}
	
}
