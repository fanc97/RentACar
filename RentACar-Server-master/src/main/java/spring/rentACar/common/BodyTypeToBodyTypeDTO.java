package spring.rentACar.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.BodyTypeDTO;
import spring.rentACar.dto.ModelDTO;
import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.Model;

import java.util.ArrayList;
import java.util.List;

@Component
public class BodyTypeToBodyTypeDTO implements Converter<BodyType, BodyTypeDTO> {
    @Override
    public BodyTypeDTO convert(BodyType source) {
        BodyTypeDTO dto = new BodyTypeDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }

    public List<BodyTypeDTO> convert(List<BodyType> bodys){
        List<BodyTypeDTO>dtos = new ArrayList<>();
        for(BodyType m : bodys){
            dtos.add(convert(m));
        }
        return dtos;
    }
}
