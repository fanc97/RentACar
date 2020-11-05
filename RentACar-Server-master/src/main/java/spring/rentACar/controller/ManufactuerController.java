package spring.rentACar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.rentACar.common.ManufacturerToManufacturerDTO;
import spring.rentACar.common.TransmissionTypeToTransmissionTypeDTO;
import spring.rentACar.dto.ManufacturerDTO;
import spring.rentACar.dto.TransmissionTypeDTO;
import spring.rentACar.entity.Manufacturer;
import spring.rentACar.entity.TransmissionType;
import spring.rentACar.service.ManufacturerService;
import spring.rentACar.service.TransmissionTypeService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api/manufacturer")
public class ManufactuerController {
    @Autowired
    private ManufacturerService service;
    @Autowired
    private ManufacturerToManufacturerDTO toDTO;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ManufacturerDTO>> findAll(){
        List<Manufacturer> bodys = service.findAll();
        return new ResponseEntity<>(toDTO.convert(bodys), HttpStatus.OK);
    }
}
