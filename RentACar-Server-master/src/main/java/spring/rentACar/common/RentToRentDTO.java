package spring.rentACar.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.RentDTO;
import spring.rentACar.entity.Rent;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentToRentDTO implements Converter<Rent, RentDTO> {
    @Override
    public RentDTO convert(Rent source) {
        RentDTO dto = new RentDTO();
        dto.setId(source.getId());
        dto.setToDate(source.getToDate());
        dto.setTotalPrice(source.getTotalPrice());
        dto.setFromDate(source.getFromDate());
        dto.setUserId((long)source.getUser().getId());
        dto.setUserName(source.getUser().getName());
        dto.setCarId(source.getCar().getId());
        dto.setDescription(source.getCar().getDescription());
        dto.setEngineVolume(source.getCar().getEngineVolume());
        dto.setEnginePower(source.getCar().getEnginePower());
        dto.setSeats(source.getCar().getSeats());
        dto.setDoors(source.getCar().getDoors());
        dto.setPricePerDay(source.getCar().getPricePerDay());
        dto.setBodyTypeId(source.getCar().getBodyType().getId());
        dto.setManufacturerId(source.getCar().getModel().getManufacturer().getId());
        dto.setManufacturerName(source.getCar().getModel().getManufacturer().getName());
        dto.setModelId(source.getCar().getModel().getId());
        dto.setModelName(source.getCar().getModel().getName());
        dto.setTransmissionTypeId(source.getCar().getTransmissionType().getId());
        dto.setTransmissionTypeName(source.getCar().getTransmissionType().getName());
        dto.setGearNumber(source.getCar().getTransmissionType().getGearNumber());
        dto.setDriveTypeId(source.getCar().getDriveType().getId());
        dto.setDriveTypeName(source.getCar().getDriveType().getName());
        dto.setBodyTypeName(source.getCar().getBodyType().getName());
        dto.setFuelTypeId(source.getCar().getFuelType().getId());
        dto.setFuelTypeName(source.getCar().getFuelType().getName());
        dto.setCarNameId(source.getCar().getCarName().getId());
        dto.setCarNameName(source.getCar().getCarName().getName());
        return dto;
    }
    public List<RentDTO>convert(List<Rent> rents){
        List<RentDTO> dtos = new ArrayList<>();
        for(Rent r:rents){
            dtos.add(convert(r));
        }
        return dtos;
    }
}
