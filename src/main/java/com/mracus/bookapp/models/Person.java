package com.mracus.bookapp.models;

public class Person {
    private int personId;
    private String name;
    private int yearBorn;

    public Person(int personId, String name, int yearBorn) {
        this.personId = personId;
        this.name = name;
        this.yearBorn = yearBorn;
    }

    public Person() {}

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
