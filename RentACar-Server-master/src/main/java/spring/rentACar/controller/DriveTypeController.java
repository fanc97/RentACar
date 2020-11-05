package spring.rentACar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.rentACar.common.DriveTypeToDriveTypeDTO;
import spring.rentACar.common.FuelTypeToFuelTypeDTO;
import spring.rentACar.dto.DriveTypeDTO;
import spring.rentACar.dto.FuelTypeDTO;
import spring.rentACar.entity.DriveType;
import spring.rentACar.entity.FuelType;
import spring.rentACar.service.DriveTypeService;
import spring.rentACar.service.FuelTypeService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api/driveType")
public class DriveTypeController {
    @Autowired
    private DriveTypeService service;
    @Autowired
    private DriveTypeToDriveTypeDTO toDTO;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DriveTypeDTO>> findAll(){
        List<DriveType> bodys = service.findAll();
        return new ResponseEntity<>(toDTO.convert(bodys), HttpStatus.OK);
    }
}
