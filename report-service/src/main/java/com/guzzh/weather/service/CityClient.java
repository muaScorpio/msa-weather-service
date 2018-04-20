package com.guzzh.weather.service;

import com.guzzh.weather.bean.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @param
 * @Author: zz
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@FeignClient("city-server")
public interface CityClient {
    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
