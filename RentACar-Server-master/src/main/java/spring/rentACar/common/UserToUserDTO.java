package spring.rentACar.common;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.UserDTO;
import spring.rentACar.entity.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User source) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(source.getId());
        userDTO.setName(source.getName());
        userDTO.setUsername(source.getUsername());
        userDTO.setPassword(source.getPassword());
        userDTO.setPhoto(source.getPhoto());
        userDTO.setEnable(source.isEnabled());
        return userDTO;
    }
    public List<UserDTO> convert(List<User> users){
        List<UserDTO> dtos= new ArrayList<>();
        for(User u : users){
            dtos.add(convert(u));
        }
        return dtos;
    }
}
