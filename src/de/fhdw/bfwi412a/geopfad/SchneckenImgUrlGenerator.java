package de.fhdw.bfwi412a.geopfad;
/**Class implemented by: Matthias Wiegand
 * SchneckenImgGenerator transforms the amount of achievements to an image-URL 
 * to display the right "Schnecken"-image an the ActivityStart*/

public class SchneckenImgUrlGenerator {
	private String mImgUrl;
	
	public SchneckenImgUrlGenerator(int achievement){
		mImgUrl = getImageUrl(achievement);
	}
	
	public String getImgUrl() {
		return mImgUrl;
	}

	/**Transforms int to the imgURL
	 * @param int that describes the achievement
	 * @return imgUrl of the right "Schnecken"-image
	 * */
	
	private String getImageUrl (int achievement){
		String imageUrl = "prozent_0";
		if(achievement > 17){
			imageUrl = "prozent_100";
		}else{
				
			switch(achievement){
			case 0:
				imageUrl = "prozent_0";
				break;
			case 1:
				imageUrl = "prozent_6";
				break;
			case 2:
				imageUrl = "prozent_12";
				break;
			case 3:
				imageUrl = "prozent_18";
				break;
			case 4:
				imageUrl = "prozent_24";
				break;
			case 5:
				imageUrl = "prozent_29";
				break;
			case 6:
				imageUrl = "prozent_35";
				break;
			case 7:
				imageUrl = "prozent_41";
				break;
			case 8:
				imageUrl = "prozent_47";
				break;
			case 9:
				imageUrl = "prozent_53";
				break;
			case 10:
				imageUrl = "prozent_59";
				break;
			case 11:
				imageUrl = "prozent_65";
				break;
			case 12:
				imageUrl = "prozent_71";
				break;
			case 13:
				imageUrl = "prozent_76";
				break;
			case 14:
				imageUrl = "prozent_82";
				break;
			case 15:
				imageUrl = "prozent_88";
				break;
			case 16:
				imageUrl = "prozent_94";
				break;
			case 17:
				imageUrl = "prozent_100";
				break;
			}
		}
			return imageUrl;
	}
}