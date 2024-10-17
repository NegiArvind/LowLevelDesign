package models;

import enums.City;

public class Address {
    private City city;
    private String state;
    private String country;

    public Address(City city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
