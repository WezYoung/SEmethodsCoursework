package com.napier.sem;

public class CountriesData {

    private String code, name, continent, region;
    private int population, capital;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }

    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCapital() {
        return capital;
    }
    public void setCapital(int capital) {
        this.capital = capital;
    }

    //Override .toString() to print data needed
    public String toString(String parameter){
        String data ="";
        //if statements to check what data is needed and to be appended on to string
        if(parameter.contains("region"))
        {
            data += region;
            data += ", ";
        }
        if(parameter.contains("continent")) {
            data += continent;
            data += ", ";
        }
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
