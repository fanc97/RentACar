package spring.rentACar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.rentACar.common.RentDTOToRent;
import spring.rentACar.common.RentToRentDTO;
import spring.rentACar.dto.CarDTO;
import spring.rentACar.dto.RentDTO;
import spring.rentACar.entity.Car;
import spring.rentACar.entity.Rent;
import spring.rentACar.service.RentService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/rent")
public class RentController {
    @Autowired
    private RentService rentService;

    @Autowired
    private RentDTOToRent toRent;

    @Autowired
    private RentToRentDTO toDTO;
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RentDTO>> findAll(@RequestParam(defaultValue="0") int pageNum){
        Page<Rent> rent = rentService.findAll(pageNum);
        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(rent.getTotalPages()) );
        headers.add("access-control-expose-headers","totalPages");
//        List<Car> cars = carService.findAll();
        return new ResponseEntity<>(toDTO.convert(rent.getContent()),headers, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<RentDTO> delete(@PathVariable Long id){
        Rent rent = rentService.findOne(id);
        if(rent!=null){
            rentService.delete(rent);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(toDTO.convert(rent),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RentDTO> save(@Validated @RequestBody RentDTO rentDTO){
        Rent rent = toRent.convert(rentDTO);
        rentService.save(rent);
        return new ResponseEntity<>(toDTO.convert(rent),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RentDTO>edit(@PathVariable Long id,@Validated @RequestBody RentDTO rentDTO){
        if(!id.equals(rentDTO.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Rent rent = toRent.convert(rentDTO);
        rentService.save(rent);
        return new ResponseEntity<>(toDTO.convert(rent),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ResponseEntity<List<RentDTO>>search(@RequestParam String userName,
                                              @RequestParam String bodyType,
                                              @RequestParam String name,
                                              @RequestParam String model,
                                              @RequestParam(defaultValue="0") int pageNum){

        Page<Rent> rents = rentService.searchRent(userName,bodyType,name,model,pageNum);

        HttpHeaders headers = new HttpHeaders();
        headers.add("totalPages", Integer.toString(rents.getTotalPages()) );
        headers.add("access-control-expose-headers","totalPages");
        return new ResponseEntity<>(toDTO.convert(rents.getContent()),headers,HttpStatus.OK);

    }
}
