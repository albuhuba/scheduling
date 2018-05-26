package com.huba.shceduling.service;

import com.huba.shceduling.exception.MeetingException;
import com.huba.shceduling.model.Meeting;
import com.huba.shceduling.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private PeopleManagerService service;

    public void createMeetings(List<String> emails, Integer startingHour) {
        validateInput(startingHour);
        emails.forEach(email -> {
            Person person = service.getPerson(email);
            if (person != null) {
                Meeting meeting = new Meeting(startingHour);
                person.addMeeting(meeting);
            }
            // in real life this would be one transaction and if one would fail, none would be created
            // or other logic would be applied if the meetings are added separately to the person
        });

    }

    private void validateInput(Integer startingHour) {
        if (startingHour < 0 || startingHour > 24) {
            throw new MeetingException("meeting is out of range");
        }
    }

}
