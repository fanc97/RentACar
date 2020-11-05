package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.Car;
import spring.rentACar.repository.CarRepository;
import spring.rentACar.service.CarService;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository repository;
    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Car car) {
        repository.save(car);
    }

    @Override
    public Car findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(Car car) {
        repository.delete(car);
    }


    @Override
    public Page<Car> searchCar(String bodyType, String name, String model, int minPrice, int maxPrice,int pageNum) {
        return repository.searchCar(bodyType,name,model,minPrice,maxPrice,new PageRequest(pageNum,3));
    }

    @Override
    public Page<Car> searchCar5(String bodyType, String name, String model, int minPrice, int maxPrice, int pageNum) {
        return repository.searchCar(bodyType,name,model,minPrice,maxPrice,new PageRequest(pageNum,5));
    }

    @Override
    public Page<Car> findAll(int pageNum) {
        return repository.findAll(new PageRequest(pageNum,3));
    }

    @Override
    public Page<Car> findAll5(int pageNum) {
        return repository.findAll(new PageRequest(pageNum,5));
    }
}
