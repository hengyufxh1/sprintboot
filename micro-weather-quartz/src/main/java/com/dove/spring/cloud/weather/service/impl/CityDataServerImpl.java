package com.dove.spring.cloud.weather.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.dove.spring.cloud.weather.service.CityDataServer;
import com.dove.spring.cloud.weather.utils.XmlBuilder;
import com.dove.spring.cloud.weather.vo.City;
import com.dove.spring.cloud.weather.vo.CityList;

/**
 * City Data Service
 * 实现类
 * @author smart-dxw
 *
 */
@Service
public class CityDataServerImpl implements CityDataServer {

	@Override
	public List<City> listCity() throws Exception {
		// 读取XML文件
		Resource resource = new ClassPathResource("citylist.xml");
		// 开启流读取
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
		StringBuffer buffer = new StringBuffer();
		
		String line = "";
		
		// 循环添加到String里
		while((line = bufferedReader.readLine()) != null){
			buffer.append(line);
		}
		bufferedReader.close();
		// XML转换为Java对象
		CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
		
		return cityList.getCityList();
	}

}
