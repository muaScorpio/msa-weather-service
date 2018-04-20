package com.guzzh.weather.service;


import com.guzzh.weather.bean.Weather;

/**
 * @param
 * @Author: zz
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public interface WeatherReportService {
    Weather getDataByCityId(String cityId);
}