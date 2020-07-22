package br.com.pierre.restspringboot.controller;

import br.com.pierre.restspringboot.exception.Unsuported;
import br.com.pierre.restspringboot.math.SimpleMat;
import br.com.pierre.restspringboot.model.Person;
import br.com.pierre.restspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServices services;

    private SimpleMat math = new SimpleMat();

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findByAll() {
        return services.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id) {
       return services.finndById(id);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
         public void  delete(@PathVariable("id") String id) {
         services.delete(id);
    }
}