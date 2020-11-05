package spring.rentACar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.TransmissionType;
import spring.rentACar.repository.TransmissionTypeRepository;
import spring.rentACar.service.TransmissionTypeService;

import java.util.List;

@Service
public class TransmissionTypeServiceImpl implements TransmissionTypeService {
    @Autowired
    private TransmissionTypeRepository repository;
    @Override
    public List<TransmissionType> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(TransmissionType transmissionType) {
        repository.save(transmissionType);
    }

    @Override
    public TransmissionType findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public void delete(TransmissionType transmissionType) {
        repository.delete(transmissionType);
    }
}
