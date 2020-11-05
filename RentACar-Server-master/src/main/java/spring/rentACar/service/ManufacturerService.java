package spring.rentACar.service;

import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findAll();
    void save(Manufacturer manufacturer);
    Manufacturer findOne(Long id);
    void delete(Manufacturer manufacturer);
}
