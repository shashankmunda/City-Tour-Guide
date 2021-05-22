package com.example.lucknowcityguide.model_utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class FeelsLike implements Serializable
{
    @SerializedName("day")
    @Expose
    private float day;
    @SerializedName("night")
    @Expose
    private float night;
    @SerializedName("eve")
    @Expose
    private float eve;
    @SerializedName("morn")
    @Expose
    private float morn;
    private final static long serialVersionUID = 6623051032415490305L;

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public FeelsLike withDay(float day) {
        this.day = day;
        return this;
    }

    public float getNight() {
        return night;
    }

    public void setNight(float night) {
        this.night = night;
    }

    public FeelsLike withNight(float night) {
        this.night = night;
        return this;
    }

    public float getEve() {
        return eve;
    }

    public void setEve(float eve) {
        this.eve = eve;
    }

    public FeelsLike withEve(float eve) {
        this.eve = eve;
        return this;
    }

    public float getMorn() {
        return morn;
    }

    public void setMorn(float morn) {
        this.morn = morn;
    }

    public FeelsLike withMorn(float morn) {
        this.morn = morn;
        return this;
    }

}
