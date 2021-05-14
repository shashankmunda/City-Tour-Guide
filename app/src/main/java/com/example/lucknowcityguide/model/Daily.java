package com.example.lucknowcityguide.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Daily implements Serializable
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
    @SerializedName("moonrise")
    @Expose
    private int moonrise;
    @SerializedName("moonset")
    @Expose
    private int moonset;
    @SerializedName("moon_phase")
    @Expose
    private float moonPhase;
    @SerializedName("temp")
    @Expose
    private Temp temp;
    @SerializedName("feels_like")
    @Expose
    private FeelsLike feelsLike;
    @SerializedName("pressure")
    @Expose
    private int pressure;
    @SerializedName("humidity")
    @Expose
    private int humidity;
    @SerializedName("dew_point")
    @Expose
    private float dewPoint;
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
    private List<Weather__1> weather = null;
    @SerializedName("clouds")
    @Expose
    private int clouds;
    @SerializedName("pop")
    @Expose
    private int pop;
    @SerializedName("uvi")
    @Expose
    private double uvi;
    @SerializedName("rain")
    @Expose
    private float rain;
    private final static long serialVersionUID = -191273545997979079L;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Daily withDt(int dt) {
        this.dt = dt;
        return this;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public Daily withSunrise(int sunrise) {
        this.sunrise = sunrise;
        return this;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public Daily withSunset(int sunset) {
        this.sunset = sunset;
        return this;
    }

    public int getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(int moonrise) {
        this.moonrise = moonrise;
    }

    public Daily withMoonrise(int moonrise) {
        this.moonrise = moonrise;
        return this;
    }

    public int getMoonset() {
        return moonset;
    }

    public void setMoonset(int moonset) {
        this.moonset = moonset;
    }

    public Daily withMoonset(int moonset) {
        this.moonset = moonset;
        return this;
    }

    public float getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(float moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Daily withMoonPhase(float moonPhase) {
        this.moonPhase = moonPhase;
        return this;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public Daily withTemp(Temp temp) {
        this.temp = temp;
        return this;
    }

    public FeelsLike getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Daily withFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
        return this;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public Daily withPressure(int pressure) {
        this.pressure = pressure;
        return this;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public Daily withHumidity(int humidity) {
        this.humidity = humidity;
        return this;
    }

    public float getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Daily withDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
        return this;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Daily withWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
        return this;
    }

    public int getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(int windDeg) {
        this.windDeg = windDeg;
    }

    public Daily withWindDeg(int windDeg) {
        this.windDeg = windDeg;
        return this;
    }

    public float getWindGust() {
        return windGust;
    }

    public void setWindGust(float windGust) {
        this.windGust = windGust;
    }

    public Daily withWindGust(float windGust) {
        this.windGust = windGust;
        return this;
    }

    public List<Weather__1> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather__1> weather) {
        this.weather = weather;
    }

    public Daily withWeather(List<Weather__1> weather) {
        this.weather = weather;
        return this;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public Daily withClouds(int clouds) {
        this.clouds = clouds;
        return this;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public Daily withPop(int pop) {
        this.pop = pop;
        return this;
    }

    public double getUvi() {
        return uvi;
    }

    public void setUvi(double uvi) {
        this.uvi = uvi;
    }

    public Daily withUvi(double uvi) {
        this.uvi = uvi;
        return this;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    public Daily withRain(float rain) {
        this.rain = rain;
        return this;
    }

}
