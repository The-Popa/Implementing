package org.example;

import org.example.data.PeopleRepository;
import org.example.model.Person;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PeopleRepository repository = PeopleArrayImpl.getInstance();

        Person erik = repository.create("tobias.carlstrom@bredband2.com", "Tobias", "Carlstrom", 25);

        System.out.println(Arrays.toString(repository.findByLastName("Carlstrom")));

        System.out.println(repository.findById(tobias.getId()));

        Person updatedErik = new Person(tobias.getId(), "tobias@gmail.com", tobias.getFirstName(), tobias.getLastName(), 22);

        repository.update(updatedTobias);

        System.out.println(repository.findById(1));



        System.out.println(repository.delete(erik));



    }

}