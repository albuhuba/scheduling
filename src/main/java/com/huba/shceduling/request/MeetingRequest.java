package com.huba.shceduling.request;

import java.util.List;

public class MeetingRequest {

    private List<String> emails;
    private Integer startingHour;

    public MeetingRequest(List<String> emails, Integer startingHour) {
        this.emails = emails;
        this.startingHour = startingHour;
    }

    public List<String> getEmails() {
        return emails;
    }

    public Integer getStartingHour() {
        return startingHour;
    }
}
