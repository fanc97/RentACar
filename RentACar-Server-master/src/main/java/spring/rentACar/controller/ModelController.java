package spring.rentACar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.rentACar.common.FuelTypeToFuelTypeDTO;
import spring.rentACar.common.ModelToModelDTO;
import spring.rentACar.dto.FuelTypeDTO;
import spring.rentACar.dto.ModelDTO;
import spring.rentACar.entity.FuelType;
import spring.rentACar.entity.Model;
import spring.rentACar.service.FuelTypeService;
import spring.rentACar.service.ModelService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api/model")
public class ModelController {

    @Autowired
    private ModelService service;
    @Autowired
    private ModelToModelDTO toDTO;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ModelDTO>> findAll(){
        List<Model> bodys = service.findAll();
        return new ResponseEntity<>(toDTO.convert(bodys), HttpStatus.OK);
    }
}
