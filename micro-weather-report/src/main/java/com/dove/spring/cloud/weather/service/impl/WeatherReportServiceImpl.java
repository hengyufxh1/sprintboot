package com.dove.spring.cloud.weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dove.spring.cloud.weather.service.WeatherDataService;
import com.dove.spring.cloud.weather.service.WeatherReportService;
import com.dove.spring.cloud.weather.vo.Weather;
import com.dove.spring.cloud.weather.vo.WeatherResponse;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

	@Autowired
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse reps = weatherDataService.getDataByCityId(cityId);
		return reps.getData();
	}

}
