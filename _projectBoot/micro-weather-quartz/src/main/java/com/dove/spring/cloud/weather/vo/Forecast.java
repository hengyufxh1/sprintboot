package com.dove.spring.cloud.weather.vo;

import java.io.Serializable;

/**
 * 未来天气
 * @author smart-dxw
 * 
 * 
 * 
 *       {
        "date": "12日星期四",
        "high": "高温 31℃",
        "fengli": "<![CDATA[<3级]]>",
        "low": "低温 16℃",
        "fengxiang": "东风",
        "type": "小雨"
      }
 */
  
public class Forecast implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date;
	private String high;		// 温度
	private String fengli;		// 风力
	private String low;			// 温度
	private String fengxiang;  // 风向
	private String type;
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
	public String getFengli() {
		return fengli;
	}
	public void setFengli(String fengli) {
		this.fengli = fengli;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getFengxiang() {
		return fengxiang;
	}
	public void setFengxiang(String fengxiang) {
		this.fengxiang = fengxiang;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
