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
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityLocationsGUI {
	
	private ActivityLocations mActLoc;
	private ActivityLocationsData mData;
	private TextView mAbout;
	private ImageView mImageUrl;
	private ImageView mImageUrl2;
	private ImageView mImageUrl3;
	private ImageView mExtImageUrl;
	private TextView mVisitStatus;
	private TextView mDistance;
	private CheckBox mBtnVisit;
	private Button mBtnNavigation;
	private Button mBtnShowOnMap;

	public ActivityLocationsGUI(ActivityLocations actloc, ActivityLocationsData data) {
		mActLoc = actloc;
		mData = data;
		mAbout = (TextView) mActLoc.findViewById(R.id.textView2);
		mImageUrl = (ImageView) mActLoc.findViewById(R.id.imageView1);
		mImageUrl2 = (ImageView) mActLoc.findViewById(R.id.imageView2);
		mImageUrl3 = (ImageView) mActLoc.findViewById(R.id.imageView3);
		mExtImageUrl = (ImageView) mActLoc.findViewById(R.id.extImageView);
		mVisitStatus = (TextView) mActLoc.findViewById(R.id.txtVisitStatus);
		mDistance = (TextView) mActLoc.findViewById(R.id.txtDistance);
		mBtnVisit = (CheckBox) mActLoc.findViewById(R.id.btnVisit);
		mBtnShowOnMap = (Button) mActLoc.findViewById(R.id.btnShowOnMap);
		mBtnNavigation = (Button) mActLoc.findViewById(R.id.btnNavigation);
		actloc.getActionBar().setTitle(R.string.bar_title);
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
	
	public ImageView getExtImageUrl() {
		return mExtImageUrl;
	}
	
	public TextView getVisitStatus() {
		return mVisitStatus;
	}
	
	public TextView getDistance() {
		return mDistance;
	}
	
	public CheckBox getBtnVisit(){
		return mBtnVisit;
	}

	public Button getBtnNavigation() {
		return mBtnNavigation;
	}
	
	public Button getBtnShowOnMap() {
		return mBtnShowOnMap;
	}

	public void scalePictures() {
		Bitmap picture = null;
		if(mData.getImageUrl() != null){
			picture = ScalingUtilities.fitScale(mActLoc.getResources(),mActLoc.getResources()
					.getIdentifier(mData.getImageUrl(), "drawable", mActLoc.getPackageName()), mActLoc, 
					mActLoc.getResources().getString(R.string.scale_destination_activity_location));
			mImageUrl.setImageBitmap(picture);
		}
		if(mData.getImageUrl2() != null){
			picture = ScalingUtilities.fitScale(mActLoc.getResources(),mActLoc.getResources()
					.getIdentifier(mData.getImageUrl2(), "drawable", mActLoc.getPackageName()), mActLoc, 
					mActLoc.getResources().getString(R.string.scale_destination_activity_location));
			mImageUrl2.setImageBitmap(picture);
		}
		if(mData.getImageUrl3() != null){
			picture = ScalingUtilities.fitScale(mActLoc.getResources(),mActLoc.getResources()
					.getIdentifier(mData.getImageUrl3(), "drawable", mActLoc.getPackageName()), mActLoc, 
					mActLoc.getResources().getString(R.string.scale_destination_activity_location));
			mImageUrl3.setImageBitmap(picture);
			
		}
		if(mData.getExtImageUrl() != null){	
		picture = ScalingUtilities.fitScaleExtern(mData.getExtImageUrl(), mActLoc, 
				mActLoc.getResources().getString(R.string.scale_destination_activity_location));
        Log.v("Path", mData.getExtImageUrl());
		mExtImageUrl.setImageBitmap(picture);
		}
		if(mData.getAbout() != null){
		mAbout.setText(mData.getAbout());
		}
		if(mData.getVisitStatus() != null){
		mVisitStatus.setText(mData.getVisitStatus()
				.getString(mData.getVisitKey(), mActLoc.getResources().getString(R.string.notvisited)));
		}
	}	
}