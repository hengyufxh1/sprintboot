package com.dove.spring.cloud.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dove.spring.cloud.weather.service.CityDataService;
import com.dove.spring.cloud.weather.service.WeatherReportService;

/**
 * Weather Report Controller
 * @author smart-dxw
 *
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	
	@Autowired
	private CityDataService cityDataService;
	
	@Autowired
	private WeatherReportService weatherReportService;

	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception{
		
		model.addAttribute("title","天气预报");
		model.addAttribute("cityId",cityId);
		model.addAttribute("cityList", cityDataService.listCity());
		
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		System.out.println("ok1");
		return new ModelAndView("weather/report","reportModel", model);
	}
	
}
