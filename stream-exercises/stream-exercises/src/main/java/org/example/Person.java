package org.example;

import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private String surname;

    private List<String> emails;

    public Person(String name, String surname, List<String> emails) {
        this.name = name;
        this.surname = surname;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(emails, person.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, emails);
    }
}