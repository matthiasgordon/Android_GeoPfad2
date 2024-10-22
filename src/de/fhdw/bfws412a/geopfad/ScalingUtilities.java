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

import de.fhdw.bfwi412a.geopfad.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;

/**
 * Class containing static utility methods for bitmap decoding and scaling
 */
public class ScalingUtilities {

    /**
     * Utility function for decoding an internal and external image resource. The decoded bitmap will
     * be optimized for further scaling to the requested destination dimensions
     * and scaling logic.
     *
     * @param res The resources object containing the image data
     * @param resId The resource id of the image data
     * @param dstWidth Width of destination area
     * @param dstHeight Height of destination area
     * @param scalingLogic Logic to use to avoid image stretching
     * @return Decoded bitmap
     */
	
	/**method implemented by Marcel B�ttcher*/
	 public static Bitmap fitScaleExtern(String mOrtImage, Context context, String destination) {
		 	
	        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
	        
	        int mTotalwidth = metrics.widthPixels;
	        int mTotalheight = metrics.heightPixels;
		 	int mDstWidth = 0;
		 	int mDstHeight = 0;
		 	
		 	if(destination.equals(context.getResources().getString(R.string.scale_destination_fragment_list))){
		 		mDstWidth = context.getResources().getDimensionPixelSize(R.dimen.destination_list_width);
		 		mDstHeight = context.getResources().getDimensionPixelSize(R.dimen.destination_list_height);
		 	}
		 	
		 	if(destination.equals(context.getResources().getString(R.string.scale_destination_activity_location))){
		 		mDstWidth = mTotalwidth;
		        mDstHeight = mTotalheight;
		 	}
		 	
		 	if(destination.equals(context.getResources().getString(R.string.scale_destination_activity_addlocation_image_preview))){
		 		mDstWidth = context.getResources().getDimensionPixelSize(R.dimen.destination_preview_width);
		 		mDstHeight = context.getResources().getDimensionPixelSize(R.dimen.destination_preview_height);
		 	}
	        /** Part 1: Decode image */
	        Bitmap unscaledBitmap = ScalingUtilities.decodeExternResource(mOrtImage,
	                mDstWidth, mDstHeight, ScalingLogic.FIT);

	        /** Part 2: Scale image */
	        Bitmap scaledBitmap = ScalingUtilities.createScaledBitmap(unscaledBitmap, mDstWidth,
	                mDstHeight, ScalingLogic.FIT);
	        unscaledBitmap.recycle();

	        return scaledBitmap;

	    }
	 
	 /** Class overridden by: Marcel B�ttcher*/
	 public static Bitmap fitScale(Resources res, int resId, Context context, String destination) {	
		 
		    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		    double ySize = metrics.heightPixels / metrics.ydpi;
	        double xSize = metrics.widthPixels / metrics.xdpi;
	         
	        // Bildschirmgr�sse in Zoll
	        double screenSize = Math.sqrt(xSize * xSize + ySize * ySize);
	        
		    int mTotalwidth = metrics.widthPixels;
		    int mTotalheight = metrics.heightPixels;
		 	int mDstWidth = 0;
		 	int mDstHeight = 0;
		 	
		 	if(destination.equals(context.getResources().getString(R.string.scale_destination_fragment_list))){
		 		mDstWidth = context.getResources().getDimensionPixelSize(R.dimen.destination_list_width);
		 		mDstHeight = context.getResources().getDimensionPixelSize(R.dimen.destination_list_height);
		 	}
		 	
		 	if(destination.equals(context.getResources().getString(R.string.scale_destination_activity_location))){
		 		mDstWidth = mTotalwidth;
		        mDstHeight = mTotalheight;
		 	}
		 	
		 	if(destination.equals(context.getResources().getString(R.string.scale_destination_activity_start_image_snail))){
		 		if(screenSize < 4) {
		 			mDstWidth = mTotalwidth - 250;
			        mDstHeight = mTotalheight - 250;
		 		}
		 		else{
		 		mDstWidth = mTotalwidth - 200;
		        mDstHeight = mTotalheight - 200;
		 		}
		 	}
		    /** Part 1: Decode image */
		    Bitmap unscaledBitmap = ScalingUtilities.decodeResource(res, resId,mDstWidth, mDstHeight, ScalingLogic.FIT);
		
		    /** Part 2: Scale image */
		    Bitmap scaledBitmap = ScalingUtilities.createScaledBitmap(unscaledBitmap, mDstWidth,mDstHeight, ScalingLogic.FIT);
		    unscaledBitmap.recycle();
		
		    return scaledBitmap;

 }
	 /** Class overridden by: Marcel B�ttcher*/
    public static Bitmap decodeResource(Resources res, int resId, int dstWidth, int dstHeight,
            ScalingLogic scalingLogic) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = calculateSampleSize(options.outWidth, options.outHeight, dstWidth,
                dstHeight, scalingLogic);
        Bitmap unscaledBitmap = BitmapFactory.decodeResource(res, resId, options);

        return unscaledBitmap;
    }

    /** Class implemented by: Marcel B�ttcher*/
    public static Bitmap decodeExternResource(String res, int dstWidth, int dstHeight,
            ScalingLogic scalingLogic) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(res, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = calculateSampleSize(options.outWidth, options.outHeight, dstWidth,
                dstHeight, scalingLogic);
        Bitmap unscaledBitmap = BitmapFactory.decodeFile(res, options);

        return unscaledBitmap;
    }
    
    /**
     * Utility function for creating a scaled version of an existing bitmap
     *
     * @param unscaledBitmap Bitmap to scale
     * @param dstWidth Wanted width of destination bitmap
     * @param dstHeight Wanted height of destination bitmap
     * @param scalingLogic Logic to use to avoid image stretching
     * @return New scaled bitmap object
     */
    public static Bitmap createScaledBitmap(Bitmap unscaledBitmap, int dstWidth, int dstHeight,
            ScalingLogic scalingLogic) {
        Rect srcRect = calculateSrcRect(unscaledBitmap.getWidth(), unscaledBitmap.getHeight(),
                dstWidth, dstHeight, scalingLogic);
        Rect dstRect = calculateDstRect(unscaledBitmap.getWidth(), unscaledBitmap.getHeight(),
                dstWidth, dstHeight, scalingLogic);
        Bitmap scaledBitmap = Bitmap.createBitmap(dstRect.width(), dstRect.height(),
                Config.ARGB_8888);
        Canvas canvas = new Canvas(scaledBitmap);
        canvas.drawBitmap(unscaledBitmap, srcRect, dstRect, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;
    }

    /**
     * ScalingLogic defines how scaling should be carried out if source and
     * destination image has different aspect ratio.
     *
     * CROP: Scales the image the minimum amount while making sure that at least
     * one of the two dimensions fit inside the requested destination area.
     * Parts of the source image will be cropped to realize this.
     *
     * FIT: Scales the image the minimum amount while making sure both
     * dimensions fit inside the requested destination area. The resulting
     * destination dimensions might be adjusted to a smaller size than
     * requested.
     */
    public static enum ScalingLogic {
        CROP, FIT
    }

    /**
     * Calculate optimal down-sampling factor given the dimensions of a source
     * image, the dimensions of a destination area and a scaling logic.
     *
     * @param srcWidth Width of source image
     * @param srcHeight Height of source image
     * @param dstWidth Width of destination area
     * @param dstHeight Height of destination area
     * @param scalingLogic Logic to use to avoid image stretching
     * @return Optimal down scaling sample size for decoding
     */
    public static int calculateSampleSize(int srcWidth, int srcHeight, int dstWidth, int dstHeight,
            ScalingLogic scalingLogic) {
        if (scalingLogic == ScalingLogic.FIT) {
            final float srcAspect = (float)srcWidth / (float)srcHeight;
            final float dstAspect = (float)dstWidth / (float)dstHeight;

            if (srcAspect > dstAspect) {
                return srcWidth / dstWidth;
            } else {
                return srcHeight / dstHeight;
            }
        } else {
            final float srcAspect = (float)srcWidth / (float)srcHeight;
            final float dstAspect = (float)dstWidth / (float)dstHeight;

            if (srcAspect > dstAspect) {
                return srcHeight / dstHeight;
            } else {
                return srcWidth / dstWidth;
            }
        }
    }

    /**
     * Calculates source rectangle for scaling bitmap
     *
     * @param srcWidth Width of source image
     * @param srcHeight Height of source image
     * @param dstWidth Width of destination area
     * @param dstHeight Height of destination area
     * @param scalingLogic Logic to use to avoid image stretching
     * @return Optimal source rectangle
     */
    public static Rect calculateSrcRect(int srcWidth, int srcHeight, int dstWidth, int dstHeight,
            ScalingLogic scalingLogic) {
        if (scalingLogic == ScalingLogic.CROP) {
            final float srcAspect = (float)srcWidth / (float)srcHeight;
            final float dstAspect = (float)dstWidth / (float)dstHeight;

            if (srcAspect > dstAspect) {
                final int srcRectWidth = (int)(srcHeight * dstAspect);
                final int srcRectLeft = (srcWidth - srcRectWidth) / 2;
                return new Rect(srcRectLeft, 0, srcRectLeft + srcRectWidth, srcHeight);
            } else {
                final int srcRectHeight = (int)(srcWidth / dstAspect);
                final int scrRectTop = (int)(srcHeight - srcRectHeight) / 2;
                return new Rect(0, scrRectTop, srcWidth, scrRectTop + srcRectHeight);
            }
        } else {
            return new Rect(0, 0, srcWidth, srcHeight);
        }
    }

    /**
     * Calculates destination rectangle for scaling bitmap
     *
     * @param srcWidth Width of source image
     * @param srcHeight Height of source image
     * @param dstWidth Width of destination area
     * @param dstHeight Height of destination area
     * @param scalingLogic Logic to use to avoid image stretching
     * @return Optimal destination rectangle
     */
    public static Rect calculateDstRect(int srcWidth, int srcHeight, int dstWidth, int dstHeight,
            ScalingLogic scalingLogic) {
        if (scalingLogic == ScalingLogic.FIT) {
            final float srcAspect = (float)srcWidth / (float)srcHeight;
            final float dstAspect = (float)dstWidth / (float)dstHeight;

            if (srcAspect > dstAspect) {
                return new Rect(0, 0, dstWidth, (int)(dstWidth / srcAspect));
            } else {
                return new Rect(0, 0, (int)(dstHeight * srcAspect), dstHeight);
            }
        } else {
            return new Rect(0, 0, dstWidth, dstHeight);
        }
    }

}
