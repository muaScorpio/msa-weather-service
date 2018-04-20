package com.guzzh.weather.service.impl;

import com.guzzh.weather.bean.Forecast;
import com.guzzh.weather.bean.Weather;
import com.guzzh.weather.bean.WeatherResponse;
import com.guzzh.weather.service.WeatherClient;
import com.guzzh.weather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gzz
 * @since 2018-4-16
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
    @Autowired
    private WeatherClient weatherClient;
    @Override
    public Weather getDataByCityId(String cityId) {
        //TODO 改为有天气数据API微服务提供该数据
        WeatherResponse resp = weatherClient.getDataByCityId(cityId);
        Weather data = resp.getData();
        return data;
    }
}
