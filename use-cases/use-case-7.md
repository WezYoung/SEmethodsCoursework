# USE CASE: 7 Produce a Report on the People, People Living in Cities, and People not Living in Cities in each Continent/Region/Country.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *Statistic Analyst* I want to *produce a report on people, people living in cities, and people not living in cities in each continent/region/country.* so that *I meet the demands of the organisation* 

### Scope

Company.

### Level

Primary task.

### Preconditions

We know all population information. Database contains all countries, continents, regions, districts and cities.

### Success End Condition

A report is available for the user to provide to the organisation which displays people, people living in cities and people not living in cities.

### Failed End Condition

No report is produced.

### Primary Actor

Main User.

### Trigger

A request for population information is sent to the organisation.

## MAIN SUCCESS SCENARIO

1. Organisation request population information for people, people living in cities, and people not living in cities in each continent/region/country.
2. User extracts current population information for people, people living in cities, and people not living in cities in each continent/region/country.
3. User provides report to Organisation.


## EXTENSIONS

1. **Missing population data**:
    1. User informs organisation of missing population data.
2. **Continent/Region/Country given is not valid**:
    1. Application tells user to input the Continent/Region/Country again.
3.  **Number (N) given is not valid**:
    1. Application tells user to input number again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
