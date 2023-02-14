package by.anabios13.appforcarsales.services;

import by.anabios13.appforcarsales.models.Person;
import by.anabios13.appforcarsales.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> searchPersonByName(String name){
        return personRepository.findByNameContaining(name);
    }
    public Person findOne(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public void save(Person person){
        personRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson){
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }
}

