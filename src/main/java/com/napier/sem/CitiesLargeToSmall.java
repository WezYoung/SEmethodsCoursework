package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
Class was created by Wez Young(40402601). This class contains SQL statements for
cities from large to small based on population in the world, in continents, in countries,
in regions and in districts. 
 */
public class CitiesLargeToSmall {

    public CitiesData getCitiesLargeToSmallInWorld(Connection con)
    {
        try{
            //create an SQL statement
            Statement stmt = con.createStatement();
            //Create string for SQL statement
            String strSelect =
                    "SELECT `Name`, `Population`" +
                            " FROM `city`" +
                            " ORDER BY `Population` Desc";
            //execute statement
            ResultSet rset = stmt.executeQuery(strSelect);

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

    public CitiesData getCitiesLargeToSmallInContinent(Connection con)
    {
        return null;
    }

    public CitiesData getCitiesLargeToSmallInRegion(Connection con)
    {
        return null;
    }

    public CitiesData getCitiesLargeToSmallInCountry(Connection con)
    {
        return null;
    }

    public CitiesData getCitiesLargeToSmallInDistrict(Connection con)
    {
        return null;
    }
}
