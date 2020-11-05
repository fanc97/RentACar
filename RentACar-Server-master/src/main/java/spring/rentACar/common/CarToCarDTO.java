package spring.rentACar.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.CarDTO;
import spring.rentACar.entity.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarToCarDTO implements Converter<Car, CarDTO> {
    @Override
    public CarDTO convert(Car source) {
        CarDTO dto = new CarDTO();
        dto.setId(source.getId());
        dto.setDescription(source.getDescription());
        dto.setEngineVolume(source.getEngineVolume());
        dto.setEnginePower(source.getEnginePower());
        dto.setSeats(source.getSeats());
        dto.setDoors(source.getDoors());
        dto.setPricePerDay(source.getPricePerDay());
        dto.setBodyTypeId(source.getBodyType().getId());
        dto.setManufacturerId(source.getModel().getManufacturer().getId());
        dto.setManufacturerName(source.getModel().getManufacturer().getName());
        dto.setModelId(source.getModel().getId());
        dto.setModelName(source.getModel().getName());
        dto.setTransmissionTypeId(source.getTransmissionType().getId());
        dto.setTransmissionTypeName(source.getTransmissionType().getName());
        dto.setGearNumber(source.getTransmissionType().getGearNumber());
        dto.setDriveTypeId(source.getDriveType().getId());
        dto.setDriveTypeName(source.getDriveType().getName());
        dto.setBodyTypeName(source.getBodyType().getName());
        dto.setFuelTypeId(source.getFuelType().getId());
        dto.setFuelTypeName(source.getFuelType().getName());
        dto.setCarNameId(source.getCarName().getId());
        dto.setCarNameName(source.getCarName().getName());
        dto.setPhoto(source.getPhoto());

        return dto;
    }
    public List<CarDTO> convert(List<Car> cars){
        List<CarDTO> dtos = new ArrayList<>();
        for(Car c : cars){
            dtos.add(convert(c));
        }
        return dtos;
    }
}
