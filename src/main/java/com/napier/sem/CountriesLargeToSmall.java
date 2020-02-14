package com.napier.sem;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountriesLargeToSmall {

    //Gets and sorts populations of countries in the world from largest to smallest
    public CountriesData getCountriesLargeToSmallInWorld(Connection con)
    {
        try{
            //create an SQL statement
            Statement stmt = con.createStatement();
            //Create string for SQL statement
            String strSelect =
                    "SELECT `Name`, `Population` " +
                    "FROM `country` " +
                    "ORDER BY `Population` Desc";
            //execute statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //List<CountriesData> countryList = new ArrayList<>();

            //Return country if valid
            //check one is returned
            while(rset.next())
            {
                CountriesData country = new CountriesData();
                //Result set gets name and population data
                country.name = rset.getNString("Name");
                country.population = rset.getInt("population");
                //Puts data into one string to be displayed
                System.out.println(country.toString("name, population"));
            }

        }
        catch(Exception e)
        {
            //error message displays if unable to get country data
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
        return null;
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
                country.continent = rset.getNString("continent");
                country.name = rset.getNString("name");
                country.population = rset.getInt("population");
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
                country.region = rset.getNString("region");
                country.name = rset.getNString("name");
                country.population = rset.getInt("population");
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
