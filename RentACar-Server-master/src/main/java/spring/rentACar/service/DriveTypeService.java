package spring.rentACar.service;

import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.DriveType;

import java.util.List;

public interface DriveTypeService {
    List<DriveType> findAll();
    void save(DriveType driveType);
    DriveType findOne(Long id);
    void delete(DriveType driveType);
}
