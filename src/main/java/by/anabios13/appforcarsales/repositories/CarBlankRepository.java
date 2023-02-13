package by.anabios13.appforcarsales.repositories;

import by.anabios13.appforcarsales.models.CarBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBlankRepository extends JpaRepository<CarBlank,Integer> {
}
