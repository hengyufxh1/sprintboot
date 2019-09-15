package com.dove.spring.cloud.weather.job;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.dove.spring.cloud.weather.service.CityDataService;
import com.dove.spring.cloud.weather.service.WeatherDataService;
import com.dove.spring.cloud.weather.vo.City;

/**
 * 同步job任务
 * Weather Data Sync Job
 * @author smart-dxw
 *
 */
public class WeatherDataSyncJob extends QuartzJobBean {

	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@Autowired
	private CityDataService cityDataServer; 
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		
		logger.info("Weather Data Sync Job Start!");
		
		// 获取城市ID列表
		List<City> cityList = null;
		try{
			cityList = cityDataServer.listCity();
		}catch(Exception e){
			logger.error("Exception!"+e);
		}
		
		// 遍历城市ID获取天气
		for(City city:cityList){
			String cityId = city.getCityId();
			logger.info("Weather Data Sync Job, cityId:"+cityId);
			weatherDataService.syncDateByCutyId(cityId);
		}
		logger.info("Weather Data Sync Job End!");
	}
}
