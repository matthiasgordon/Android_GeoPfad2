/** class implemented by Marcel B�ttcher und Patrick Glawe */
package de.fhdw.bfwi412a.geopfad;



public class Ort {
	private String id;
	private String name;
	private String imgUrl;
	private String imgUrl2;
	private String imgUrl3;
	private String extImgUrl;
	private String about;
	private String link;	
	private double latitude;
	private double longitude;
	private String visitKey;
	
	public Ort(){
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ort(String Errormessage){
		name = Errormessage;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getImgUrl2() {
		return imgUrl2;
	}

	public void setImgUrl2(String imgUrl2) {
		this.imgUrl2 = imgUrl2;
	}

	public String getImgUrl3() {
		return imgUrl3;
	}

	public void setImgUrl3(String imgUrl3) {
		this.imgUrl3 = imgUrl3;
	}
	public String getAbout() {
		return about;
	}
	public String getExtImgUrl() {
		return extImgUrl;
	}

	public void setExtImgUrl(String extImgUrl) {
		this.extImgUrl = extImgUrl;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public double getLat() {
		return latitude;
	}
	public void setLat(double latitude) {
		this.latitude = latitude;
	}
	public double getLng() {
		return longitude;
	}
	public void setLng(double longitude) {
		this.longitude = longitude;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getVisitKey() {
		return visitKey;
	}
	public void setVisitKey(String visitKey) {
		this.visitKey = visitKey;
	}
	

}
