package com.guzzh.collection.server.service;

/**
 * @Author: zz
 * @Description: Weather Data Collection Service
 * @Date: Created in 11:02 2017/12/8
 */
public interface WeatherDataCollectionService {
    /**
     * 根据城市id同步天气
     *@author zz
     *@date 2018-4-17 15:46
     *@param cityId
     *@return void
     */
    void sysncDataByCityId(String cityId);
}
