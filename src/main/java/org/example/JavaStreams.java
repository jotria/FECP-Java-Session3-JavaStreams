package org.example;

import java.util.*;
import java.util.function.Predicate;

public class JavaStreams {
    static class Person{
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return getName() + " - " + getAge();
        }
    }

    public static void main(String[] args) {
        // Activity 1: Filter Odd Numbers
        List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isOdd = n->n%2==1;
        List<Integer> oddNumbers = num.stream()
                .filter(isOdd)
                .toList();
        System.out.println("Odd Numbers: " + oddNumbers);

        // Activity 2: Filter Strings Starting with 'A'
        List<String> names = Arrays.asList("Alice", "Adam", "Bob", "Angela", "Brian");
        Predicate<String> startsWithA = s->s.startsWith("A");
        List<String> nameStartsWithA = names.stream()
                .filter(startsWithA)
                .toList();
        System.out.println("Names starting with A: " + nameStartsWithA);

        // Activity 3: Square All Numbers
        List<Integer> sqrNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = sqrNumbers.stream()
                .map(n->n*n)
                .toList();
        System.out.println("Squared Numbers: " + squaredNumbers);

        // Activity 4: Combine Predicates
        List<Integer> listTo10 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isEven = n->n%2==0;
        Predicate<Integer> greaterThanFive = n-> n>5;

        List<Integer> evenAndBiggerThan5 = listTo10.stream()
                .filter(isEven.and(greaterThanFive))
                .toList();
        System.out.println("Even and >5: " + evenAndBiggerThan5);

        // Activity 5: Sort Objects Using Comparator
        List<Person> persons = Arrays.asList(
                new Person("John", 18),
                new Person("Ben", 20),
                new Person("Anna", 22),
                new Person("Mike", 25),
                new Person("Zara", 29)
        );

        // Sort by Age (Ascending Order)
        System.out.println("\nSorted by age (ascending): ");
        persons.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(System.out::println);

        // Sort by Name (Alphabetical Order)
        System.out.println("\nSorted by name: ");
        persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);

        // Sort by Age (Descending Order)
        System.out.println("\nSorted by age (descending): ");
        persons.stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .forEach(System.out::println);
    }
}