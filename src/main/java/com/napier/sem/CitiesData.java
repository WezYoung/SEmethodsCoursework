package com.napier.sem;

public class CitiesData {


    private int id;
    private String name;
    private String district;
    private int population;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
