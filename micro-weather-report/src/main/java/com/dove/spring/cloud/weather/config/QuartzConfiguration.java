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
 * Quartz Configuration 定时器任务
 * @author smart-dxw
 *
 */
@Configuration
public class QuartzConfiguration {
	
	
	private static final int TIME = 1800; // 更新频率

	/**
	 * jobDetail 的描述
	 * @return
	 */
	@Bean
	public JobDetail wetherDataSyncJobDetail(){
		return JobBuilder.newJob(WeatherDataSyncJob.class)
				.withIdentity("wetherDataSyncJobDetail")
				.storeDurably()
				.build();
	}
	
	@Bean
	public Trigger weatherDataSyncTrigger(){
		// 定义时间
		SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder
				.simpleSchedule()
				.withIntervalInSeconds(TIME) // 描述
				.repeatForever(); // 重复执行
		
		return TriggerBuilder.newTrigger()
				.forJob(wetherDataSyncJobDetail())
				.withIdentity("weatherDataSyncTrigger")
				.withSchedule(schedBuilder)
				.build();
		
	}
	
	
}
