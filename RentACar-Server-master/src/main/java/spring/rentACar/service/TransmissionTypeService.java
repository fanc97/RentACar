package spring.rentACar.service;

import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.TransmissionType;

import java.util.List;

public interface TransmissionTypeService {
    List<TransmissionType> findAll();
    void save(TransmissionType transmissionType);
    TransmissionType findOne(Long id);
    void delete(TransmissionType transmissionType);
}
