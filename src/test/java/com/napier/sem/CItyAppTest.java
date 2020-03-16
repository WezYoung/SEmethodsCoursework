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

    @Test
    public void testCityReportNameSuccess(){
        City city = new City("London");
        assertEquals("London", city.getName());
    }

    @Test
    public void testCityReportNameFail(){
        City city = new City("Madrid");
        assertEquals(city.getName(), "Barcelona");
    }

    @Test
    public void testCityReportPopulation(){
        City city = new City("Madrid");
        assertEquals(city.getPopulation(), -1);
    }
}
