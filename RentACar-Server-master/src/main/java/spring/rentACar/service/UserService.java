package spring.rentACar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.User;
import spring.rentACar.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserServiceIterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findOne(Integer userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User users) {
        return userRepository.save(users);
    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> searchUsers(String name, String username, boolean enable, int pageNum) {
        return userRepository.searchUser(name,username,enable,new PageRequest(pageNum,5));
    }

    @Override
    public Page<User> findAll(int pageNum) {
        return userRepository.findAll(new PageRequest(pageNum,5));
    }
}
