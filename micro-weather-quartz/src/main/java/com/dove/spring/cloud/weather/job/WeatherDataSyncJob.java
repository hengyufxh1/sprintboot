package com.dove.spring.cloud.weather.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 * 天气数据同步Job
 * @author smart-dxw
 *
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Weather Data Sync Job");
	}

}
