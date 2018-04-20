package com.guzzh.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: zz
 * @Description: City Client
 * @Date: Created in 11:02 2017/12/8
 */
@FeignClient("city-server")//微服务的名称
public interface CityClient {
    @GetMapping("/cities")//微服务中访问的方法或者类
    String listCity();
}
