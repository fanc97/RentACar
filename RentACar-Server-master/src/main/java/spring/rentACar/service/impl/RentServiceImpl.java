package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.Rent;
import spring.rentACar.repository.CarRepository;
import spring.rentACar.repository.RentRepository;
import spring.rentACar.service.RentService;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentRepository repository;
    @Override
    public List<Rent> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Rent rent) {
        repository.save(rent);
    }

    @Override
    public Rent findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(Rent rent) {
        repository.delete(rent);
    }


    @Override
    public Page<Rent> findAll(int pageNum) {
        return repository.findAll(new PageRequest(pageNum,5));
    }

    @Override
    public Page<Rent> searchRent(String userName, String bodyType, String name, String model, int pageNum) {
        return repository.searchRent(userName,bodyType,name,model,new PageRequest(pageNum,5));
    }

}
