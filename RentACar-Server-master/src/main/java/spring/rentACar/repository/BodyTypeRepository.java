package spring.rentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.rentACar.entity.BodyType;

@Repository
public interface BodyTypeRepository extends JpaRepository<BodyType, Long> {
}
