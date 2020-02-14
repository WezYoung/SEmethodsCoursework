# USE CASE: 4 Produce a Report on the Top N Populated Cities where N is Provided by the User

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *User* I want to *produce a report on the top N populated cities in the World/Continent/Region/District where N is provided by the user* so that *I meet the demands of the organisation* 

### Scope

Company.

### Level

Primary task.

### Preconditions

We know all cities in the world. Database contains all countries, continents, regions, districts and cities.

### Success End Condition

A report is available for the user to provide to the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

Main User.

### Trigger

A request for population information is sent to the organisation.

## MAIN SUCCESS SCENARIO

1. Organisation request population information of the top N populated cities.
2. User extracts current population information of the top N populated cities.
3. User provides report to Organisation.


## EXTENSIONS

1. **Missing population data**:
    1. User informs organisation of missing population data.
2. **Continent/Region/Country/District given is not valid**:
    1. Application tells user to input the Continent/Region/Country/District again.
3.  **Number (N) given is not valid**:
    1. Application tells user to input number again.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
