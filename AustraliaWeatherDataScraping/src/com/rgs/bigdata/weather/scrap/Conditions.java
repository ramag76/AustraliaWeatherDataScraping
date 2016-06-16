package com.rgs.bigdata.weather.scrap;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="current_observation")
public class Conditions {

	@XmlTransient private Location displayLocation;
	@XmlTransient private Location observationLocation;
	
	@XmlTransient private String stationId;
	@XmlTransient private Date observationTime;
	@XmlTransient private Date localTime;
	@XmlTransient private String weather;
	@XmlTransient private String tempString;
	@XmlTransient private float tempF;
	@XmlTransient private float tempC;
	@XmlTransient private String relativeHumidity;
	@XmlTransient private String wind;
	@XmlTransient private String windDirection;
	@XmlTransient private int windDegrees;
	@XmlTransient private float windMph;
	@XmlTransient private float windGustMph;
	@XmlTransient private float windKph;
	@XmlTransient private float windGustKph;
	@XmlTransient private int pressureMb;
	@XmlTransient private float pressureIn;
	@XmlTransient private String pressureTrend;
	@XmlTransient private String dewpointString;
	@XmlTransient private float visibilityMi;
	@XmlTransient private float visibilityKm;
	@XmlTransient private int uv;
	
	@XmlTransient private String icon;
	
	
	/**
	 * @return the displayLocation
	 */
	@XmlElement(name="display_location")
	public Location getDisplayLocation() {
		return displayLocation;
	}

	/**
	 * @param displayLocation the displayLocation to set
	 */
	public void setDisplayLocation(Location displayLocation) {
		this.displayLocation = displayLocation;
	}

	/**
	 * @return the observationLocation
	 */
	@XmlElement(name="observation_location")
	public Location getObservationLocation() {
		return observationLocation;
	}

	/**
	 * @param observationLocation the observationLocation to set
	 */
	public void setObservationLocation(Location observationLocation) {
		this.observationLocation = observationLocation;
	}

	/**
	 * @return the temp
	 */
	@XmlElement(name="temp_f")
	public float getTempF() {
		return tempF;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTempF(float temp) {
		this.tempF = temp;
	}

	/**
	 * @return the weather
	 */
	@XmlElement(name="weather")
	public String getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(String weather) {
		this.weather = weather;
	}

	/**
	 * @return the stationId
	 */
	@XmlElement(name="station_id")
	public String getStationId() {
		return stationId;
	}

	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	/**
	 * @return the observationTime
	 */
	@XmlTransient
	public Date getObservationTime() {
		this.observationTime = new Date();
		return observationTime;
	}

	/**
	 * @param observationTime the observationTime to set
	 */
	public void setObservationTime(Date observationTime) {
		this.observationTime = observationTime;
	}
	
	@XmlElement(name="observation_epoch")
	public void setObservationEpoch(long e) {
		this.observationTime = new Date(e);
	}

	/**
	 * @return the localTime
	 */
	@XmlTransient
	public Date getLocalTime() {
		this.localTime = new Date();
		return localTime;
	}

	/**
	 * @param localTime the localTime to set
	 */
	public void setLocalTime(Date localTime) {
		this.localTime = localTime;
	}
	
	@XmlElement(name="local_epoch")
	public void setLocalEpoch(long e) {
		this.localTime = new Date(e);
	}

	/**
	 * @return the tempString
	 */
	@XmlElement(name="temperature_string")
	public String getTempString() {
		return tempString;
	}

	/**
	 * @param tempString the tempString to set
	 */
	public void setTempString(String tempString) {
		this.tempString = tempString;
	}

	/**
	 * @return the tempC
	 */
	@XmlElement(name="temp_c")
	public float getTempC() {
		return tempC;
	}

	/**
	 * @param tempC the tempC to set
	 */
	public void setTempC(float tempC) {
		this.tempC = tempC;
	}

	/**
	 * @return the relativeHumidity
	 */
	@XmlElement(name="relative_humidity")
	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	/**
	 * @param relativeHumidity the relativeHumidity to set
	 */
	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	/**
	 * @return the wind
	 */
	@XmlElement(name="wind_string")
	public String getWind() {
		return wind;
	}

	/**
	 * @param wind the wind to set
	 */
	public void setWind(String wind) {
		this.wind = wind;
	}

	/**
	 * @return the windDirection
	 */
	@XmlElement(name="wind_dir")
	public String getWindDirection() {
		return windDirection;
	}

	/**
	 * @param windDirection the windDirection to set
	 */
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	/**
	 * @return the windDegrees
	 */
	@XmlElement(name="wind_degrees")
	public int getWindDegrees() {
		return windDegrees;
	}

	/**
	 * @param windDegrees the windDegrees to set
	 */
	public void setWindDegrees(int windDegrees) {
		this.windDegrees = windDegrees;
	}

	/**
	 * @return the windMph
	 */
	@XmlElement(name="wind_mph")
	public float getWindMph() {
		return windMph;
	}

	/**
	 * @param windMph the windMph to set
	 */
	public void setWindMph(float windMph) {
		this.windMph = windMph;
	}

	/**
	 * @return the windGustMph
	 */
	@XmlElement(name="wind_gust_mph")
	public float getWindGustMph() {
		return windGustMph;
	}

	/**
	 * @param windGustMph the windGustMph to set
	 */
	public void setWindGustMph(float windGustMph) {
		this.windGustMph = windGustMph;
	}

	/**
	 * @return the windKph
	 */
	@XmlElement(name="wind_kph")
	public float getWindKph() {
		return windKph;
	}

	/**
	 * @param windKph the windKph to set
	 */
	public void setWindKph(float windKph) {
		this.windKph = windKph;
	}

	/**
	 * @return the windGustKph
	 */
	@XmlElement(name="wind_gust_kph")
	public float getWindGustKph() {
		return windGustKph;
	}

	/**
	 * @param windGustKph the windGustKph to set
	 */
	public void setWindGustKph(float windGustKph) {
		this.windGustKph = windGustKph;
	}

	/**
	 * @return the pressureMb
	 */
	@XmlElement(name="pressure_mb")
	public int getPressureMb() {
		return pressureMb;
	}

	/**
	 * @param pressureMb the pressureMb to set
	 */
	public void setPressureMb(int pressureMb) {
		this.pressureMb = pressureMb;
	}

	/**
	 * @return the pressureIn
	 */
	@XmlElement(name="pressure_in")
	public float getPressureIn() {
		return pressureIn;
	}

	/**
	 * @param pressureIn the pressureIn to set
	 */
	public void setPressureIn(float pressureIn) {
		this.pressureIn = pressureIn;
	}

	/**
	 * @return the pressureTrend
	 */
	@XmlElement(name="pressure_trend")
	public String getPressureTrend() {
		return pressureTrend;
	}

	/**
	 * @param pressureTrend the pressureTrend to set
	 */
	public void setPressureTrend(String pressureTrend) {
		this.pressureTrend = pressureTrend;
	}

	/**
	 * @return the dewpointString
	 */
	@XmlElement(name="dewpoint_string")
	public String getDewpointString() {
		return dewpointString;
	}

	/**
	 * @param dewpointString the dewpointString to set
	 */
	public void setDewpointString(String dewpointString) {
		this.dewpointString = dewpointString;
	}

	
	/**
	 * @return the visibilityMi
	 */
	@XmlElement(name="visibility_mi")
	public float getVisibilityMi() {
		return visibilityMi;
	}

	/**
	 * @param visibilityMi the visibilityMi to set
	 */
	public void setVisibilityMi(float visibilityMi) {
		this.visibilityMi = visibilityMi;
	}

	/**
	 * @return the visibilityKm
	 */
	@XmlElement(name="visibility_km")
	public float getVisibilityKm() {
		return visibilityKm;
	}

	/**
	 * @param visibilityKm the visibilityKm to set
	 */
	public void setVisibilityKm(float visibilityKm) {
		this.visibilityKm = visibilityKm;
	}

	/**
	 * @return the uv
	 */
	@XmlElement(name="UV")
	public int getUv() {
		return uv;
	}

	/**
	 * @param uv the uv to set
	 */
	public void setUv(int uv) {
		this.uv = uv;
	}

	/**
	 * @return the icon
	 */
	@XmlElement(name="icon")
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
