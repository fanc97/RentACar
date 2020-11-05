package spring.rentACar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.rentACar.common.CarNameToCarNameDTO;
import spring.rentACar.dto.CarNameDTO;
import spring.rentACar.entity.CarName;
import spring.rentACar.service.CarNameService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api/carNames")
public class CarNameController {
    @Autowired
    private CarNameService carNameService;
    @Autowired
    private CarNameToCarNameDTO toDTO;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CarNameDTO>> findAll(){
        List<CarName> carNames = carNameService.findAll();
        return new ResponseEntity<>(toDTO.convert(carNames), HttpStatus.OK);
    }
}
