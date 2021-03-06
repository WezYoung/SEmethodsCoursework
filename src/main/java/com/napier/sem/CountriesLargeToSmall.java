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
                    "SELECT co.`Code`, co.`Name`, co.`Continent`, co.`Region`, co.`Population`, ci.`Name` AS 'Capital'" +
                    "FROM `Country` co " +
                    "JOIN `City` ci ON ci.`ID` = co.`Capital`" +
                    "ORDER BY `Population` Desc";


            //Execute Query, store results in a ResultSet
            ResultSet rset = stmt.executeQuery(strQuery);

            //Create list to store countries in
            List<Country> countryList = new ArrayList<>();

            //Go through all valid results, adding to Objects [Country, City etc.]
            while(rset.next())
            {
                //Get Each Property of the country
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                //Create City - just name as no city data needed for this report
                City capital = new City(rset.getString("Capital"));

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
    public List<Country> getCountriesLargeToSmallInContinent(Connection con, String continent)
    {
        try{
            //Create SQL Statement
            Statement stmt = con.createStatement();
//TODO Need to modify JOIN
            //Create string for SQL statement
            String strQuery =
                    "SELECT co.`Code`, co.`Name`, co.`Continent`, co.`Region`, co.`Population`, ci.`Name` AS 'Capital'" +
                            "FROM `Country` co " +
                            "JOIN `City` ci ON ci.`ID` = co.`Capital`" +
                            "WHERE co.`Continent` = '" + continent + "'" +
                            "GROUP BY co.`Code`"+
                            "ORDER BY `Population` Desc";


            //Execute Query, store results in a ResultSet
            ResultSet rset = stmt.executeQuery(strQuery);

            //Create list to store countries in
            List<Country> countryList = new ArrayList<>();

            //Go through all valid results, adding to Objects [Country, City etc.]
            while(rset.next())
            {
                //Get Each Property of the country
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String cont = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                //Create City - just name as no city data needed for this report
                City capital = new City(rset.getString("Capital"));

                //Create Country Object
                Country country = new Country(code, name, cont, region, population, capital);

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


    //Gets and sorts populations of countries in regions from largest to smallest
    public List<Country> getCountriesLargeToSmallInRegion(Connection con, String region)
    {
        try{
            //Create SQL Statement
            Statement stmt = con.createStatement();

            //Create string for SQL statement
            String strQuery =
                    "SELECT co.`Code`, co.`Name`, co.`Continent`, co.`Region`, co.`Population`, ci.`Name` AS 'Capital'" +
                            "FROM `Country` co " +
                            "JOIN `City` ci ON ci.`ID` = co.`Capital`" +
                            "WHERE co.`Region` = '" + region + "'" +
                            "GROUP BY co.`Code`"+
                            "ORDER BY `Population` Desc";


            //Execute Query, store results in a ResultSet
            ResultSet rset = stmt.executeQuery(strQuery);

            //Create list to store countries in
            List<Country> countryList = new ArrayList<>();

            //Go through all valid results, adding to Objects [Country, City etc.]
            while(rset.next())
            {
                //Get Each Property of the country
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String reg = rset.getString("Region");
                int population = rset.getInt("Population");

                //Create City - just name as no city data needed for this report
                City capital = new City(rset.getString("Capital"));

                //Create Country Object
                Country country = new Country(code, name, continent, reg, population, capital);

                System.out.println("DEBUG: PRINTING");

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


}
