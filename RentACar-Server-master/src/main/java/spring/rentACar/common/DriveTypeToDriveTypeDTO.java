package spring.rentACar.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.DriveTypeDTO;
import spring.rentACar.dto.FuelTypeDTO;
import spring.rentACar.entity.DriveType;
import spring.rentACar.entity.FuelType;

import java.util.ArrayList;
import java.util.List;

@Component
public class DriveTypeToDriveTypeDTO implements Converter<DriveType, DriveTypeDTO> {
    @Override
    public DriveTypeDTO convert(DriveType source) {
        DriveTypeDTO dto = new DriveTypeDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }

    public List<DriveTypeDTO> convert(List<DriveType> bodys){
        List<DriveTypeDTO>dtos = new ArrayList<>();
        for(DriveType m : bodys){
            dtos.add(convert(m));
        }
        return dtos;
    }
}
