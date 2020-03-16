package com.napier.sem;

public class Country {
    //Properties/Attributes
    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;
    private City capital;

    public Country(){};

    public Country(String name){
        this.name = name;
    }


    //Constructor
    public Country(String code, String name, String continent, String region, int population, City capital) {
        if (code.length() != 3){
            throw new IllegalArgumentException("Code must consist of 3 letters");
        }
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    public Country(String name, String continent, String region) {
        this.name = name;
        this.continent = continent;
        this.region = region;
    }

    public Country(String name, String continent){
        this.name = name;
        this.continent = continent;
    }


    //Getters and Setters
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

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }
}
