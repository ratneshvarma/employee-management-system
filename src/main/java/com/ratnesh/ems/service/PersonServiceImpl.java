package com.ratnesh.ems.service;

import com.ratnesh.ems.dao.PersonDao;
import com.ratnesh.ems.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ratnesh on 12/7/17.
 */
@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDAO;

    public void setPersonDAO(PersonDao personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
    }

    @Transactional
    public void updatePerson(Person p) {
        this.personDAO.updatePerson(p);
    }

    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }

    @Transactional
    public Person getPersonById(int id) {
        return this.personDAO.getPersonById(id);
    }

    @Transactional
    public void removePerson(int id) {
        this.personDAO.removePerson(id);
    }

}
