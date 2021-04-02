package com.company;

import java.util.Comparator;

public class Person {
    private String name;
    private int age;
    private String nationality;

    public Person(String name, int age, String nationality ){
        setAge(age);
        setName(name);
        setNationality(nationality);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age < 100)
            this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


}

class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person a, Person b) {
        return a.getAge() < b.getAge() ? -1 : a.getAge() == b.getAge() ? 0 : 1;
    }
}
