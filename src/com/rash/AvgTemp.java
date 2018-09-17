package com.rash;

import java.text.SimpleDateFormat;

public class AvgTemp implements Runnable {

	static String datesParam[] = { "2018/6/01/", "2018/6/02/", "2018/6/03/" };
	String tempOfTheDay;
	String city;

	AvgTemp(String s) {
		tempOfTheDay = null;
		city = s;
	}

	@Override
	public void run() {
		try {
		WeatherReport api = new WeatherReport("https://www.metaweather.com", "/api/location/search",
				"?query="+city);
		String woeid = api.ApiResponder("woeid");
		//System.out.println(woeid);
		for (int i = 0; i < datesParam.length; i++) {
			api.setResponderUrl("/api/location/" + woeid +"/" +datesParam[i]);
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			System.out.println("The avg temperature of "+city+" on "+ format.parse(datesParam[i])
			 	+ " is "+api.ApiResponder("the_temp"));
		}
		}
		catch(Exception e) {
			System.out.println("exception occurred"+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args)  {
		Thread t1 = new Thread(new AvgTemp("bangalore")),t2 =new Thread(new AvgTemp("mumbai")) ,
				t3= new Thread(new AvgTemp("delhi"));
		t1.start();
		t2.start();
		t3.start();
	}

}
