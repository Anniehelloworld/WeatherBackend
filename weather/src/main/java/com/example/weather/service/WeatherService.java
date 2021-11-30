package com.example.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.weather.persistence.entity.Weather;

@Service
public class WeatherService {
	
	private static final String WEATHER_URI ="https://restapi.amap.com/v3/weather/weatherInfo?city=";
	
	private static final String KEY ="&key=a78277a23f5bb866c94d1024c5843e12";
	
	@Autowired
    private RestTemplate restTemplate;
			
		public Weather getWeather(String city) {
			Weather weather = new Weather();
			String weatherUrl = WEATHER_URI+city+KEY;
	        ResponseEntity<String> weatherEntity = restTemplate.getForEntity(weatherUrl, String.class);
	        String weatherBody = weatherEntity.getBody();
	        JSONObject weatherObject = JSONObject.parseObject(weatherBody);
	        JSONArray lives = weatherObject.getJSONArray("lives");
	        JSONObject res=lives.getJSONObject(0);
	        weather.setCity(res.get("city").toString());
	        weather.setTemperature(res.get("temperature").toString());
	        weather.setUpdatedTime(res.get("reporttime").toString());
	        weather.setWeather(res.get("weather").toString());
	        weather.setWind(res.get("windpower").toString());
	        
	        return weather;
	 }

}
