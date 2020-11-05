package spring.rentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.rentACar.entity.TransmissionType;

@Repository
public interface TransmissionTypeRepository extends JpaRepository<TransmissionType,Long> {
}
