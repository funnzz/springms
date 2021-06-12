package my.homeprojects.springms.controllers;

import my.homeprojects.springms.entities.Person;
import my.homeprojects.springms.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){


        return new ResponseEntity<>(personService.addPerson(person),HttpStatus.CREATED);
    }

    @GetMapping("/getPerson/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        Optional<Person> optionalPerson = personService.getPerson(id);

        if (optionalPerson.isPresent()){
            return new ResponseEntity<>(optionalPerson.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        personService.deleteUser(id);
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long id){
//        return  person != null ? new ResponseEntity<>(personService.updatePerson(id, person),HttpStatus.OK) :
//                new ResponseEntity<>(HttpStatus.NOT_FOUND);
       return personService.getPerson(id).isPresent() ? new ResponseEntity<>(personService.updatePerson(id, person),HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

        //return new ResponseEntity<>(personService.updatePerson(id, person),HttpStatus.OK);
    }
}
