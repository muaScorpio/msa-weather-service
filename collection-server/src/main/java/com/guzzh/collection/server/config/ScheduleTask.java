package com.guzzh.collection.server.config;

import com.guzzh.collection.server.bean.City;
import com.guzzh.collection.server.job.WeatherDataSyncJob;
import com.guzzh.collection.server.service.CityClient;
import com.guzzh.collection.server.service.WeatherDataCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gzz
 * @since 2018-4-20
 */
@Configuration
@Component
@EnableScheduling // 该注解必须要加
public class ScheduleTask {
    private final static Logger logger= LoggerFactory.getLogger(ScheduleTask.class);
    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private CityClient cityClient;
    public void scheduleTest() {
        logger.info("开始获取天气信息:已经注释，原因代理配置不方便，数据已经加载到了redis中");
        //获取城市列表
        List<City> cityList=null;
        try {
            cityList=cityClient.listCity();
        } catch (Exception e) {
            logger.error("Exception",e);
        }
        //遍历城市ID获取天气
        for (City  city : cityList){
            String cityId=city.getCityId();
            logger.info("获取城市id:"+cityId);
            weatherDataCollectionService.sysncDataByCityId(cityId);
        }
        logger.info("获取完毕！");
    }
}