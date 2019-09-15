package com.dove.spring.cloud.weather.service;

import java.util.List;

import com.dove.spring.cloud.weather.vo.City;

/**
 * City Data Service 接口
 * @author smart-dxw
 *
 */
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
