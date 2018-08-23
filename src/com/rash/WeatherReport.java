package com.rash;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class WeatherReport {

 private String BaseUrl;
 private String ResponderUrl;

 public WeatherReport(String baseUrl,String ResponderUrl, String queryParameter) {
         this.BaseUrl = baseUrl;
         this.ResponderUrl = ResponderUrl+queryParameter;
 }

 public String ApiResponder(String key) throws MalformedURLException, IOException, ParseException {
         HttpURLConnection httpcon = (HttpURLConnection) ((new URL(this.BaseUrl+this.ResponderUrl).openConnection()));
         httpcon.setRequestMethod("GET");
         httpcon.connect();

         BufferedReader inreader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
         String decodedString = inreader.readLine();
         inreader.close();
         httpcon.disconnect();
         JSONParser parser = new JSONParser();
         JSONArray msg = (JSONArray) parser.parse(decodedString);
         if(msg.size()==1) {
        	 	Long id = (Long)((JSONObject)msg.get(0)).get(key);   
        	 	return id+"";
         }
         Double temp =0D;
         int i=0;
         for(;i<msg.size();i++) {
        	 	 temp += (Double)((JSONObject)msg.get(0)).get(key);
         }
         //get avg        
         return temp/i+"";
 }

public String getBaseUrl() {
	return BaseUrl;
}

public void setBaseUrl(String baseUrl) {
	BaseUrl = baseUrl;
}

public String getResponderUrl() {
	return ResponderUrl;
}

public void setResponderUrl(String responderUrl) {
	ResponderUrl = responderUrl;
}
 
}


