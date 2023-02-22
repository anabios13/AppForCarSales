package by.anabios13.appforcarsales;

import by.anabios13.appforcarsales.models.Person;
import by.anabios13.appforcarsales.repositories.PeopleRepository;
import by.anabios13.appforcarsales.services.PersonService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CRUDTestsPerson {

//Be careful when you're using tests. If you have users with names:
// "My person" and "Updated person Name"
// They will be removed

    @Autowired
    public CRUDTestsPerson(PeopleRepository peopleRepository, PersonService personService) {
        this.peopleRepository = peopleRepository;
        this.personService = personService;
    }

    final PeopleRepository peopleRepository;
    final PersonService personService;
    Person person = new Person();

    @BeforeEach
    public void initPerson() {
        person.setName("My person");
        person.setYearOfBirth(1999);
        person.setPassword("1111");
        person.setRole("ROLE_USER");
    }

    @Test
    public void testCRUDWithCorrectData() {
        if (!personService.searchPersonByName(person.getName()).isEmpty()) {
            int id = personService.searchPersonByName(person.getName()).get(0).getId();
            personService.delete(id);
        }

        personService.save(person);
        assertNotNull(personService.searchPersonByName(person.getName()).get(0).getName());
        assertTrue(person.equals(personService.searchPersonByName(person.getName()).get(0)));

        if (!personService.searchPersonByName("Updated person Name").isEmpty())
            personService.delete(personService.searchPersonByName("Updated person Name").get(0).getId());

        int id = personService.searchPersonByName(person.getName()).get(0).getId();
        person.setName("Updated person Name");
        personService.update(id, person);
        assertNotNull(person.equals(personService.searchPersonByName(person.getName()).get(0)));
        assertTrue(person.equals(personService.searchPersonByName(person.getName()).get(0)));

        personService.delete(personService.searchPersonByName(person.getName()).get(0).getId());
        assertTrue(personService.searchPersonByName(person.getName()).isEmpty());
    }

    @Test
    public void testSaveWithIncorrectData() {
        person.setYearOfBirth(-1);
        if (!personService.searchPersonByName(person.getName()).isEmpty()) {
            int id = personService.searchPersonByName(person.getName()).get(0).getId();
            personService.delete(id);
        }
        assertThrows(ConstraintViolationException.class, () -> personService.save(person));
        assertTrue(personService.searchPersonByName(person.getName()).isEmpty());
        if (!personService.searchPersonByName(person.getName()).isEmpty())
            personService.delete(personService.searchPersonByName(person.getName()).get(0).getId());
    }
}
