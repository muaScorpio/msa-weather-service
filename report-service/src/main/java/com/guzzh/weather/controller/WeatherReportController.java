package com.guzzh.weather.controller;

import com.guzzh.weather.bean.City;
import com.guzzh.weather.service.CityClient;
import com.guzzh.weather.service.WeatherReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用thymeleaf 控制层
 * @author gzz
 * @since 2018-4-16
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
    private final static Logger logger= LoggerFactory.getLogger(WeatherReportController.class);
    @Autowired
    private WeatherReportService weatherReportService;
    @Autowired
    private CityClient cityClient;
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId,Model model) throws Exception {
        //获取城市ID列表
        List<City> cityList = null;
        try {
            //由城市数据API微服务提供数据
            cityList = cityClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }
        logger.info("WeatherReportController");
        model.addAttribute("title","GuzzhWeather");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityList);
        model.addAttribute("report",weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report","reportModel",model);
    }
}
