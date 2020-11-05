package spring.rentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.rentACar.entity.FuelType;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType,Long> {
}
