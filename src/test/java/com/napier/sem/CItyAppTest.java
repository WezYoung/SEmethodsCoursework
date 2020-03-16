package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CItyAppTest {

    //Test 1, tests city get name
    @Test
    public void testCityReportNameSuccess(){
        City city = new City("London");
        assertEquals("London", city.getName());
    }

    //Test 2, tests failure when cities are not equal
    @Test
    public void testCityReportNameFail(){
        City city = new City("Madrid");
        assertEquals(city.getName(), "Barcelona");
    }

    //Test 3, tests population get
    @Test
    public void testCityReportPopulation(){
        City city = new City("Madrid");
        assertEquals(city.getPopulation(), -1);
    }
}
