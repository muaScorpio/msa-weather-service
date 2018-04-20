package com.guzzh.weather.service.impl;

import com.guzzh.weather.bean.City;
import com.guzzh.weather.bean.CityList;
import com.guzzh.weather.service.CityDataService;
import com.guzzh.weather.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author gzz
 * @since 2018-4-16
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        //读取XML文件
        Resource resource= (Resource) new ClassPathResource("citylist.xml");
        BufferedReader br=new BufferedReader(new InputStreamReader(resource.getInputStream()));
        StringBuffer buffer =new StringBuffer();
        String line="";
        while ((line=br.readLine())!=null){
            buffer.append(line);
        }
        //xml转为java对象
        CityList cityList= (CityList) XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
        return cityList.getCityList();
    }
}
