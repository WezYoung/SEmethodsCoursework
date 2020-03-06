package com.napier.sem;

import java.sql.*;
import java.util.List;

/*
This class created by Wez Young(40402601). This class generates as well as connects to the world.sql file.
The world.sql file contains all data needed for world population and allows us to form SQL statements to
sort data in the file.
 */
public class DataBase
{
    //Variable to store db connection
    private static Connection con = null;


    //Main
    public static void main(String[] args)
    {
        //Initialise UI (Splash Screen?)
            //Menu - Chose topic eg. Countries report, Cities report, Capital City report, Population report..


        //Create Database
        DataBase db = new DataBase();

        //Methods containing relevant Queries to get data from DB
        CountriesLargeToSmall CountryLtoS = new CountriesLargeToSmall();
        CitiesLargeToSmall CitiesLtoS = new CitiesLargeToSmall();

        //Connect to Database
        db.connect();

        //Create printer to print out the Report
        ReportPrinter printer = new ReportPrinter();

        //TODO Add switch statement for UI
        //TODO look up why unicode characters not showing correctly when printed

        //Print Report - largest to smallest Countries in world
        System.out.println("Printing Report: all Countries in the world organised by largest population to smallest.");
        List<Country> listA = CountryLtoS.getCountriesLargeToSmallInWorld(con);  //List to store returned countries in
        printer.printCountry(listA);  //Print Report

        //Print Report - largest to smallest Countries in continent
        System.out.println("Printing Report: all Countries in a continent organised by largest population to smallest.");
        List<Country> listB = CountryLtoS.getCountriesLargeToSmallInContinent(con);  //List to store returned countries in
        printer.printCountry(listB);  //Print Report

        //Print Report - largest to smallest Countries in region
        System.out.println("Printing Report: all Countries in a region organised by largest population to smallest.");
        List<Country> listC = CountryLtoS.getCountriesLargeToSmallInRegion(con);  //List to store returned countries in
        printer.printCountry(listC);  //Print Report

        //Print Report - largest to smallest Cities in world
        System.out.println("Printing Report: all Cities in the world organised by largest population to smallest.");
        List<City> listD = CitiesLtoS.getCitiesLargeToSmallInWorld(con);
        printer.printCity(listD);  //Print Report

        //Print Report - largest to smallest Cities in continent
        System.out.println("Printing Report: all Cities in a continent organised by largest population to smallest.");
        List<City> listE = CitiesLtoS.getCitiesLargeToSmallInContinent(con);
        printer.printCity(listE);  //Print Report


        //Disconnect from Database
        db.disconnect();
    }

    /**
     * This Method connects to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 50;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(5000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * This Method disconnects from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}
