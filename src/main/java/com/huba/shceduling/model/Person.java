package com.huba.shceduling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {

    private final String name;
    private final String email;

    private Collection<Meeting> meetings = new ArrayList<>();

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person addMeeting(Meeting meeting) {
        // ideally this should return a copy, but for simplicity purposes I am reusing the original object
        this.meetings.add(meeting);
        return this;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Integer> getMeetingTimes() {
        return meetings.stream().map(m -> m.getStartingHour()).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
