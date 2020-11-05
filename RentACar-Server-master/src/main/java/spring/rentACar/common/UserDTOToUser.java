package spring.rentACar.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.UserDTO;
import spring.rentACar.entity.Authority;
import spring.rentACar.entity.User;
import spring.rentACar.service.AuthorityServiceInterface;
import spring.rentACar.service.UserServiceIterface;

@Component
public class UserDTOToUser implements Converter<UserDTO, User> {

    @Autowired
    UserServiceIterface userServiceIterface;
    @Autowired
    AuthorityServiceInterface authorityServiceInterface;
    @Override
    public User convert(UserDTO source) {
        Authority authority=authorityServiceInterface.findByName("ROLE_USER");
        User user;
        if(source.getId()==null){
            user=new User();
        }else{
            user=userServiceIterface.findOne(source.getId());
        }
        user.setId(source.getId());
        user.setName(source.getName());
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        user.setPhoto(source.getPhoto());
        user.setEnable(source.isEnable());
        if(user.getUserAuthority().size() >0) {
            user.getUserAuthority().clear();
            user.getUserAuthority().add(authority);
        }else{
            user.getUserAuthority().add(authority);

        }
        return user;
    }
}
