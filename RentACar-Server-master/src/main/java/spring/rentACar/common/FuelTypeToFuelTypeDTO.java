package spring.rentACar.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.BodyTypeDTO;
import spring.rentACar.dto.FuelTypeDTO;
import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.FuelType;

import java.util.ArrayList;
import java.util.List;

@Component
public class FuelTypeToFuelTypeDTO implements Converter<FuelType, FuelTypeDTO> {
    @Override
    public FuelTypeDTO convert(FuelType source) {
        FuelTypeDTO dto = new FuelTypeDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }

    public List<FuelTypeDTO> convert(List<FuelType> bodys){
        List<FuelTypeDTO>dtos = new ArrayList<>();
        for(FuelType m : bodys){
            dtos.add(convert(m));
        }
        return dtos;
    }
}
