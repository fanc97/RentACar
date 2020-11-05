package spring.rentACar.service;

import spring.rentACar.entity.BodyType;

import java.util.List;

public interface BodyTypeService {
    List<BodyType> findAll();
    void save(BodyType bodyType);
    BodyType findOne(Long id);
    void delete(BodyType bodyType);
}
