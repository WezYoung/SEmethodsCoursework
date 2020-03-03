package com.napier.sem;

public class City {
    //Properties/Attributes
    private String name;
    private Country country;
    private String district;
    private int population;


    //Constructors
    public City(String name, Country country, String district, int population) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    //Constructor for just name
    //  ie. for when no city data is needed for a report
    public City(String name) {
        this.name = name;
        this.country = null;
        this.district = "";
        this.population = -1;
    }


    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}
