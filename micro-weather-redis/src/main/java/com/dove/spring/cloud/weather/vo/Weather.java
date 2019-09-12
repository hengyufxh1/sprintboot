package com.dove.spring.cloud.weather.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息
 * http://wthrcdn.etouch.cn/weather_mini?city=西安
 * @author smart-dxw
 *
 */
public class Weather implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;// 城市
	private String ganmao; // 感冒提示
	private String wendu; //温度
	private Yesterday yesterday;
	private List<Forecast> forecast;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGanmao() {
		return ganmao;
	}
	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}
	public String getWendu() {
		return wendu;
	}
	public void setWendu(String wendu) {
		this.wendu = wendu;
	}
	public Yesterday getYesterday() {
		return yesterday;
	}
	public void setYesterday(Yesterday yesterday) {
		this.yesterday = yesterday;
	}
	public List<Forecast> getForecast() {
		return forecast;
	}
	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}

	
}