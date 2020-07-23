package br.com.pierre.restspringboot.services;

import br.com.pierre.restspringboot.exception.ResourceNotFoundException;
import br.com.pierre.restspringboot.model.Person;
import br.com.pierre.restspringboot.repository.PersonRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public Person create(Person person){
        return repository.save(person);
    }

    public Person update(Person person){
        Person entity = repository.findById(person.getId())
           .orElseThrow(() -> new ResourceNotFoundException("No records found for ths Id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);

    }

    public void delete(Long id){
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for ths Id"));
        repository.delete(entity);
    }

    public Person finndById(Long id) {
        return repository.findById(id)
           .orElseThrow(()-> new ResourceNotFoundException("No records found for ths Id"));

    }

    public List<Person> findAll(){
        return repository.findAll();
}
    }
