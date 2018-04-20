package com.guzzh.weather.bean;

/**
 * @author gzz
 * @since 2018-4-12
 */
public class Yesterday {
    /**
     *风力
     */
    private String  fl;
    /**
     *风向
     */
    private String  fx;
    /**
     *最高温度
     */
    private String  high;
    /**
     *天气类型
     */
    private String  type;
    /**
     *最低温度
     */
    private String  low;
    /**
     *时间
     */
    private String  date;

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
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
}
