package spring.rentACar.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.rentACar.entity.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent,Long> {
    @Query("SELECT r FROM Rent r WHERE "
            + "(:name IS NULL or r.user.name like :userName ) AND "
            + "(:bodyType IS NULL or r.car.bodyType.name like :bodyType ) AND "
            + "(:name IS NULL or r.car.carName.name like :name ) AND "
            + "(:name IS NULL or r.car.model.name like :model )"
    )
    Page<Rent> searchRent(String userName, String bodyType, String name, String model, Pageable pageable);
}
