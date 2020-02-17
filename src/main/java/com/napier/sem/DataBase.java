package com.napier.sem;

import java.sql.*;

public class DataBase
{
    private static Connection con = null;

    public static void main(String[] args)
    {
        DataBase db = new DataBase();
        CountriesLargeToSmall CountryLtoS = new CountriesLargeToSmall();
        //connect to the database
        db.connect();

        //countries reports large to small in world
        System.out.println("countries in the world organised by largest population to smallest.");
        CountryLtoS.getCountriesLargeToSmallInWorld(con);

        //countries reports large to small in continent
        System.out.println("\r\ncountries in a continent organised by largest population to smallest.");
        CountryLtoS.getCountriesLargeToSmallInContinent(con);

        //countries reports large to small in region
        System.out.println("\r\ncountries in a region organised by largest population to smallest.");
        CountryLtoS.getCountriesLargeToSmallInRegion(con);


        //disconnect from database
        db.disconnect();
    }

    /**
     * Connect to the MySQL database.
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
     * Disconnect from the MySQL database.
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
