package com.napier.sem;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountriesLargeToSmall {

    public CountriesData getCountriesLargeToSmallInWorld(Connection con)
    {
        try{
            //create an SQL statement
            Statement stmt = con.createStatement();
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
                country.name = rset.getNString("Name");
                country.population = rset.getInt("population");
                System.out.println(country.toString("name, population"));
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

    public CountriesData getCountriesLargeToSmallInContinent(Connection con)
    {
        try{
            //create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT `Name`, `Population`, `Continent` " +
                            "FROM `country` " +
                            "GROUP BY `Name`, `Continent`, `Population` " +
                            "ORDER BY `Population` Desc";
            //execute statement
            ResultSet rset = stmt.executeQuery(strSelect);

            //Return country if valid
            //check one is returned
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
}
