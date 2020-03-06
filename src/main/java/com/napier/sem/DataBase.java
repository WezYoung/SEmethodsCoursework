package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
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
        List<String> continentList = new ArrayList<>();
        List<String> regionList = new ArrayList<>();

        //Initialise UI (Splash Screen?)
            //Menu - Chose topic eg. Countries report, Cities report, Capital City report, Population report..


        continentList.add("Europe");
        continentList.add("Asia");
        continentList.add("Oceania");
        continentList.add("Africa");
        continentList.add("North America");
        continentList.add("South America");
        continentList.add("Antarctica");

        regionList.add("Northern Europe");
        regionList.add("Southern Europe");
        regionList.add("Eastern Europe");
        regionList.add("Western Europe");
        regionList.add("South and Central Asia");
        regionList.add("Southeast Asia");
        regionList.add("Eastern Asia");
        regionList.add("Northern Africa");
        regionList.add("Southern Africa");
        regionList.add("Western Africa");
        regionList.add("Eastern Africa");
        regionList.add("Central Africa");
        regionList.add("South America");
        regionList.add("North America");
        regionList.add("Central America");
        regionList.add("Antarctica");
        regionList.add("Australia and New Zealand");
        regionList.add("Nordic Countries");
        regionList.add("Baltic Countries");
        regionList.add("Micronesia");
        regionList.add("Melanesia");
        regionList.add("British Islands");
        regionList.add("Caribbean");
        regionList.add("Middle East");
        regionList.add("Polynesia");
        regionList.add("Micronesia/Caribbean");


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
        List<Country> CountryWorldList = CountryLtoS.getCountriesLargeToSmallInWorld(con);  //List to store returned countries in
        printer.printCountry(CountryWorldList);  //Print Report

        System.out.println("Printing Report: all Countries in a continent organised by largest population to smallest.");
        //Loop for each continent
        for(String continent : continentList){
            //Print Report - largest to smallest Countries in continent
            System.out.println("\nContinent Name: " + continent);
            List<Country> listB = CountryLtoS.getCountriesLargeToSmallInContinent(con, continent);  //List to store returned countries in
            printer.printCountry(listB);  //Print Report
        }

        System.out.println("Printing Report: all Countries in a region organised by largest population to smallest.");
        //Loop for each region
        for(String region : regionList){
            //Print Report - largest to smallest Countries in a region
            System.out.println("\nRegion Name: " + region);
            List<Country> listC = CountryLtoS.getCountriesLargeToSmallInRegion(con, region);  //List to store returned countries in
            printer.printCountry(listC);  //Print Report
        }


/*
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
*/

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
