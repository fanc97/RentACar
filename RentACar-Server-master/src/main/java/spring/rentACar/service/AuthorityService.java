package spring.rentACar.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.rentACar.entity.Authority;
import spring.rentACar.repository.AuthorityReposittory;

@Service
public class AuthorityService implements AuthorityServiceInterface{

    @Autowired
    AuthorityReposittory authorityReposittory;
    @Override
    public Authority findByName(String name) {
        return authorityReposittory.findByName(name);
    }
}
