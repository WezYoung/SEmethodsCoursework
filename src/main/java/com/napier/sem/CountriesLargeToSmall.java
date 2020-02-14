package com.napier.sem;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountriesLargeToSmall {

    public CountriesData getCountriesLargeToSmallInWorld(Connection con)
    {
        try{
            //create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect ="";
                    //Insert SQL here
            //execute statement
            ResultSet rset = stmt.executeQuery(strSelect);
            //Return country if valid
            //check one is returned
            if(rset.next())
            {
                CountriesData country = new CountriesData();
                country.population = rset.getInt("population");
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
}
