package com.example.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.weather.persistence.entity.Weather;
import com.example.weather.service.WeatherService;



@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;
	
	 @GetMapping(value="/getWeatherInfo",produces = "application/json; charset=UTF-8")
	 	public ResponseEntity<?> getInfo(@RequestParam(name = "city", required = true) String city) {
		 	if(city!=null) {
		 		return	ResponseEntity.ok(weatherService.getWeather(city));
		 	}
		 	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
	 }
	

}
