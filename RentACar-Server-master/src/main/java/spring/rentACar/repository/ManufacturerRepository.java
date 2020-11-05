package spring.rentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.rentACar.entity.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
