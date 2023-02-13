package by.anabios13.appforcarsales.services;

import by.anabios13.appforcarsales.models.CarBlank;
import by.anabios13.appforcarsales.repositories.CarBlankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CarBlankService {
    private final int blanksPerPage = 15;//amount blanks in the page
    private final CarBlankRepository carBlankRepository;

    @Autowired
    public CarBlankService(CarBlankRepository carRepository) {
        this.carBlankRepository = carRepository;
    }
//
    public List<CarBlank> findAll(Integer page) {
        return carBlankRepository.findAll(PageRequest.of(page,blanksPerPage,Sort.by("createdAt").descending())).getContent();
    }

//    public List<CarBlank> searchByName(String partOfNameTheBlank){
//        return carBlankRepository.findByNameOfCarBlankWith(partOfNameTheBlank);
//    }

    public CarBlank findOne(int id) {
        Optional<CarBlank> foundCarBlank = carBlankRepository.findById(id);
        return foundCarBlank.orElse(null);
    }

    @Transactional
    public void save(CarBlank carBlank){
        carBlank.setCreatedAt(new Date());
        carBlankRepository.save(carBlank);
    }

    @Transactional
    public void update(int id, CarBlank updatedCarBlank){
        updatedCarBlank.setId(id);
        carBlankRepository.save(updatedCarBlank);
    }

    @Transactional
    public void delete(int id){
        carBlankRepository.deleteById(id);
    }
}
