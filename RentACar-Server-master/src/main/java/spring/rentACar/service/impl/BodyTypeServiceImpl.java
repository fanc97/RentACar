package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.BodyType;
import spring.rentACar.repository.BodyTypeRepository;
import spring.rentACar.service.BodyTypeService;

import java.util.List;

@Service
public class BodyTypeServiceImpl implements BodyTypeService {

    @Autowired
    private BodyTypeRepository repository;
    @Override
    public List<BodyType> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(BodyType bodyType) {
        repository.save(bodyType);
    }

    @Override
    public BodyType findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(BodyType bodyType) {
        repository.delete(bodyType);
    }
}
