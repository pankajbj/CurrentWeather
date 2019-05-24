package com.example.pankaj.currentweather.Model;

import com.google.gson.annotations.SerializedName;

public class MyModel {

    @SerializedName("location")
    Localtion localtion;
    @SerializedName("current")
    Current current;

    public Localtion getLocaltion() {
        return localtion;
    }

    public void setLocaltion(Localtion localtion) {
        this.localtion = localtion;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }




   public class Localtion {
     @SerializedName("name")
        String name;
     @SerializedName("region")
        String region;
     @SerializedName("country")
        String country;
     @SerializedName("localtime")
        String localtime;
     @SerializedName("lat")
        String lat;
     @SerializedName("lon")
        String lon;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLocaltime() {
            return localtime;
        }

        public void setLocaltime(String localtime) {
            this.localtime = localtime;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }
    }

     public class Current {
    @SerializedName("last_updated")
        String last_updated;
    @SerializedName("temp_c")
        String temp_c;
    @SerializedName("condition")
        Conditn conditn;
    @SerializedName("humidity")
    String humidity;
    @SerializedName("wind_degree")
    String wind_degree;

         public String getWind_degree() {
             return wind_degree;
         }

         public void setWind_degree(String wind_degree) {
             this.wind_degree = wind_degree;
         }

         public String getHumidity() {
             return humidity;
         }

         public void setHumidity(String humidity) {
             this.humidity = humidity;
         }

         public String getLast_updated() {
            return last_updated;
        }

        public void setLast_updated(String last_updated) {
            this.last_updated = last_updated;
        }

        public String getTemp_c() {
            return temp_c;
        }

        public void setTemp_c(String temp_c) {
            this.temp_c = temp_c;
        }

        public Conditn getConditn() {
            return conditn;
        }

        public void setConditn(Conditn conditn) {
            this.conditn = conditn;
        }

        public class Conditn{
     @SerializedName("text")
          String text;
     @SerializedName("icon")
          String icon;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

    }
}
