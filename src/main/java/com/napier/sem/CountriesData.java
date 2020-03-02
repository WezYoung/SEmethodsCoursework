package com.napier.sem;

public class CountriesData {

    private String code, name, continent, region, localName, governmentForm, headOfState, code2;
    private double surfaceArea, lifeExpectancy, gnp, gnpOld;
    private int indepYear, population, capital;

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

    public String getLocalName() {
        return localName;
    }
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }
    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }
    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCode2() {
        return code2;
    }
    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }
    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }
    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public double getGnp() {
        return gnp;
    }
    public void setGnp(double gnp) {
        this.gnp = gnp;
    }

    public double getGnpOld() {
        return gnpOld;
    }
    public void setGnpOld(double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public int getIndepYear() {
        return indepYear;
    }
    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
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
