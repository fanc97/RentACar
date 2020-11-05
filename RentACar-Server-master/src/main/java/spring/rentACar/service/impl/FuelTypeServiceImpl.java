package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.FuelType;
import spring.rentACar.repository.CarRepository;
import spring.rentACar.repository.FuelTypeRepository;
import spring.rentACar.service.FuelTypeService;

import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {
    @Autowired
    private FuelTypeRepository repository;
    @Override
    public List<FuelType> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(FuelType fuelType) {
        repository.save(fuelType);
    }

    @Override
    public FuelType findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(FuelType fuelType) {
        repository.delete(fuelType);
    }
}
