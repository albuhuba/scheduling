package com.huba.shceduling.controller;

import com.huba.shceduling.service.PeopleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PeopleManagerService service;

    @PostMapping("/")
    public void createPerson(@RequestParam String name, @RequestParam String email ){
        service.createPerson(name, email);
    }

}
