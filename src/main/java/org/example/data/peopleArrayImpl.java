package org.example.data;

import org.example.model.Person;

import java.util.Arrays;

public class peopleArrayImpl implements PeopleRepository{

    private static final PeopleArrayImpl INSTANCE;

    static {
    INSTANCE = new PeopleArrayImpl();
    people = new Person[0];

    }

    public static PeopleRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public Person create(String email, String firstName, String lastName, int age) {
        Person person = new Person(email, firstName, lastName, age);
        people = addToArray(people, person);
        return person;
    }

    private Person[] addToArray(final Person[] target, Person toAdd) {
        Person[] newArray = Arrays.copyOf(target, target.length + 1);
        newArray[newArray.length - 1] = toAdd;
        return newArray;

    }

    @Override
    public Person findById(int id) {
        person found = null;
        for(Person person : people) {
            if(person.getId() == id) {
                found = person;
                break;
            }
        }
        return found;
    }

    @Override
    public Person[] findByLastName(String lastName) {
        Person[] result = new Person[0];
        for(Person person : people) {
            if(person.getLastName().equalsIgnoreCase(lastName)) {
                result = addToArray(result, person);
            }
        }
        return result;
    }

    @Override
    public Person[] findAll() {
        return Arrays.copyOf(people, people.length);
    }

    @Override
    public Person update(Person updatedPerson) {
        Person toUpdate = findById(updatedPerson.getId());
        if(toUpdate == null) {
            return null;
        }
        toUpdate.setEmail(updatedPerson.getEmail());
        toUpdate.setAge(updatedPerson.getAge());
        toUpdate.setLastName(updatedPerson.getLastName());
        toUpdate.setFirstName(updatedPerson.getFirstName());
        return toUpdate;
    }

    @Override
    public boolean delete(Person person) {
        return delete(person.getId());
    }

    @Override
    public boolean delete(int id) {
        int index = -1;
        for(int i=0;i<people.length;i++) {
            if(people[i].getId() == id) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            return false;

        }

        people = removeByIndex(people, index);
        return findById(id) == null;
    }

    private Person[] removeByIndex(final Person[] source, int index) {
        Person[] left = Arrays.copyOfRange(source, 0, index);
        Person[] right = Arrays.copyOfRange(source, index +1, source.length);
        Person[] combined = Arrays.copyOf(left, left.length + right.length);


        for(int writePos = left.length, readPos = 0; writePos < combined.length; writePos++, readPos++) {
            combined[writePos] = right[readPos];
        }

        return combined;
    }

    @Override
    public int size() {
        return people.length;
    }

    @Override
    public void clear() {
        people = new Person[0];
    }
}
