package com.guzzh.weather.bean;

/**
 * @author gzz
 * @since 2018-4-12
 */
public class Forecast {
    /**
     * 风向
     */
    private String fengxiang;
    /**
     * 风力
     */
    private String fengli;
    /**
     * 最高温度
     */
    private String high;
    /**
     * 天气类型
     */
    private String type;
    /**
     * 最低温度
     */
    private String low;
    /**
     * 时间
     */
    private String date;

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Forecast() {
    }

    public Forecast(String fengxiang, String fengli, String high, String type, String low, String date) {
        this.fengxiang = fengxiang;
        this.fengli = fengli;
        this.high = high;
        this.type = type;
        this.low = low;
        this.date = date;
    }
}
