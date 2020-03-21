# CriteriaApi

The project gives us the opportunity to get data from the database without knowledge of SQL. Something like a Criteria API implementation.

It provides an opportunity to indicate what we want to receive (for example, objects of the "Candidates" class),and selection criteria (for example: "name" is equal to "Мария" and "surname" is equal to "Морская"; surname ends with "oв" or gender - "female").
Example:
.eq("name", "Мария").and().eq("surname", "Морская").build();
.endWith("surname", "ов").or().eq("gender", "female").build();

Run tests to understand how this works.
