package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class CountryLanguageAppTest {


    //Test 1, test country language is equal
    @Test
    public void countryLanguageTest(){
        Country country = new Country("Spain");
        CountryLanguage lang = new CountryLanguage(country, "Spanish");
        CountryLanguage cl = new CountryLanguage(country, "Spanish", true, 66.7);
    }
}
