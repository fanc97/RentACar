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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.rentACar.common.CarDTOToCar;
import spring.rentACar.common.CarToCarDTO;
import spring.rentACar.dto.CarDTO;
import spring.rentACar.dto.UserDTO;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.User;
import spring.rentACar.service.CarService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "api/cars")
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarDTOToCar toCar;
    @Autowired
    private CarToCarDTO toDTO;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<CarDTO> getOne(@PathVariable Long id){
        Car car = carService.findOne(id);
        if(car!=null) {
            return new ResponseEntity<>(toDTO.convert(car), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CarDTO>>findAll(@RequestParam(defaultValue="0") int pageNum){
        Page<Car> cars = carService.findAll(pageNum);
        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(cars.getTotalPages()) );
        headers.add("access-control-expose-headers","totalPages");
        return new ResponseEntity<>(toDTO.convert(cars.getContent()),headers,HttpStatus.OK);
    }
    @RequestMapping(value="/admin",method = RequestMethod.GET)
    public ResponseEntity<List<CarDTO>>findAll5(@RequestParam(defaultValue="0") int pageNum){
        Page<Car> cars = carService.findAll5(pageNum);
        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(cars.getTotalPages()) );
        headers.add("access-control-expose-headers","totalPages");
        return new ResponseEntity<>(toDTO.convert(cars.getContent()),headers,HttpStatus.OK);
    }
    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public ResponseEntity<List<CarDTO>>findAll(){
        List<Car> cars = carService.findAll();
        return new ResponseEntity<>(toDTO.convert(cars),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<CarDTO> delete(@PathVariable Long id){
        Car car = carService.findOne(id);
        if(car!=null){
            carService.delete(car);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(toDTO.convert(car),HttpStatus.OK);
    }




    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CarDTO>saveCar(@RequestParam("car")String cars, @RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, IOException {

        CarDTO car = new ObjectMapper().readValue(cars,CarDTO.class);

        car.setPhoto(file.getBytes());
        Car dbCar = toCar.convert(car);
        carService.save(toCar.convert(car));
        if(dbCar!=null){
            return new ResponseEntity<>(toDTO.convert(dbCar),HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<CarDTO>edit(@PathVariable Long id,@Validated @RequestBody CarDTO carDTO){
        if(!id.equals(carDTO.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Car car = toCar.convert(carDTO);
        carService.save(car);
        return new ResponseEntity<>(toDTO.convert(car),HttpStatus.OK);
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseEntity<List<CarDTO>>search(@RequestParam String bodyType,
                                           @RequestParam String name,
                                           @RequestParam String model,
                                           @RequestParam int minPrice,
                                           @RequestParam int maxPrice,
                                              @RequestParam(defaultValue="0") int pageNum){

        Page<Car> cars = carService.searchCar(bodyType,name,model,minPrice,maxPrice,pageNum);

        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(cars.getTotalPages()) );
        headers.add("access-control-expose-headers","totalPages");
        return new ResponseEntity<>(toDTO.convert(cars.getContent()),headers,HttpStatus.OK);

    }
    @RequestMapping(value = "/search5",method = RequestMethod.GET)
    public ResponseEntity<List<CarDTO>>search5(@RequestParam String bodyType,
                                              @RequestParam String name,
                                              @RequestParam String model,
                                              @RequestParam int minPrice,
                                              @RequestParam int maxPrice,
                                              @RequestParam(defaultValue="0") int pageNum){

        Page<Car> cars = carService.searchCar5(bodyType,name,model,minPrice,maxPrice,pageNum);

        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(cars.getTotalPages()) );
        headers.add("access-control-expose-headers","totalPages");
        return new ResponseEntity<>(toDTO.convert(cars.getContent()),headers,HttpStatus.OK);

    }

}
