package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<String> convertCollectionElementsToUpperCase(List<String> stringList) {

        return stringList.stream()
                .map( (elem) -> {
                    String string = elem.toUpperCase();
                    return string;
                }).collect(Collectors.toList());

    }

    public static List<String> filterCollection(List<String> stringList) {

        return stringList.stream()
                .filter(elem -> elem.length() < 4)
                .collect(Collectors.toList());

    }

    public static List<String> flatten2DCollection(List<List<String>> matrix) {

        return matrix.stream()
                .flatMap(elem -> elem.stream()).collect(Collectors.toList());

    }

    public static Person oldestPerson(List<Person> personList) {

        return personList.stream()
                .reduce((p1,p2) -> p1.getAge() > p2.getAge() ? p1 : p2).get();

    }

    public static int sumOfCollection(List<Integer> integerList) {

        return  integerList.stream().reduce(0, (first,second) -> first + second);

    }

    public static List<String> getKidsNames(List<Person> people) {

        return people.stream()
                .filter(person -> person.getAge() < 18)
                .map(kid -> kid.getName())
                .collect(Collectors.toList());

    }

    public static Map<Boolean, List<Person>> partitionAdultsKids(List<Person> people) {

        return people.stream()
                .collect(Collectors.partitioningBy(person -> person.getAge() >= 18 ));

    }

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {

        return people.stream()
                .collect(Collectors.groupingBy(person -> person.getNationality()));

    }

    public static String namesToString(List<Person> people) {

        String names = "Names : ";
        names += people.stream().map(person -> person.getName() ).collect(Collectors.joining(", "));
        return names;

    }

    public static void main(String[] args) {
	// write your code here
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("asfsadgfds");
        stringArrayList.add("a");
        stringArrayList.add("fds");
        stringArrayList.add("asfsadgfds");
        stringArrayList.add("asfsadgasdfvdsfds");
        stringArrayList.add("gfds");
        stringArrayList.add("ds");
        stringArrayList.add("asfsadfsafddsadgfds");
        stringArrayList.add("sadfdsfasfsadgfds");

        System.out.println("ToUpperCase--------------------------------------------------------------");
        convertCollectionElementsToUpperCase(stringArrayList).forEach(each -> System.out.println(each));

        System.out.println("Length Is Smaller Than 4-------------------------------------------------");
        filterCollection(stringArrayList).forEach(each -> System.out.println(each));

        System.out.println("Flatten multidimensional collection--------------------------------------");
        List<List<String>> matrix = Arrays.asList(
                Arrays.asList("1","2","3"),
                Arrays.asList("4","5"),
                Arrays.asList("6")
        );
        flatten2DCollection(matrix).forEach(elem -> System.out.println(elem));

        System.out.println("Oldest person------------------------------------------------------------");
        List<Person> people = Arrays.asList(
                new Person("James", 24, "British"),
                new Person("Polo", 18,"Italian"),
                new Person("Petros", 21,"Armenian"),
                new Person("Omar", 24, "French"),
                new Person("Pedro", 17,"Italian"),
                new Person("Poxos", 12,"Armenian")
        );
        System.out.println(oldestPerson(people).getName());

        System.out.println("Sum of collection elements-----------------------------------------------");
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        System.out.println(sumOfCollection(integers));

        System.out.println("Get kids names-----------------------------------------------------------");
        getKidsNames(people).forEach(each -> System.out.println(each));

        System.out.println("Partition adults and kids------------------------------------------------");
        partitionAdultsKids(people).get(true).forEach(adult -> System.out.print(adult.getName() + " ") );
        System.out.println();
        partitionAdultsKids(people).get(false).forEach(adult -> System.out.print(adult.getName() + " ") );
        System.out.println();

        System.out.println("Group by Nationality-----------------------------------------------------");
        groupByNationality(people).get("British").forEach(adult -> System.out.print(adult.getName() + " ") );
        System.out.println();
        groupByNationality(people).get("Italian").forEach(adult -> System.out.print(adult.getName() + " ") );
        System.out.println();
        groupByNationality(people).get("French").forEach(adult -> System.out.print(adult.getName() + " ") );
        System.out.println();
        groupByNationality(people).get("Armenian").forEach(adult -> System.out.print(adult.getName() + " ") );
        System.out.println();

        System.out.println("Print names--------------------------------------------------------------");
        System.out.println(namesToString(people));
    }
}

