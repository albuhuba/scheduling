package com.huba.shceduling.controller;

import com.huba.shceduling.request.MeetingRequest;
import com.huba.shceduling.service.MeetingService;
import com.huba.shceduling.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService service;

    @Autowired
    private SchedulingService schedulingService;

    @PostMapping("/")
    public void createMeeting(@RequestBody MeetingRequest request){
        service.createMeetings(request.getEmails(), request.getStartingHour());
    }

    @PostMapping("/suggest")
    public Integer suggestMeeting(@RequestBody MeetingRequest request){
        return schedulingService.suggestPossibleMeetingTime(request.getStartingHour(), request.getEmails());
    }
}
