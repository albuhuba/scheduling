package com.huba.shceduling.service;

import com.huba.shceduling.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SchedulingService {

    @Autowired
    private PeopleManagerService service;

    /**
     * Returns the first common available meeting time after a specific starting time. If there is none, -1 is returned;
     */
    public Integer suggestPossibleMeetingTime(Integer startingFrom, List<String> emails) {
        List<Person> people = service.getPeople(emails);
        Set<Integer> meetingTimes = new TreeSet<>();
        people.stream().map(p -> meetingTimes.addAll(p.getMeetingTimes()));

        return getFirstSlot(startingFrom, meetingTimes);
    }

    Integer getFirstSlot(Integer startingFrom, Set<Integer> meetingTimes) {
        ArrayList<Integer> list = new ArrayList(meetingTimes);

        for (int i = startingFrom; i < 25; i++) {
            if (i != list.get(i != 0 ? i - 1 : 0)) {
                return i;
            }
        }

        return -1;
    }

}
