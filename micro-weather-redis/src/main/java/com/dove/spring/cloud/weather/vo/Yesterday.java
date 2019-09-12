package com.dove.spring.cloud.weather.vo;

import java.io.Serializable;

/**
 * 昨日天气
 * @author smart-dxw
 *
 *
 *    "yesterday": {
      "date": "11日星期三",
      "high": "高温 26℃",
      "fx": "东北风",
      "low": "低温 20℃",
      "fl": "<![CDATA[3-4级]]>",
      "type": "小雨"
    }
 *
 */
public class Yesterday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String yesterday;
	private String date;
	private String high;
	private String fx;
	private String low;
	private String fl;
	private String type;
	public String getYesterday() {
		return yesterday;
	}
	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
