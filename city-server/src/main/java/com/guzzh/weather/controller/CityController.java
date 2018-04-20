package com.guzzh.weather.controller;

import com.guzzh.weather.bean.City;
import com.guzzh.weather.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gzz
 * @since 2018-4-17
 */
@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityDataService cityDataService;
    @GetMapping
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
