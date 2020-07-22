package br.com.pierre.restspringboot.services;

import br.com.pierre.restspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person){
        return person;
    }

    public Person update(Person person){
        return person;
    }

    public void delete(String id){

    }

    public Person finndById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("pierre");
        person.setLastName("Enoc");
        person.setAddress("São carlos-Sp-Brasil");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();
        for (int i =0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
}

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("person name" + i);
        person.setLastName("Last name" + i);
        person.setAddress("Some address in Brasil" + i);
        person.setGender("Male");
        return person;
    }
    }
