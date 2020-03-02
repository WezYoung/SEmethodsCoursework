package com.napier.sem;

public class CitiesData {
/*
Class created by Wez Young(40402601). This class contains the getters and setters as well as
the toString methods for city related data, including id, name, country code, district
and population.
 */

    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    /*
    Getters and Setters for type declarations
     */

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCountryCode() {
        return countryCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    public String getDistrict() {
        return district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    public int getPopulation() {
        return population;
    }

    //Override .toString() to print data needed
    public String toString(String parameter){
        String data ="";
        //if statements to check what data is needed and to be appended on to string
        if(parameter.contains("name"))
        {
            data += name;
            data += ", ";
        }
        if(parameter.contains("population"))
        {
            data += population;
            data += ", ";
        }
        return data;
    }
}
