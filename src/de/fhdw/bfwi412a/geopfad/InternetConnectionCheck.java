package de.fhdw.bfwi412a.geopfad;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/** Class implemented by: Johanna Korten*/

public class InternetConnectionCheck {

	private Context mContext;
	private boolean isConnected;
	
	public InternetConnectionCheck(Context context){
		mContext = context;
		isConnected = isOnline();
	}
	
	public boolean isConnected() {
		return isConnected;
	}

	/**grants the access to WLAN adapter and
	 * checks if WLAN connection is available
	 * */
	
	private boolean isOnline() {
	    ConnectivityManager cm =
	        (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
	    if (netInfo != null && netInfo.isConnectedOrConnecting()) {
	        return true;
	    }
	    return false;
	}
}