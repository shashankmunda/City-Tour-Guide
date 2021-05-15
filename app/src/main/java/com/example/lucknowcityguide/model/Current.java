package com.example.lucknowcityguide.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Current implements Serializable
{
    @SerializedName("dt")
    @Expose
    private int dt;
    @SerializedName("sunrise")
    @Expose
    private int sunrise;
    @SerializedName("sunset")
    @Expose
    private int sunset;
    @SerializedName("temp")
    @Expose
    private float temp;
    @SerializedName("feels_like")
    @Expose
    private float feelsLike;
    @SerializedName("pressure")
    @Expose
    private int pressure;
    @SerializedName("humidity")
    @Expose
    private int humidity;
    @SerializedName("dew_point")
    @Expose
    private float dewPoint;
    @SerializedName("uvi")
    @Expose
    private double uvi;
    @SerializedName("clouds")
    @Expose
    private int clouds;
    @SerializedName("visibility")
    @Expose
    private int visibility;
    @SerializedName("wind_speed")
    @Expose
    private float windSpeed;
    @SerializedName("wind_deg")
    @Expose
    private int windDeg;
    @SerializedName("wind_gust")
    @Expose
    private float windGust;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    private final static long serialVersionUID = -6464886062148331635L;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Current withDt(int dt) {
        this.dt = dt;
        return this;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public Current withSunrise(int sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public Current withSunset(int sunset) {
        this.sunset = sunset;
        return this;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public Current withTemp(float temp) {
        this.temp = temp;
        return this;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Current withFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
        return this;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public Current withPressure(int pressure) {
        this.pressure = pressure;
        return this;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Current withHumidity(int humidity) {
        this.humidity = humidity;
        return this;
    }

    public float getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Current withDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
        return this;
    }

    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    public Current withUvi(double uvi) {
        this.uvi = uvi;
        return this;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public Current withClouds(int clouds) {
        this.clouds = clouds;
        return this;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Current withVisibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Current withWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }

    public Current withWindDeg(int windDeg) {
        this.windDeg = windDeg;
        return this;
    }

    public float getWindGust() {
        return windGust;
    }

    public void setWindGust(float windGust) {
        this.windGust = windGust;
    }

    public Current withWindGust(float windGust) {
        this.windGust = windGust;
        return this;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Current withWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }

}
