package by.anabios13.appforcarsales.services;

import by.anabios13.appforcarsales.models.Person;
import by.anabios13.appforcarsales.repositories.PeopleRepository;
import by.anabios13.appforcarsales.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByName(username);

        if (person.isEmpty())
            throw new UsernameNotFoundException("User Not Found!");

        return new PersonDetails(person.get());
    }
}
