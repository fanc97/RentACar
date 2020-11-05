package spring.rentACar.service;



import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.User;

import java.util.List;

public interface UserServiceIterface {

    User findOne(Integer userId);

    User findByUsername(String username);

    List<User> findAll();

    User save(User users);

    void remove(Integer id);

    Page<User> searchUsers(
            @Param("name") String name,
            @Param("username") String username,
            @Param("model") boolean enable,
            int pageNum
    );
    Page<User> findAll(int pageNum);
}
