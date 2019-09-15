package com.dove.spring.cloud.weather.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 映射xml到城市City
 * @author smart-dxw
 *
 */
@XmlRootElement(name="d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	@XmlAttribute(name="d1")
	private String cityId;
	
	@XmlAttribute(name="d1")
	private String cityName;
	
	@XmlAttribute(name="d1")
	private String cityCode;
	
	@XmlAttribute(name="d1")
	private String province;
	
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}

}
