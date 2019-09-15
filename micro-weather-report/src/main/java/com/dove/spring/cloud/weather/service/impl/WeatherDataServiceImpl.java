package com.dove.spring.cloud.weather.service.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dove.spring.cloud.weather.service.WeatherDataService;
import com.dove.spring.cloud.weather.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 天气数据接口实现类
 * 
 * @author smart-dxw
 *
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	protected static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

	private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 这个StringRedisTemplate jar包在导入的时候会有导入问题报错需要删掉jar包再次导入
	 */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private static final long TOME_OUT = 10L; // 1800秒半小时

	@Override
	public WeatherResponse getDataByCityId(String cityId) {
		// http://wthrcdn.etouch.cn/weather_mini?citykey=101110101
		String uri = WEATHER_URI + "citykey=" + cityId;
		return this.doGetWeather(uri);
	}

	@Override
	public WeatherResponse getDataByCityName(String cityName) {
		// http://wthrcdn.etouch.cn/weather_mini?city=西安
		String uri = WEATHER_URI + "city=" + cityName;
		return this.doGetWeather(uri);
	}

	//
	private WeatherResponse doGetWeather(String uri) {
		// json转换对象
		ObjectMapper mapper = new ObjectMapper();
		String key = uri;
		String strBody = null;
		WeatherResponse weatherResponse = null;

		// 得到缓存
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		// 先查缓存，缓存有的取缓存中的数据
		if (stringRedisTemplate.hasKey(key)) {
			logger.info("Redis has data");
			strBody = ops.get(key);
		} else {
			logger.info("Redis don't has data");
			// 缓存没有，在调用服务接口来获取
			ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
			if (respString.getStatusCodeValue() == 200) {
				strBody = respString.getBody();
			}
			// 数据写入缓存
			ops.set(key, strBody, TOME_OUT, TimeUnit.SECONDS);
		}
		// 通过反序列化得到数据
		try {
			weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
		} catch (Exception e) {
			logger.error("Error" + e);
		}
		return weatherResponse;
	}

	@Override
	public void syncDateByCutyId(String cityId) {
		String uri = WEATHER_URI + "citykey=" + cityId;
		this.saveWeatherData(uri);
	}

	/**
	 * 把天气数据放在缓存
	 * @param uri
	 */
	private void saveWeatherData(String uri) {
		String key = uri;
		String strBody = null;

		// 得到缓存
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		// 缓存没有，在调用服务接口来获取
		ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
		if (respString.getStatusCodeValue() == 200) {
			strBody = respString.getBody();
		}
		// 数据写入缓存
		ops.set(key, strBody, TOME_OUT, TimeUnit.SECONDS);
	}
}