package com.guzzh.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guzzh.weather.bean.WeatherResponse;
import com.guzzh.weather.service.WeatherDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * @author gzz
 * @since 2018-4-12
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger logger= LoggerFactory.getLogger(WeatherDataService.class);
    private static final String WEATHER_URL="http://wthrcdn.etouch.cn/weather_mini?";

    /**
     * 使用Redis实现获取天气
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

//    @Autowired
//    private RedisUtil redisUtil;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url=WEATHER_URL+"citykey="+cityId;
        return this.doGetWeather(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url=WEATHER_URL+"city="+cityName;
        return this.doGetWeather(url);
    }

    private WeatherResponse doGetWeather(String url){
        String key =url;
        WeatherResponse weatherResponse=null;
        String strBody="";
        ObjectMapper objectMapper =new ObjectMapper();
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        //先查缓存，缓存有的取缓存的数据
        if(stringRedisTemplate.hasKey(key)){
            strBody=ops.get(key);
            logger.info("获取Redis数据");
        }else {
            //缓存没有，在调用服务端获取数据
            logger.info("Redis中没有数据");
            //抛出异常
            throw new RuntimeException("Redis中没有数据！");
        }
        try {
            System.out.println(strBody);
            weatherResponse= objectMapper.readValue(strBody,WeatherResponse.class);
        } catch (Exception e) {
            logger.error("ERRORE",e);
        }
        return weatherResponse;
    }
}
