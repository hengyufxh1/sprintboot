package com.dove.spring.cloud.weather.service;

import com.dove.spring.cloud.weather.vo.WeatherResponse;

/**
 * 天气数据接口
 * @author smart-dxw
 *
 */
public interface WeatherDataService {
	
	/**
	 * 根据城市ID来查询天气数据
	 * @param cityName
	 * @return
	 */
	WeatherResponse getDataByCityId(String cityId);
	
	/**
	 * 根据城市名称查询天气数据
	 * @param cityName
	 * @return
	 */
	WeatherResponse getDataByCityName(String cityName);
}
