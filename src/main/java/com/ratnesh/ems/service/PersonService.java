package com.ratnesh.ems.service;

import com.ratnesh.ems.model.Person;

import java.util.List;

/**
 * Created by ratnesh on 12/7/17.
 */
public interface PersonService {

    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);

}

