package com.napier.sem;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/*
Class created and maintained by Wez Young(40402601) and Lewis Kaye(40397385).
This class contains SQL statements sorting populations of countries in the world from largest to smallest.
Sorts populations of countries in continents from
largest to smallest and sorts populations in regions of countries from largest to smallest.
 */
public class CountriesLargeToSmall {

    //Gets and sorts populations of countries in the world from largest to smallest
    public List<Country> getCountriesLargeToSmallInWorld(Connection con)
    {
        try{
            //Create SQL Statement
            Statement stmt = con.createStatement();

            //Create string for SQL statement
            String strQuery =
                    "SELECT `Code`, `Name`, `Continent`, `Region`, `Population`, `Capital`" +
                    "FROM `country` " +
                    "ORDER BY `Population` Desc";


            //Execute Query, store results in a ResultSet
            ResultSet rset = stmt.executeQuery(strQuery);

            //Create list to store countries in
            List<Country> countryList = new ArrayList<>();

            //Go through all valid results, adding to Objects [Country, City etc.]
            while(rset.next())
            {
                //Get Each Property of the country
                String code = rset.getNString("Code");
                String name = rset.getNString("Name");
                String continent = rset.getNString("Continent");
                String region = rset.getNString("Region");
                int population = rset.getInt("Population");
                //int population = Convert(rset.getNString("Population"));

                //Create City - just name as no city data needed for this report
                City capital = new City(rset.getNString("Capital"));

                //Create Country Object
                Country country = new Country(code, name, continent, region, population, capital);

                //Add Country to list
                countryList.add(country);
            }

            //Return List
            return countryList;
        }
        catch(Exception e)
        {
            //error message displays if unable to get country data
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //Gets and sorts populations of countries in continents from largest to smallest
    public CountriesData getCountriesLargeToSmallInContinent(Connection con)
    {
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT `Name`, `Population`, `Continent` " +
                            "FROM `country` " +
                            "GROUP BY `Name`, `Continent`, `Population` " +
                            "ORDER BY `Population` Desc";

            ResultSet rset = stmt.executeQuery(strSelect);

            while(rset.next())
            {
                CountriesData country = new CountriesData();
                country.setContinent(rset.getNString("continent"));
                country.setName(rset.getNString("name"));
                country.setPopulation( rset.getInt("population"));
                System.out.println(country.toString("continent, name, population"));
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
        return null;
    }

    //Gets and sorts populations of countries in regions from largest to smallest
    public CountriesData getCountriesLargeToSmallInRegion(Connection con)
    {
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT `Name`, `Population`, `Region` " +
                            "FROM `country` " +
                            "GROUP BY `Name`, `Region`, `Population` " +
                            "ORDER BY `Population` Desc";
            ResultSet rset = stmt.executeQuery(strSelect);

            while(rset.next())
            {
                CountriesData country = new CountriesData();
                country.setRegion(rset.getNString("region"));
                country.setName(rset.getNString("name"));
                country.setPopulation(rset.getInt("population"));
                System.out.println(country.toString("region, name, population"));
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
        return null;
    }
}
