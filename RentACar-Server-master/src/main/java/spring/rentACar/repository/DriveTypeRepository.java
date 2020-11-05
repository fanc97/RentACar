package spring.rentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.rentACar.entity.DriveType;

@Repository
public interface DriveTypeRepository extends JpaRepository<DriveType,Long> {
}
