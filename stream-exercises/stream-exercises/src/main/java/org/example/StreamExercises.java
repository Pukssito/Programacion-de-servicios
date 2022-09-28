package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercises {


    private List<Integer> sum10(List<Integer> numbers) {
        List<Integer> numberPlus10 = new LinkedList<>();
        for (int number : numbers) {
            numberPlus10.add(number + 10);
        }
        return numberPlus10;
    }

    // Versión funcional del método sum10
    private List<Integer> sum10Fun(List<Integer> numbers) {
        return numbers
                // Es necesario convertir la List<Integer> a Stream<Integer> para poder usar
                // los método funcionales
                .stream()
                // Map es un método funcional que convierte Stream<A> -> Stream<B>, f: A -> B
                // Lambda
                .map(number -> number + 10)
                // Vuelvo a convertir el Stream<Integer> a List<Integer>
                .collect(Collectors.toList());
    }

    private int sum10(int number) {
        return number + 10;
    }

    private List<Integer> minus10(List<Integer> numbers) {
        List<Integer> numberPlus10 = new LinkedList<>();
        for (int number : numbers) {
            numberPlus10.add(number - 10);
        }
        return numberPlus10;
    }

    private List<Integer> minus10Fun(List<Integer> numbers) {
        return numbers
                .stream()
                .map(number -> number - 10)
                .collect(Collectors.toList());
    }

    // map List<A> -> List<B> f: Person -> String
    private List<String> getSurnames(List<Person> people) {
        List<String> surnames = new LinkedList<>();
        for (Person person : people) {
            surnames.add(person.getSurname());
        }
        return surnames;
    }

    private List<String> getSurnamesFun(List<Person> people) {
        return people
                .stream()
                // f: Person -> String
                .map(person -> person.getSurname())
                .collect(Collectors.toList());
    }

    // Bob Esponja, Ana García, Peppa Pig, Pepe García
    private List<Person> findGarcia(List<Person> people) {
        List<Person> garcias = new LinkedList<>();
        for (Person person : people) {
            if (person.getSurname().equals("García")) {
                garcias.add(person);
            }
        }
        return garcias;
    }

    private List<Person> findBob(List<Person> people) {
        List<Person> garcias = new LinkedList<>();
        for (Person person : people) {
            if (person.getName().equals("Bob")) {
                garcias.add(person);
            }
        }
        return garcias;
    }

    private List<String> findGarciaNamesFun(List<Person> people) {
        return people
                .stream()
                .filter(person -> person.getSurname().equals("García"))
                .map(person -> person.getName())
                .collect(Collectors.toList());
    }

    // A -> List<B> Person -> List<String> List<A> -> List<B> List<List<String>>
    // A = Person B = String f: Person -> Stream<String> flatMap
    private List<String> getEmails(List<Person> people) {
        return people
                .stream()
                .flatMap(person -> person.getEmails().stream())
                .collect(Collectors.toList());
    }


    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        return sum;
    }

    private int multiply(List<Integer> numbers) {
        int sum = 1;
        for (int number : numbers) {
            sum = sum * number;
        }
        return sum;
    }

    // List<A> -> A
    // (2, 44, 5, 6) -> 46, 5, 6 _> 51, 6 -> 57
    private int sumFun(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0, (a, b) -> a + b);
    }

    private int multFun(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(1, (a, b) -> a * b);
    }

    private int getNumberOfEmails(List<Person> people) {
        return people
                .stream()
                .map(person -> person.getEmails().size())
                .reduce(0, (a, b) -> a + b);
    }

    private boolean existBobEsponja(List<Person> people) {
        for (Person person : people) {
            if (person.getName().equals("Bob") && person.getSurname().equals("Esponja")) {
                return true;
            }
        }
        return false;
    }

    private boolean existBobEsponjaFun(List<Person> people) {
        return people
                .stream()
                .anyMatch(person ->
                        person.getName().equals("Bob") &&
                                person.getSurname().equals("Esponja")
                );
    }
}