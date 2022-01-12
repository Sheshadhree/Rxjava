package com.example.rxjava.gson;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("city")
      String city;
    @SerializedName("country")
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}
