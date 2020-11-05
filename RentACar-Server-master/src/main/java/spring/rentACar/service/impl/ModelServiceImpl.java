package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.Model;
import spring.rentACar.repository.CarRepository;
import spring.rentACar.repository.ModelRepository;
import spring.rentACar.service.ModelService;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository repository;
    @Override
    public List<Model> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Model model) {
        repository.save(model);
    }

    @Override
    public Model findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(Model model) {
        repository.delete(model);
    }
}
