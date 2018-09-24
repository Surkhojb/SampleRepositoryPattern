package com.example.surkhojb.samplerepositorypattern.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 24/9/18.
 */

public class User {

    @SerializedName("id")
    @Expose
    private int userId;

    @SerializedName("name")
    @Expose
    private String userName;

    @SerializedName("username")
    @Expose
    private String userNickname;

    @SerializedName("email")
    @Expose
    private String userEmail;

    @SerializedName("address")
    @Expose
    private Address catchPhrase;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("website")
    @Expose
    private String webSite;

    @SerializedName("company")
    @Expose
    private Company company;

}

class Address {

    @SerializedName("street")
    @Expose
    private String street;

    @SerializedName("suite")
    @Expose
    private String suite;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("zipcode")
    @Expose
    private String zipCode;

    @SerializedName("geo")
    @Expose
    private Geo geo;


}

class Geo {
    @SerializedName("lat")
    @Expose
    private String latitude;

    @SerializedName("lng")
    @Expose
    private String longitude;
}

class Company {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("catchPhrase")
    @Expose
    private String catchPhrase;

    @SerializedName("bs")
    @Expose
    private String bs;

}
