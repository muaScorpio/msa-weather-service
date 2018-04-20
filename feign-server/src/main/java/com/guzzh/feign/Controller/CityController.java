package com.guzzh.feign.Controller;

import com.guzzh.feign.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gzz
 * @since 2018-4-19
 */
@RestController
public class CityController {
    @Autowired
    private CityClient cityClient;
    @GetMapping("/cities")//这个名字可以任意取
    public String listCity(){
        //通过Feign客户端来查找
        String body =cityClient.listCity();
        return body;
    }
}
