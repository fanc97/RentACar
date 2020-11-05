package spring.rentACar.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.ManufacturerDTO;
import spring.rentACar.dto.ModelDTO;
import spring.rentACar.entity.Manufacturer;
import spring.rentACar.entity.Model;

import javax.persistence.Convert;
import java.util.ArrayList;
import java.util.List;
@Component
public class ManufacturerToManufacturerDTO implements Converter<Manufacturer, ManufacturerDTO> {
    @Override
    public ManufacturerDTO convert(Manufacturer source) {
        ManufacturerDTO dto = new ManufacturerDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }

    public List<ManufacturerDTO> convert(List<Manufacturer> bodys){
        List<ManufacturerDTO>dtos = new ArrayList<>();
        for(Manufacturer m : bodys){
            dtos.add(convert(m));
        }
        return dtos;
    }
}
