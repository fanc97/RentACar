package spring.rentACar.common;

import org.hibernate.annotations.Cache;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.BodyTypeDTO;
import spring.rentACar.dto.TransmissionTypeDTO;
import spring.rentACar.entity.BodyType;
import spring.rentACar.entity.TransmissionType;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransmissionTypeToTransmissionTypeDTO implements Converter<TransmissionType, TransmissionTypeDTO> {
    @Override
    public TransmissionTypeDTO convert(TransmissionType source) {
        TransmissionTypeDTO dto = new TransmissionTypeDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }

    public List<TransmissionTypeDTO> convert(List<TransmissionType> bodys){
        List<TransmissionTypeDTO>dtos = new ArrayList<>();
        for(TransmissionType m : bodys){
            dtos.add(convert(m));
        }
        return dtos;
    }
}
