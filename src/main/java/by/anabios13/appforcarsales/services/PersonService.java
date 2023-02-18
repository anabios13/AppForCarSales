package by.anabios13.appforcarsales.services;

import by.anabios13.appforcarsales.models.Person;
import by.anabios13.appforcarsales.repositories.PeopleRepository;
import by.anabios13.appforcarsales.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> searchPersonByName(String name) {
        return peopleRepository.findByNameContaining(name);
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    public Optional<Person> findUserByName(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByName(username);
        return person;
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}

