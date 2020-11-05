package spring.rentACar.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    void save(Car car);
    Car findOne(Long id);
    void delete(Car car);
    Page<Car> searchCar(
            @Param("bodyType") String bodyType,
            @Param("name") String name,
            @Param("model") String model,
            @Param("minPrice") int minPrice,
            @Param("maxPrice") int maxPrice,
            int pageNum
    );
    Page<Car> searchCar5(
            @Param("bodyType") String bodyType,
            @Param("name") String name,
            @Param("model") String model,
            @Param("minPrice") int minPrice,
            @Param("maxPrice") int maxPrice,
            int pageNum
    );
    Page<Car> findAll(int pageNum);
    Page<Car> findAll5(int pageNum);
}
