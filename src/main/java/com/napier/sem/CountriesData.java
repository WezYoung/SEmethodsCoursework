package com.napier.sem;

public class CountriesData {


    public String code;

    public String name;

    public String continent;

    public String region;

    public double surfaceArea;

    public int indepYear;

    public int population;

    public double lifeExpectancy;

    public double gnp;

    public double gnpOld;

    public String localName;

    public String governmentForm;

    public String headOfState;

    public int capital;

    public String code2;

    public String toString(){
        String data ="";
        data += name;
        data += ", ";
        data += population;

        return data;
    }

}
