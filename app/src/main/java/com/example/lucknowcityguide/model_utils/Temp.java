package com.example.lucknowcityguide.model_utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Temp implements Serializable
{
    @SerializedName("day")
    @Expose
    private float day;
    @SerializedName("min")
    @Expose
    private float min;
    @SerializedName("max")
    @Expose
    private float max;
    @SerializedName("night")
    @Expose
    private float night;
    @SerializedName("eve")
    @Expose
    private float eve;
    @SerializedName("morn")
    @Expose
    private float morn;
    private final static long serialVersionUID = -2817929506717711950L;

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public Temp withDay(float day) {
        this.day = day;
        return this;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public Temp withMin(float min) {
        this.min = min;
        return this;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public Temp withMax(float max) {
        this.max = max;
        return this;
    }

    public float getNight() {
        return night;
    }

    public void setNight(float night) {
        this.night = night;
    }

    public Temp withNight(float night) {
        this.night = night;
        return this;
    }

    public float getEve() {
        return eve;
    }

    public void setEve(float eve) {
        this.eve = eve;
    }

    public Temp withEve(float eve) {
        this.eve = eve;
        return this;
    }

    public float getMorn() {
        return morn;
    }

    public void setMorn(float morn) {
        this.morn = morn;
    }

    public Temp withMorn(float morn) {
        this.morn = morn;
        return this;
    }

}
