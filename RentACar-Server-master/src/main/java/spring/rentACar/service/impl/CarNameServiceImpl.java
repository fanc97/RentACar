package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.CarName;
import spring.rentACar.repository.BodyTypeRepository;
import spring.rentACar.repository.CarNameRepository;
import spring.rentACar.service.CarNameService;

import java.util.List;

@Service
public class CarNameServiceImpl implements CarNameService {
    @Autowired
    private CarNameRepository repository;
    @Override
    public List<CarName> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(CarName carName) {
        repository.save(carName);
    }

    @Override
    public CarName findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(CarName carName) {
        repository.delete(carName);
    }
}
