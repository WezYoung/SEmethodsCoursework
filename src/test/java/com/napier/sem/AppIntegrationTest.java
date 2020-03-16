package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest {

    static DataBase db;
    static Country count;
    static ReportPrinter rp;
    static ArrayList<Country> countrylist;

    @BeforeAll
    static void init(){
        rp = new ReportPrinter();
        db = new DataBase();
        count = new Country();
        countrylist = new ArrayList<>();
    }

    @Test
    public void testGetCountry(){
        Country country = new Country();
        country.setName("Spain");

        countrylist.add(country);
        rp.printCountry(countrylist);
    }
}
