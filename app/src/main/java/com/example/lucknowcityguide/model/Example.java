

package com.example.lucknowcityguide.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Example implements Serializable
{
    @SerializedName("lat")
    @Expose
    private float lat;
    @SerializedName("lon")
    @Expose
    private float lon;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("timezone_offset")
    @Expose
    private int timezoneOffset;
    @SerializedName("current")
    @Expose
    private Current current;
    @SerializedName("daily")
    @Expose
    private List<Daily> daily = null;
    private final static long serialVersionUID = 2656410007005307925L;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public Example withLat(float lat) {
        this.lat = lat;
        return this;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public Example withLon(float lon) {
        this.lon = lon;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Example withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public Example withTimezoneOffset(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
        return this;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Example withCurrent(Current current) {
        this.current = current;
        return this;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public Example withDaily(List<Daily> daily) {
        this.daily = daily;
        return this;
    }

}