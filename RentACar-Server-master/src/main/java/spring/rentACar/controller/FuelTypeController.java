package spring.rentACar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.rentACar.common.BodyTypeToBodyTypeDTO;
import spring.rentACar.common.FuelTypeToFuelTypeDTO;
import spring.rentACar.dto.BodyTypeDTO;
import spring.rentACar.dto.FuelTypeDTO;
import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.FuelType;
import spring.rentACar.service.BodyTypeService;
import spring.rentACar.service.FuelTypeService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api/fuelType")
public class FuelTypeController {

    @Autowired
    private FuelTypeService service;
    @Autowired
    private FuelTypeToFuelTypeDTO toDTO;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FuelTypeDTO>> findAll(){
        List<FuelType> bodys = service.findAll();
        return new ResponseEntity<>(toDTO.convert(bodys), HttpStatus.OK);
    }
}
