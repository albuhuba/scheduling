package com.huba.scheduling.service;

import com.huba.scheduling.exception.MeetingException;
import com.huba.scheduling.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SchedulingService {

    public static final List<Integer> FIXED_ALL_TIMES = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23);

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
        if (startingHour < 0 || startingHour >= 24) {
            throw new MeetingException("meeting is out of range");
        }
        // emails should be validated too, or by Spring or by lookups, etc
    }

    Integer getFirstSlot(Integer startingFrom, Set<Integer> meetingTimes) {
        List<Integer> emptySlots = getEmptySlots(startingFrom, createMeetingTimes(meetingTimes));
        return emptySlots.isEmpty() ? -1 : emptySlots.get(0);
    }

    private Object[] createMeetingTimes(Set<Integer> meetingTimes) {
        Object[] scheduleArray = new Object[24];
        meetingTimes.iterator().forEachRemaining(e -> scheduleArray[e] = new Object());

        return scheduleArray;
    }

    /*
    Meeting times size is validated before.
     */
    List<Integer> getEmptySlots(Integer startingFrom, Object[] meetimetimes) {
        if (startingFrom == null) {
            startingFrom = 1;
        }

        if (meetimetimes == null || meetimetimes.length == 0) {
            return FIXED_ALL_TIMES;
        }

        ArrayList<Integer> returnList = new ArrayList<>();

        for (int i = startingFrom; i < 24; i++) {
            if (meetimetimes[i] == null) {
                returnList.add(i);
            }
        }
        return returnList;
    }
}
