package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class CountryAppTest {

    @Test
    public void testCountryReportName(){
        Country country = new Country("Germany");
        assertEquals("Germany", country.getName());
    }

    @Test
    public void testCountryReportCodeLength(){
        assertThrows(IllegalArgumentException.class,
                () -> new Country("DEUT", "null", "null", "null", 0, null));
        assertThrows(IllegalArgumentException.class,
                () -> new Country("DE", "null", "null", "null", 0, null));
    }

    @Test
    public void testCountryReportSuccess(){
        City city = new City("Amsterdam");
        Country country = new Country("GER", "Germany", "America", "North America", 30, city);
        assertEquals("GER", country.getCode());
        assertEquals("Germany", country.getName());
        assertEquals("America", country.getContinent());
        assertEquals("North America", country.getRegion());
        assertEquals(30, country.getPopulation());
        assertEquals("Amsterdam", city.getName());
    }


    /*
    @Test
    public void testCountryReportFail(){
        City city = new City("Amsterdam");
        Country country = new Country("GER", "Germany", "America", "North America", 40, city);
        assertEquals("GER", country.getCode());
        assertEquals("Germany", country.getName());
        assertEquals("America", country.getContinent());
        assertEquals("North America", country.getRegion());
        assertEquals(30, country.getPopulation());
        assertEquals("Amsterdam", city.getName());
    }
    */

    @Test
    public void testContinentReport(){
        Country country = new Country("The Netherlands", "Europe");
        assertEquals("Europe", country.getContinent());
    }
}
