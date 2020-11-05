package spring.rentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.rentACar.entity.CarName;

@Repository
public interface CarNameRepository extends JpaRepository<CarName,Long> {
}
