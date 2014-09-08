/** class implemented by Marcel Böttcher und Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;

/**includes the attributes of a location object*/
public class Ort {
	private String mId;
	private String mName;
	private String mImgUrl;
	private String mImgUrl2;
	private String mImgUrl3;
	private String mExtImgUrl;
	private String mAbout;	
	private double mLatitude;
	private double mLongitude;
	private String mVisitKey;
	
	public Ort(){
		
	}
	
	public String getId() {
		return mId;
	}

	public void setId(String id) {
		this.mId = id;
	}

	public Ort(String Errormessage){
		mName = Errormessage;
	}
	
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		this.mName = name;
	}
	public String getImgUrl() {
		return mImgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.mImgUrl = imgUrl;
	}
	public String getImgUrl2() {
		return mImgUrl2;
	}

	public void setImgUrl2(String imgUrl2) {
		this.mImgUrl2 = imgUrl2;
	}

	public String getImgUrl3() {
		return mImgUrl3;
	}

	public void setImgUrl3(String imgUrl3) {
		this.mImgUrl3 = imgUrl3;
	}
	public String getAbout() {
		return mAbout;
	}
	public String getExtImgUrl() {
		return mExtImgUrl;
	}

	public void setExtImgUrl(String extImgUrl) {
		this.mExtImgUrl = extImgUrl;
	}
	public void setAbout(String about) {
		this.mAbout = about;
	}
	public double getLat() {
		return mLatitude;
	}
	public void setLat(double latitude) {
		this.mLatitude = latitude;
	}
	public double getLng() {
		return mLongitude;
	}
	public void setLng(double longitude) {
		this.mLongitude = longitude;
	}
	public String getVisitKey() {
		return mVisitKey;
	}
	public void setVisitKey(String visitKey) {
		this.mVisitKey = visitKey;
	}
	

}
