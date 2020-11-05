package spring.rentACar.service;

import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.FuelType;

import java.util.List;

public interface FuelTypeService {
    List<FuelType> findAll();
    void save(FuelType fuelType);
    FuelType findOne(Long id);
    void delete(FuelType fuelType);
}
