package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
Class was created by Wez Young(40402601). This class contains SQL statements for
cities from large to small based on population in the world, in continents, in countries,
in regions and in districts. 
 */
public class CitiesLargeToSmall {

    //Gets and sorts populations of countries in the world from largest to smallest
    public List<City> getCitiesLargeToSmallInWorld(Connection con)
    {
        try{
            //Create SQL Statement
            Statement stmt = con.createStatement();

            //Create string for SQL statement
            String strQuery =
                    "SELECT ci.`Name`, co.`Continent`, co.`Region`, ci.`District`, ci.`Population`, co.`Name` AS 'Country'" +
                            "FROM `city` ci " +
                            "JOIN `country` co ON ci.`CountryCode` = co.`Code`" +
                            "ORDER BY `Population` Desc";


            //Execute Query, store results in a ResultSet
            ResultSet rset = stmt.executeQuery(strQuery);

            //Create list to store cities in
            List<City> cityList = new ArrayList<>();

            //Go through all valid results, adding to Objects [Country, City etc.]
            while(rset.next())
            {
                //Get Each Property of the city
                String name = rset.getString("Name");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                //Create country - just name, continent, and region as no other country data needed for this report
                Country country = new Country(rset.getString("Country"), rset.getString("Continent"),
                rset.getString("Region"));
                System.out.println(country.getName());

                //Create City Object
                City city = new City(name, country, district, population);

                //Add City to list
                cityList.add(city);
            }

            //Return List
            return cityList;
        }
        catch(Exception e)
        {
            //error message displays if unable to get city data
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //Gets and sorts populations of countries in the world from largest to smallest
    public List<City> getCitiesLargeToSmallInContinent(Connection con)
    {
        try{
            //Create SQL Statement
            Statement stmt = con.createStatement();

            //Create string for SQL statement
            String strQuery =
                    "SELECT ci.`Name`, co.`Continent`, co.`Region`, ci.`District`, ci.`Population`, co.`Name` AS 'Country'" +
                            "FROM `city` ci " +
                            "JOIN `country` co ON ci.`CountryCode` = co.`Code`" +
                            "ORDER BY `Population` Desc";


            //Execute Query, store results in a ResultSet
            ResultSet rset = stmt.executeQuery(strQuery);

            //Create list to store cities in
            List<City> cityList = new ArrayList<>();

            //Go through all valid results, adding to Objects [Country, City etc.]
            while(rset.next())
            {
                //Get Each Property of the city
                String name = rset.getString("Name");
                String district = rset.getString("District");
                int population = rset.getInt("Population");

                //Create country - just name, continent, and region as no other country data needed for this report
                Country country = new Country(rset.getString("Country"), rset.getString("Continent"),
                        rset.getString("Region"));
                System.out.println(country.getName());

                //Create City Object
                City city = new City(name, country, district, population);

                //Add City to list
                cityList.add(city);
            }

            //Return List
            return cityList;
        }
        catch(Exception e)
        {
            //error message displays if unable to get city data
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public List<City> getCitiesLargeToSmallInRegion(Connection con)
    {
        return null;
    }

    public List<City> getCitiesLargeToSmallInCountry(Connection con)
    {
        return null;
    }

    public List<City> getCitiesLargeToSmallInDistrict(Connection con)
    {
        return null;
    }
}
