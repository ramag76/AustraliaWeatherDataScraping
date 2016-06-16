package com.rgs.bigdata.weather.scrap;


import java.text.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimeZone;
import java.text.SimpleDateFormat;

import javax.ws.rs.core.MediaType;

import com.rgs.bigdata.weather.scrap.AstronomyTime;
import com.rgs.bigdata.weather.scrap.WeatherResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WeatherRequest {

	private final static String BASE_URL = "http://api.wunderground.com/api/";
	
	private String apiKey;
	
	private Set<Feature> features;
	
	public static WeatherRequest req;
	
	public WeatherRequest() {
		this.apiKey = apiKey;
		this.features = new HashSet<Feature>();
	}
	
	public void setApiKey(String k) {
		this.apiKey = k;
	}
	
	public void addFeature(Feature f) {
		this.features.add(f);
	}
	

	public WeatherResponse query2(String city) {
		
		if (this.apiKey == null) {
			return null;
		}
		
		if (this.features.size() == 0) {
			return null;
		}
		
		Client c = Client.create();
		
		String url = BASE_URL + this.apiKey + "/";
		Iterator<Feature> i = this.features.iterator();
		while (i.hasNext()) {
			url += i.next() + "/";
		}
		url += "q/" + city + ".json";
		
		//http://api.wunderground.com/api/a67708eb2e1e70f3/q/Australia/Sydney.json
		// http://api.wunderground.com/api/a67708eb2e1e70f3/q/2016/1/15/WeeklyHistory.html?req_city=Sydney
		
		WebResource r = c.resource(url);
		ClientResponse response = r.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		WeatherResponse w = response.getEntity(WeatherResponse.class);
		return w;
		
	}
	
	// Data cleansing is done here, especially to fulfil the requirements of localtime of the timeezone
	// and IATA code for the city
	
	
	public String getDataForCity(String city){
		
		req.setApiKey("a67708eb2e1e70f3");
		req.addFeature(Feature.CONDITIONS);
		req.addFeature(Feature.FORECAST);
		req.addFeature(Feature.ALERTS);
		req.addFeature(Feature.LOCATION);
		WeatherResponse resp = req.query2(city);
		String localTime = null;
		String IATACode = "null" ;
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// Requirement  :	Data Cleaning is required for date format 

		//System.out.println("Station ID : " + resp.getConditions().getStationId());
		//System.out.println("Current temp(F): " + resp.getConditions().getObservationLocation().getCity());
		//System.out.println("Local Time : " + dateFormat.format(resp.getConditions().getLocalTime()));
		/*System.out.println("Condition : " + resp.getConditions().getWeather());
		System.out.println("Temperature: " + resp.getConditions().getTempF());
		System.out.println("Pressure: " + resp.getConditions().getPressureIn());
		System.out.println("Humidity: " + resp.getConditions().getRelativeHumidity());*/
		

		if (city == "Australia/Sydney") {
		   IATACode = "SYD";	   
		   // Use Sydney's time zone to format the date in
		   df.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		  // System.out.println("Date and time in Sydney: " + df.format(date));
		   localTime = df.format(date);
		} else if (city == "Australia/Melbourne") {
			IATACode = "MEL";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Melbourne"));
			 //  System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		else if (city == "Australia/Adelaide") {
			IATACode = "ADL";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Adelaide"));
			//   System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		else if (city == "Australia/Darwin") {
			IATACode = "DRW";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Darwin"));
			 //  System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		else if (city == "Australia/Perth") {
			IATACode = "PER";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Perth"));
			  // System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		else if (city == "Australia/Hobart") {
			IATACode = "HBR";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Hobart"));
			  // System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		else if (city == "Australia/Brisbane") {
			IATACode = "BNE";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Brisbane"));
			 //  System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		else if (city == "Australia/Cairns") {
			IATACode = "CNS";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Cairns"));
			  // System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		
		else if (city == "Australia/Canberra") {
			IATACode = "CBR";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Canberra"));
			  // System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		
		else if (city == "Australia/Eucla") {
			IATACode = "EUC";
			   df.setTimeZone(TimeZone.getTimeZone("Australia/Eucla"));
			  // System.out.println("Date and time in Sydney: " + df.format(date));
			   localTime = df.format(date);
		}
		
		String finalString = IATACode+"|"+localTime+"|"+
				resp.getConditions().getWeather()+"|"+resp.getConditions().getTempF()+"|"+resp.getConditions().getPressureIn()+"|"+resp.getConditions().getRelativeHumidity();
		return finalString;
	}
		
	public static void main(String[] args) {
		req = new WeatherRequest();
		
		// Although number of lines is too many here, however, this is the only place in the
		// project, if you want to remove any cities for which data need not be collected.
		// This can be optimized and moved to a separate method as well.
		
		// Randomly selected 10 Key cities across Australia.
		
		String data = req.getDataForCity("Australia/Melbourne");

		data= data + "\n"  +req.getDataForCity("Australia/Sydney");
		
		data= data +  "\n" +req.getDataForCity("Australia/Adelaide");
		
		data= data +  "\n" +req.getDataForCity("Australia/Perth");

		data= data +  "\n" +req.getDataForCity("Australia/Cairns");

		data= data +  "\n" +req.getDataForCity("Australia/Darwin");

		data= data +  "\n" +req.getDataForCity("Australia/Hobart");

		data= data +  "\n" +req.getDataForCity("Australia/Brisbane");
		
		data= data +  "\n" +req.getDataForCity("Australia/Canberra");
		
		data= data +  "\n" +req.getDataForCity("Australia/Eucla");
		
		System.out.println("\nStation\t"+"LocalTime\t"+"Conditions\t"+"Temperatures  "+"Pressure  "+"Humidity\t\n");
		System.out.println(data);
	}
		
}
