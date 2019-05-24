package com.example.pankaj.currentweather.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user")
public class User {
   @NonNull
    @PrimaryKey
    private String uid;

   @NonNull
   @ColumnInfo(name = "Temp")
   private String temp;


    @NonNull
    @ColumnInfo(name = "LastUpdated")
    private String lastupdated;


    @NonNull
    @ColumnInfo(name = "condition")
    private String condition;

    @NonNull
    @ColumnInfo(name = "humidity")
    private String humidity;

    @NonNull
    @ColumnInfo(name = "Wind degree")
    private String wind;

    @NonNull
@ColumnInfo(name = "name")
private String name;

@NonNull
@ColumnInfo(name = "country")
    private String country;

@NonNull
@ColumnInfo(name = "region")
    private String region;

public User(String uid,String temp,String lastupdated,String condition,String humidity,String wind,String name,String country,String region ){
    this.uid=uid;
    this.temp=temp;
    this.lastupdated=lastupdated;
    this.condition=condition;
    this.humidity=humidity;
    this.wind=wind;
    this.name=name;
    this.country=country;
    this.region=region;
}


    public String getUid() {
        return uid;
    }


    public void setUid(String uid) {
        this.uid = uid;
    }

    @NonNull
    public String getTemp() {
        return temp;
    }

    public void setTemp(@NonNull String temp) {
        this.temp = temp;
    }

    @NonNull
    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(@NonNull String lastupdated) {
        this.lastupdated = lastupdated;
    }

    @NonNull
    public String getCondition() {
        return condition;
    }

    public void setCondition(@NonNull String condition) {
        this.condition = condition;
    }

    @NonNull
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(@NonNull String humidity) {
        this.humidity = humidity;
    }

    @NonNull
    public String getWind() {
        return wind;
    }

    public void setWind(@NonNull String wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
