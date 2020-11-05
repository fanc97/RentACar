package spring.rentACar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.Rent;

import java.util.List;

public interface RentService {
    List<Rent> findAll();
    void save(Rent rent);
    Rent findOne(Long id);
    void delete(Rent rent);

    Page<Rent> findAll(int pageNum);

    Page<Rent> searchRent(
            @Param("userName") String userName,
            @Param("bodyType") String bodyType,
            @Param("name") String name,
            @Param("model") String model,
            int pageNum);

}

