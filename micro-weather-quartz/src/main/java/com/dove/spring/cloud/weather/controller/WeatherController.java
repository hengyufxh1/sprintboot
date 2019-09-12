package com.dove.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dove.spring.cloud.weather.service.WeatherDataService;
import com.dove.spring.cloud.weather.vo.WeatherResponse;

/**
 * Weather Controller
 * @author smart-dxw
 *
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherDataService weatherDataService;

	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
		return weatherDataService.getDataByCityId(cityId);
	}
	
	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName){
		return weatherDataService.getDataByCityName(cityName);
	}
}
