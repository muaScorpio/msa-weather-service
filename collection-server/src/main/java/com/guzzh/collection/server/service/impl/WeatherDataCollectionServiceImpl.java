package com.guzzh.collection.server.service.impl;

import com.guzzh.collection.server.service.WeatherDataCollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author gzz
 * @since 2018-4-17
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {
    private final static Logger logger= LoggerFactory.getLogger(WeatherDataCollectionService.class);
    private static final String WEATHER_URL="http://wthrcdn.etouch.cn/weather_mini?";
    private static final Long TIME_OYT=60l*60l*12l;//一天

    @Autowired
    private RestTemplate restTemplate;
    /**
     * 使用Redis实现获取天气
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void sysncDataByCityId(String cityId) {
        String url=WEATHER_URL+"citykey="+cityId;
        this.saveWeatherData(url);
    }
    private void saveWeatherData(String url){
        logger.info("开始执行查询天气");
        String key=url;
        String strBody=null;
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        //缓存没有，在调用服务端获取数据
        ResponseEntity<String> rsponseEntity = restTemplate.getForEntity(url,String.class);

        //响应成功
        if(rsponseEntity.getStatusCodeValue()==200){
            strBody=rsponseEntity.getBody();
        }
        //写入缓存
        ops.set(key,strBody,TIME_OYT, TimeUnit.SECONDS);
    }
}
