package by.anabios13.appforcarsales.util;

import by.anabios13.appforcarsales.models.Person;
import by.anabios13.appforcarsales.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;


        if (personService.findUserByName(person.getName()).isEmpty())
            return;
        else
            errors.rejectValue("name", "", "This person already exist");
    }
}
