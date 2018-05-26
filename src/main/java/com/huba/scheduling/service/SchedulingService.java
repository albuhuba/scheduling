package com.huba.scheduling.service;

import com.huba.scheduling.exception.MeetingException;
import com.huba.scheduling.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SchedulingService {

    @Autowired
    private PeopleManagerService service;

    /**
     * I need a list or starting hours of the meetings and see the first available which is not used by anybody.
     * Returns the first common available meeting time after a specific starting time. If there is none, -1 is returned;
     */
    public Integer suggestPossibleMeetingTime(Integer startingFrom, List<String> emails) {
        validateInput(startingFrom);
        List<Person> people = service.getPeople(emails);
        Set<Integer> meetingTimes = new TreeSet<>();
        people.stream().map(p -> meetingTimes.addAll(p.getMeetingTimes()));

        return getFirstSlot(startingFrom, meetingTimes);
    }

    private void validateInput(Integer startingHour) {
        if (startingHour <= 0 || startingHour > 24) {
            throw new MeetingException("meeting is out of range");
        }
        // emails should be validated too, or by Spring or by lookups, etc
    }

    Integer getFirstSlot(Integer startingFrom, Set<Integer> meetingTimes) {
        ArrayList<Integer> list = new ArrayList(meetingTimes);
        if (startingFrom == null){
            startingFrom = 1;
        }

        if (list == null || list.isEmpty()){
            return startingFrom;
        }

        for (int i = startingFrom; i < 24; i++) {
            if (i != list.get(i != 0 ? i - 1 : 0)) {
                return i;
            }
        }

        return -1;
    }

}
