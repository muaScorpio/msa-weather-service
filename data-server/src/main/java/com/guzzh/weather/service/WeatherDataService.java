package com.guzzh.weather.service;


import com.guzzh.weather.bean.WeatherResponse;

/**
 * @param
 * @Author: zz
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public interface WeatherDataService {
    /**
     * 根据城市ID获取天气
     *@author zz
     *@date 2018-4-12 16:02
     *@param cityId 城市ID
     *@return com.mua.weather.bean.WeatherResponse
     */
    public WeatherResponse getDataByCityId(String cityId);
    /**
     * 根据城市名称获取天气
     *@author zz
     *@date 2018-4-12 16:04
     *@param cityName 城市名称
     *@return com.mua.weather.bean.WeatherResponse
     */
    public WeatherResponse getDataByCityName(String cityName);
}
