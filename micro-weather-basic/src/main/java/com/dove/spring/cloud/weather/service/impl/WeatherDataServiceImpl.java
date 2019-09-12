package com.dove.spring.cloud.weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dove.spring.cloud.weather.service.WeatherDataService;
import com.dove.spring.cloud.weather.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 天气数据接口实现类
 * @author smart-dxw
 *
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	
	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
	
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		// http://wthrcdn.etouch.cn/weather_mini?citykey=101110101
		String uri = WEATHER_URI + "citykey="+cityId;
		return this.doGetWeather(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		// http://wthrcdn.etouch.cn/weather_mini?city=西安
		String uri = WEATHER_URI + "city="+cityName;
		return this.doGetWeather(uri);
	}

	
	private WeatherResponse doGetWeather(String uri){
		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weatherResponse = null;
		String strBody = null;
		
		if(respString.getStatusCodeValue() == 200)
			strBody = respString.getBody();
		try{
			weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
		}catch (Exception e){
			e.printStackTrace();
		}
		return weatherResponse;
	}
}
