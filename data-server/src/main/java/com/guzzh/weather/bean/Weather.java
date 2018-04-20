package com.guzzh.weather.bean;

import java.util.List;

/**
 * @author gzz
 * @since 2018-4-12
 */
public class Weather {
    /**
     * 温度
     */
    private String wendu;
    /**
     * 感冒提示
     */
    private String ganmao;
    /**
     * 空气质量指数
     */
    private String aqi;
    /**
     * 城市
     */
    private String city;
    /**
     * 昨天情况
     */
    private  Yesterday yesterday;
    /**
     * 未来预测
     */
    private List<Forecast> forecast;

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu+"℃";
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
