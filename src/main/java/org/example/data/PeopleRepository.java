package org.example.data;

import org.example.model.Person;

public interface PeopleRepository {
   /*
    Define CRUD methods for Person.
    Create, Read, Update, Delete
    */

    Person create(String email, String firstName, String lastName, int age);
    Person findById(int id);
    Person[] findByLastName(String lastName);
    Person[] findAll();
    Person update(Person updatedPerson);
    boolean delete(Person person);
    boolean delete(int id);
    int size();
    void clear();

}
