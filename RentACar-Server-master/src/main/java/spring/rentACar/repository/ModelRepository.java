package spring.rentACar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.rentACar.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {
}
