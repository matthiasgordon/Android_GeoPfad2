package de.fhdw.bfwi412a.geopfad;

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