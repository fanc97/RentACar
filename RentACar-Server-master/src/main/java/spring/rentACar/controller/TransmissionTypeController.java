package spring.rentACar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.rentACar.common.ModelToModelDTO;
import spring.rentACar.common.TransmissionTypeToTransmissionTypeDTO;
import spring.rentACar.dto.ModelDTO;
import spring.rentACar.dto.TransmissionTypeDTO;
import spring.rentACar.entity.Model;
import spring.rentACar.entity.TransmissionType;
import spring.rentACar.service.ModelService;
import spring.rentACar.service.TransmissionTypeService;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping(value="api/transmissionType")
public class TransmissionTypeController {
    @Autowired
    private TransmissionTypeService service;
    @Autowired
    private TransmissionTypeToTransmissionTypeDTO toDTO;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TransmissionTypeDTO>> findAll(){
        List<TransmissionType> bodys = service.findAll();
        return new ResponseEntity<>(toDTO.convert(bodys), HttpStatus.OK);
    }
}

