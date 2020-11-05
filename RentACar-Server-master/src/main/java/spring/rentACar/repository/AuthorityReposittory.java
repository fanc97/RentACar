package spring.rentACar.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import spring.rentACar.entity.Authority;

public interface AuthorityReposittory extends JpaRepository<Authority,Integer> {

    Authority findByName(String name);
}
