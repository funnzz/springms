package my.homeprojects.springms.service;

import my.homeprojects.springms.entities.Person;
import my.homeprojects.springms.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public Person addPerson(Person person){
        return personRepo.save(person);
    }

    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }

    public Optional<Person> getPerson(Long id){
        return personRepo.findById(id);
    }

    public void deleteUser(Long id){
        personRepo.deleteById(id);
    }

    public Person updatePerson(Long id, Person person){
        Optional<Person> optionalPerson = personRepo.findById(id);

        if(optionalPerson.isPresent()){
            Person personDto = optionalPerson.get();
            personDto.setFirstName(person.getFirstName());
            personDto.setLastName(person.getLastName());
            personDto.setAge(person.getAge());
            return personRepo.save(personDto);
        }else{
            return null;
        }

    }

}
