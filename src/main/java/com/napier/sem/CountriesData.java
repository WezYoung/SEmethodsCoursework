package com.napier.sem;

public class CountriesData {

    //Country code
    public String code;
    //Country name
    public String name;
    //Continent name
    public String continent;
    //Region name
    public String region;
    //Surface area of country
    public double surfaceArea;
    //Year of independence
    public int indepYear;
    //Population of country
    public int population;
    //Life expectancy of country
    public double lifeExpectancy;
    //Gross National Population
    public double gnp;
    //Older Gross National Populations
    public double gnpOld;
    //Local name of country
    public String localName;

    public String governmentForm;
    //The head of state of country
    public String headOfState;
    //Capital of country
    public int capital;
    //Second country code
    public String code2;

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
