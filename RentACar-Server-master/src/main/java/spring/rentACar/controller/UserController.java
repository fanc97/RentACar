package spring.rentACar.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.rentACar.common.UserDTOToUser;
import spring.rentACar.common.UserToUserDTO;
import spring.rentACar.dto.RentDTO;
import spring.rentACar.dto.UserDTO;
import spring.rentACar.entity.Authority;
import spring.rentACar.entity.Rent;
import spring.rentACar.entity.User;
import spring.rentACar.service.AuthorityServiceInterface;
import spring.rentACar.service.UserServiceIterface;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin("*")
public class UserController {


    @Autowired
    UserServiceIterface userServiceIterface;

    @Autowired
    AuthorityServiceInterface authorityServiceInterface;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserToUserDTO toDTO;

    @Autowired
    UserDTOToUser toUser;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>>getUsers(@RequestParam(defaultValue="0") int pageNum){
        Page<User> users = userServiceIterface.findAll(pageNum);
        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(users.getTotalPages()) );
        headers.add("access-control-expose-headers","totalPages");
//        List<Car> cars = carService.findAll();
        return new ResponseEntity<>(toDTO.convert(users.getContent()),headers, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>>search(@RequestParam String name,
                                               @RequestParam String username,
                                               @RequestParam boolean enable,
                                               @RequestParam(defaultValue="0") int pageNum){

        Page<User> users = userServiceIterface.searchUsers(name,username,enable,pageNum);

        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(users.getTotalPages()) );
        headers.add("access-control-expose-headers","totalPages");
        return new ResponseEntity<>(toDTO.convert(users.getContent()),headers,HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO>getUser(@PathVariable("id") Integer id){
        User user=userServiceIterface.findOne(id);
        if(user ==null)
            return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
        return  new ResponseEntity<UserDTO>(new UserDTO(user),HttpStatus.OK);
    }


    @GetMapping(value = "/allUsername")
    public ResponseEntity<List<String>> allUsernames(){
        List<User> allUsers=userServiceIterface.findAll();
        List<String>usernames=new ArrayList<>();
        for (User u : allUsers) {
            usernames.add(u.getUsername());
        }

        return new ResponseEntity<List<String>>(usernames,HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO>saveUserProfile(@RequestParam("user")String user,@RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, IOException {

        UserDTO person = new ObjectMapper().readValue(user,UserDTO.class);

        person.setPhoto(file.getBytes());
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        User dbPerson = userServiceIterface.save(toUser.convert(person));
        if(dbPerson!=null){
            return new ResponseEntity<>(toDTO.convert(dbPerson),HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO>editUser(@RequestBody UserDTO userDTO,@PathVariable("id") Integer id){
        if(!id.equals(userDTO.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = toUser.convert(userDTO);
        userServiceIterface.save(user);
        return new ResponseEntity<>(toDTO.convert(user),HttpStatus.OK);

    }
    @RequestMapping(value = "block/{id}",method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTO>block(@RequestBody UserDTO userDTO,@PathVariable("id") Integer id){
        if(!id.equals(userDTO.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = toUser.convert(userDTO);
        userServiceIterface.save(user);
        return new ResponseEntity<>(toDTO.convert(user),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void>deleteUser(@PathVariable("id")Integer id){
        User user=userServiceIterface.findOne(id);
        if(user != null)
        {
            userServiceIterface.remove(id);
            return  new ResponseEntity<Void>(HttpStatus.OK);

        }
        return  new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
}
