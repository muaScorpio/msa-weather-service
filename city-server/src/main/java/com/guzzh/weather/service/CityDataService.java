package com.guzzh.weather.service;


import com.guzzh.weather.bean.City;

import java.util.List;

/**
 * city data Service
 * @author gzz
 * @since 2018-4-16
 */
public interface CityDataService {
    /**
     * 获取城市列表
     *@author zz
     *@date 2018-4-16 10:57
     *@return java.util.List<com.mua.weather.bean.City>
     */
    List<City> listCity() throws Exception;
}
