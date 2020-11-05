package spring.rentACar.service;


import spring.rentACar.entity.Authority;

public interface AuthorityServiceInterface  {
    Authority findByName(String name);
}
