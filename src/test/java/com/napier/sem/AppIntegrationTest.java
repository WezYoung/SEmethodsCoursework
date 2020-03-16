package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest {

    static DataBase db;
    static Country count;
    static ReportPrinter rp;
    static List<Country> countrylist;

    @BeforeAll
    static void init(){
        rp = new ReportPrinter();
        db = new DataBase();
        count = new Country();
        countrylist = new ArrayList<>();
    }

    @Test
    public void testGetCountryName(){
        City city = new City("Berlin");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        assertEquals(country.getName(), "Germany");
    }

    @Test
    public void testGetCountryCode(){
        City city = new City("Berlin");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        assertEquals(country.getCode(), "GER");
    }

    @Test
    public void testGetCountryContinent(){
        City city = new City("Berlin");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        assertEquals(country.getContinent(), "Europe");
    }

    @Test
    public void testGetCountryRegion(){
        City city = new City("Berlin");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        assertEquals(country.getRegion(), "Central Europe");
    }

    @Test
    public void testGetCountryPop(){
        City city = new City("Berlin");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        assertEquals(country.getPopulation(), 0);
    }

    @Test
    public void testGetCountryCapital(){
        City city = new City("Berlin");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        assertEquals(country.getCapital(), city);
    }



    @Test
    public void testCountryList(){
        City city = new City("Berlin");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        countrylist.add(country);
        assertEquals(countrylist.get(0), country);
    }


    @Test
    public void testGetCity(){
        City city = new City("Berlin");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        countrylist.add(country);
        assertEquals(countrylist.get(0).getCapital().getName(), "Berlin");
    }

    /*
    @Test
    public void testReportPrinter(){
        City city = new City("Amsterdam");
        Country country = new Country("GER", "Germany", "Europe", "Central Europe", 0, city);
        countrylist.add(country);
        rp.printCountry(countrylist);
        assertEquals();

    }
    */

}