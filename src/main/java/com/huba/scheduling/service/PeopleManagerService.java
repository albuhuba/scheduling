package com.huba.scheduling.service;

import com.huba.scheduling.exception.EmailAlreadyUsedException;
import com.huba.scheduling.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeopleManagerService {

    // In the real world the map would not exist, and proper JPA queries would be used
    private static final HashMap<String, Person> peopleMap = new HashMap<>();

    public void createPerson(String name, String email) {
        // JPA query would be used in real life
        if (peopleMap.containsKey(email)){
            throw new EmailAlreadyUsedException();
        }

        peopleMap.put(email, new Person(name, email));
    }

    public Person getPerson(String email) {
        return peopleMap.get(email);
    }

    public List<Person> getPeople(List<String> emails) {
        return peopleMap.entrySet()
                .stream()
                .filter((entry)->emails.contains(entry.getKey()))
                .map(e->e.getValue()).collect(Collectors.toList());
    }
}
