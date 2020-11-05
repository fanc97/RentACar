package spring.rentACar.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.CarNameDTO;
import spring.rentACar.dto.ModelDTO;
import spring.rentACar.entity.CarName;
import spring.rentACar.entity.Model;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarNameToCarNameDTO implements Converter<CarName, CarNameDTO> {

    @Override
    public CarNameDTO convert(CarName source) {
        CarNameDTO dto = new CarNameDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }

    public List<CarNameDTO> convert(List<CarName> names){
        List<CarNameDTO>dtos = new ArrayList<>();
        for(CarName m : names){
            dtos.add(convert(m));
        }
        return dtos;
    }
}
