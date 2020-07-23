package br.com.pierre.restspringboot.controller;

import br.com.pierre.restspringboot.math.SimpleMat;
import br.com.pierre.restspringboot.model.Person;
import br.com.pierre.restspringboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServices services;

    private SimpleMat math = new SimpleMat();

    @GetMapping
        public List<Person> findByAll() {
        return services.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
       return services.finndById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }

    @DeleteMapping("/{id}")
         public ResponseEntity<?>  delete(@PathVariable("id") Long id) {
         services.delete(id);
         return ResponseEntity.ok().build();
    }
}