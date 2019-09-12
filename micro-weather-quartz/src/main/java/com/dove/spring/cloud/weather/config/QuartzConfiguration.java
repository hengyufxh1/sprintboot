package com.dove.spring.cloud.weather.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dove.spring.cloud.weather.job.WeatherDataSyncJob;

/**
 * Quartz Configuration
 * @author smart-dxw
 *
 */
@Configuration
public class QuartzConfiguration {

	// JobDetail
	@Bean
	public JobDetail weatherDataSyncJobJobDetail(){
		return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("WeatherDataSyncJob")
		.storeDurably()
		.build();
	}
	
	// Trigger
	@Bean
	public Trigger weatherDataSyncTrigger(){
		// 2秒
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2)
				.repeatForever();
		
		return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail())
				.withIdentity("weatherDataSyncTrigger")
				.withSchedule(scheduleBuilder)
				.build();
	}
}
