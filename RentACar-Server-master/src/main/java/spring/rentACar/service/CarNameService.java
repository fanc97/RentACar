package spring.rentACar.service;


import spring.rentACar.entity.CarName;

import java.util.List;

public interface CarNameService {
    List<CarName> findAll();
    void save(CarName carName);
    CarName findOne(Long id);
    void delete(CarName carName);
}
