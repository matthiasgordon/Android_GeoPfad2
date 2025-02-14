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

package de.fhdw.bfws412a.geopfad.weather;

public class Weather {
	
	/** Class implemented by: Marc Niedermeier:
	 * own created Weather-class to make handling weather data easier*/
	
	private String mWeatherDate;
	private String mWeatherTemperatureHigh;
	private String mWeatherTemperatureLow;
	private String mWeatherCode;
	
	public String getDate() {
		return mWeatherDate;
	}

	public String getTemperatureHigh() {
		return mWeatherTemperatureHigh;
	}

	public String getTemperatureLow() {
		return mWeatherTemperatureLow;
	}

	public String getWeatherCode() {
		return mWeatherCode;
	}

	public void setDate(String mWeatherDate) {
		this.mWeatherDate = mWeatherDate;
	}

	public void setTemperatureHigh(String mWeatherTemperatureHigh) {
		this.mWeatherTemperatureHigh = mWeatherTemperatureHigh;
	}

	public void setTemperatureLow(String mWeatherTemperatureLow) {
		this.mWeatherTemperatureLow = mWeatherTemperatureLow;
	}

	public void setWeatherCode(String mWeatherCode) {
		this.mWeatherCode = mWeatherCode;
	}
}