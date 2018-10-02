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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Address getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(Address catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}

class Geo {
    @SerializedName("lat")
    @Expose
    private String latitude;

    @SerializedName("lng")
    @Expose
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
