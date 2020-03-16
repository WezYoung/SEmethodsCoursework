package com.napier.sem;

public class CountryLanguage {
    private Country country;
    private String language;
    private boolean isOfficial;
    private Double percentage;

    //Constructor
    public CountryLanguage(Country country, String language, boolean isOfficial, Double percentage) {
        this.country = country;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public CountryLanguage(Country country, String language){
        this.country = country;
        this.language = language;
        this.isOfficial = true;
        this.percentage = 66.7;
    }


    //Getters and Setters
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
