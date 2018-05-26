package com.huba.shceduling.model;

import java.util.Objects;

public class Meeting {

    private final Integer startingHour;

    public Meeting(Integer startingHour) {
        this.startingHour = startingHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(startingHour, meeting.startingHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingHour);
    }
}
