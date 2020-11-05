package spring.rentACar.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.FuelTypeDTO;
import spring.rentACar.dto.ModelDTO;
import spring.rentACar.entity.FuelType;
import spring.rentACar.entity.Model;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelToModelDTO implements Converter<Model, ModelDTO> {
    @Override
    public ModelDTO convert(Model source) {
        ModelDTO dto = new ModelDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }

    public List<ModelDTO> convert(List<Model> bodys){
        List<ModelDTO>dtos = new ArrayList<>();
        for(Model m : bodys){
            dtos.add(convert(m));
        }
        return dtos;
    }
}
