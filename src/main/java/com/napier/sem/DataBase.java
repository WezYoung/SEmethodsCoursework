package com.napier.sem;

import java.sql.*;
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

        //Create Database
        DataBase db = new DataBase();

        //Queries
        CountriesLargeToSmall CountryLtoS = new CountriesLargeToSmall();
        CitiesLargeToSmall CitiesLtoS = new CitiesLargeToSmall();

        //Connect to Database
        db.connect();

        //TODO Add switch statement for UI
        //TODO look up why unicode characters not showing correctly when printed

        //Print Report - largest to smallest Countries in world
        System.out.println("countries in the world organised by largest population to smallest.");
        CountryLtoS.getCountriesLargeToSmallInWorld(con);

        //Print Report - largest to smallest Countries in continent
        System.out.println("\r\ncountries in a continent organised by largest population to smallest.");
        CountryLtoS.getCountriesLargeToSmallInContinent(con);

        //Print Report - largest to smallest Countries in region
        System.out.println("\r\ncountries in a region organised by largest population to smallest.");
        CountryLtoS.getCountriesLargeToSmallInRegion(con);

        //Cities report large to small in world
        System.out.println("cities in the world organised by largest population to smallest.");
        CitiesLtoS.getCitiesLargeToSmallInWorld(con);

        //Cities report large to small in continent
        System.out.println("\r\ncities in a continent organised by largest population to smallest.");
        CitiesLtoS.getCitiesLargeToSmallInContinent(con);


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
                Thread.sleep(30000);
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
