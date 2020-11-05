package spring.rentACar.service;

import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.Model;

import java.util.List;

public interface ModelService {
    List<Model> findAll();
    void save(Model model);
    Model findOne(Long id);
    void delete(Model model);
}
