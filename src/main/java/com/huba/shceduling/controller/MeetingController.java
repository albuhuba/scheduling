package com.huba.shceduling.controller;

import com.huba.shceduling.request.MeetingRequest;
import com.huba.shceduling.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService service;

    @PostMapping("/")
    public void createMeeting(@RequestBody MeetingRequest request){
        service.createMeetings(request.getEmails(), request.getStartingHour());
    }
}
