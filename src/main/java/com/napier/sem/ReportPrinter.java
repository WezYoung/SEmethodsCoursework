package com.napier.sem;

import java.util.List;

public class ReportPrinter {

    //Method to Print out a list of countries, showing only the fields defined in parameter
    public void print(List<Country> list)
    {
        //Code to print list
        if (list != null) {

            //Print Header
            String header = "";

            header += "Code" + "\t";
            header += "Name" + "\t";
            header += "Continent" + "\t";
            header += "Population" + "\t";
            header += "Capital";

            //Print Header
            System.out.println(header);


            //Loop through list
            for (Country country : list) {
                String line = "";

                line += country.getCode() + "\t";
                line += country.getName() + "\t";
                line += country.getContinent() + "\t";
                line += country.getRegion() + "\t";
                line += country.getPopulation() + "\t";
                line += country.getCapital();

                //Print Line
                System.out.println(line);
            }
        } else {
            //ERROR, no results
            System.out.println("ERROR - No results returned");
        }
    }



    //Method to Print out a list of countries, showing only the fields defined in parameter
    public void print(List<Country> list, String parameter)
    {
        //Code to print list
        if (list != null) {

            //Print Header
            String header = "";

            if(parameter.contains("code")) {
                header += "Code";
                header += "\t";
            }
            if(parameter.contains("name")) {
                header += "Name";
                header += "\t";
            }
            if(parameter.contains("region")) {
                header += "Region";
                header += "\t";
            }
            if(parameter.contains("continent")) {
                header += "Continent";
                header += "\t";
            }
            if(parameter.contains("population")) {
                header += "Population";
                header += "\t";
            }

            //Print Line
            System.out.println(header);


            //Loop through list
            for (Country country : list) {
                String line = "";

                //Custom Fields
                if(parameter.contains("code")) {
                    line += country.getCode();
                    line += "\t";
                }
                if(parameter.contains("name")) {
                    line += country.getName();
                    line += "\t";
                }
                if(parameter.contains("region")) {
                    line += country.getRegion();
                    line += "\t";
                }
                if(parameter.contains("continent")) {
                    line += country.getContinent();
                    line += "\t";
                }
                if(parameter.contains("population")) {
                    line += country.getPopulation();
                    line += "\t";
                }

                //Print Line
                System.out.println(line);
            }
        } else {
            //ERROR, no results
            System.out.println("ERROR - No results returned");
        }
    }
}
