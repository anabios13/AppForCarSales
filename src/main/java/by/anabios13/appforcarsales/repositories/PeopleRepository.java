package by.anabios13.appforcarsales.repositories;

import by.anabios13.appforcarsales.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person,Integer> {
    List<Person> findByNameContaining(String name);

    Optional<Person> findByName(String username);
}
