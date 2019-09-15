package com.dove.spring.cloud.weather.utils;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Xml Builder 工具类
 * @author smart-dxw
 *
 */
public class XmlBuilder {

	/**
	 * 将xml转换为指定的POJO
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception{
		Object xmlObject = null;
		Reader reader = null;
		JAXBContext context = JAXBContext.newInstance(clazz);
		
		// XML 转换为对象的接口
		Unmarshaller unmarshaller =  context.createUnmarshaller();
		
		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);
		if(null != reader){
			reader.close();
		}
		return xmlObject;
	}
}