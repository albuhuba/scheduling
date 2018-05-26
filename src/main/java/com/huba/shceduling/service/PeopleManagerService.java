package com.huba.shceduling.service;

import com.huba.shceduling.exception.EmailAlreadyUsedException;
import com.huba.shceduling.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PeopleManagerService {

    // In the real world the map would not exist, and proper JPA queries would be used
    private static final HashMap<String, Person> personList = new HashMap<>();

    public void createPerson(String name, String email) {
        // JPA query would be used in real life
        if (personList.containsKey(email)){
            throw new EmailAlreadyUsedException();
        }

        personList.put(email, new Person(name, email));
    }

    public Person getPerson(String email) {
        return personList.get(email);
    }
}
