package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.Manufacturer;
import spring.rentACar.repository.CarRepository;
import spring.rentACar.repository.ManufacturerRepository;
import spring.rentACar.service.ManufacturerService;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Autowired
    private ManufacturerRepository repository;
    @Override
    public List<Manufacturer> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Manufacturer manufacturer) {
        repository.save(manufacturer);
    }

    @Override
    public Manufacturer findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        repository.delete(manufacturer);
    }
}
