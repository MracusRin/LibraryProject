package com.mracus.bookapp.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int personId;

    @NotEmpty(message = "Name should cannot by empty")
    @Size(min = 2, max = 100, message = "Name should by between 2 and 100 characters")
    private String name;

    @Min(value = 0, message = "Year born should by greater then 0")
    private int yearBorn;

    public Person(int personId, String name, int yearBorn) {
        this.personId = personId;
        this.name = name;
        this.yearBorn = yearBorn;
    }

    public Person() {
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }
}
