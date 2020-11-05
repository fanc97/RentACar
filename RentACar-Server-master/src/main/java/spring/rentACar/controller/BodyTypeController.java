package spring.rentACar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.rentACar.common.BodyTypeToBodyTypeDTO;
import spring.rentACar.dto.BodyTypeDTO;
import spring.rentACar.entity.BodyType;
import spring.rentACar.service.BodyTypeService;


import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping(value="api/bodyType")
public class BodyTypeController {
    @Autowired
    private BodyTypeService bodyTypeService;
    @Autowired
    private BodyTypeToBodyTypeDTO toDTO;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BodyTypeDTO>> findAll(){
        List<BodyType> bodys = bodyTypeService.findAll();
        return new ResponseEntity<>(toDTO.convert(bodys), HttpStatus.OK);
    }
}
