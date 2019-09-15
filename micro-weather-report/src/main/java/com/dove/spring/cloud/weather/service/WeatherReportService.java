package com.dove.spring.cloud.weather.service;

import com.dove.spring.cloud.weather.vo.Weather;

/**
 * Weather Report Service
 * @author smart-dxw
 *
 */
public interface WeatherReportService {
	
	Weather getDataByCityId(String cityId);

}
