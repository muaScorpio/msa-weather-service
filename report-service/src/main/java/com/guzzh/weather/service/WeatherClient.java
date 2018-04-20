package com.guzzh.weather.service;

import com.guzzh.weather.bean.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @param
 * @Author: zz
 * @Description:
 * @Date: 2018年4月20日12:18:28
 */
@FeignClient("data-server")
public interface WeatherClient {
    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
