package spring.rentACar.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.rentACar.entity.Car;


@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("SELECT c FROM Car c WHERE "
            + "(:bodyType IS NULL or c.bodyType.name like :bodyType ) AND "
            + "(:name IS NULL or c.carName.name like :name ) AND "
            + "(:name IS NULL or c.model.name like :model ) AND "
            + "(:maxPrice IS NULL OR c.pricePerDay <= :maxPrice) AND"
            + "(:minPrice IS NULL OR c.pricePerDay >= :minPrice)"
    )
//    @Query("select c from Car c where bodyType like %?1% and name like %?2% and pricePerDay  %?3% and pricePerDay >= %?4% ")
    Page<Car> searchCar(
            @Param("bodyType") String bodyType,
            @Param("name") String name,
            @Param("model") String model,
            @Param("minPrice") int minPrice,
            @Param("maxPrice") int maxPrice,
            Pageable pageable
            );

}
