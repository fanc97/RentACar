package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.DriveType;
import spring.rentACar.repository.CarRepository;
import spring.rentACar.repository.DriveTypeRepository;
import spring.rentACar.service.DriveTypeService;

import java.util.List;

@Service
public class DriveTypeServiceImpl implements DriveTypeService {
    @Autowired
    private DriveTypeRepository repository;
    @Override
    public List<DriveType> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(DriveType driveType) {
        repository.save(driveType);
    }

    @Override
    public DriveType findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(DriveType driveType) {
        repository.delete(driveType);
    }
}
