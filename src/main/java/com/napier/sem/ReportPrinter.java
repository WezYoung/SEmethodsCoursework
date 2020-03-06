package com.napier.sem;

import java.util.List;

public class ReportPrinter {

    //Method to Print out a list of countries, showing only the fields defined in parameter
    public void printCountry(List<Country> list)
    {
        //Code to print list
        if (list != null) {

            //Print Header
            System.out.format("%-8s%-37s%-20s%-27s%-11s%-35s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
            System.out.println("-------------------------------------------------------------------------------------------------");

            //Loop through list
            for (Country country : list) {

                System.out.format("%-8s%-37s%-20s%-27s%-11d%-35s\n", country.getCode(), country.getName(), country.getContinent(),
                        country.getRegion(), country.getPopulation(), country.getCapital().getName());

            }
        } else {
            //ERROR, no results
            System.out.println("ERROR - No results returned");
        }
    }

    //Method to Print out a list of countries, showing only the fields defined in parameter
    public void printCity(List<City> list)
    {
        //Code to print list
        if (list != null) {

            //Print Header
            System.out.format("%-37s%-52s%-26s%-20s%-20s%-11s\n", "Name", "Country", "Region", "Continent", "District", "Population");
            System.out.println("-------------------------------------------------------------------------------------------------");

            //Loop through list
            for (City city : list) {

                System.out.format("%-37s%-52s%-26s%-20s%-20s%-11s\n",city.getName(), city.getCountry().getContinent(),
                        city.getCountry().getRegion(), city.getPopulation());

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
