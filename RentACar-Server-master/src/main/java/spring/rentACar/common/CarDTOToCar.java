package spring.rentACar.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.CarDTO;
import spring.rentACar.entity.*;
import spring.rentACar.service.*;


@Component
public class CarDTOToCar implements Converter<CarDTO, Car> {
    @Autowired
    private CarService carService;
    @Autowired
    private BodyTypeService bodyTypeService;
    @Autowired
    private TransmissionTypeService transmissionTypeService;
    @Autowired
    private DriveTypeService driveTypeService;
    @Autowired
    private FuelTypeService fuelTypeService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private CarNameService carNameService;
    @Autowired
    private ManufacturerService manufacturerService;
    @Override
    public Car convert(CarDTO source) {
        Car car;
        BodyType bodyType = bodyTypeService.findOne(source.getBodyTypeId());
        TransmissionType transmissionType = transmissionTypeService.findOne(source.getTransmissionTypeId());
        DriveType driveType = driveTypeService.findOne(source.getDriveTypeId());
        FuelType fuelType = fuelTypeService.findOne(source.getFuelTypeId());
        CarName carName = carNameService.findOne(source.getCarNameId());
        Model model = modelService.findOne(source.getModelId());
        Manufacturer manufacturer = manufacturerService.findOne(source.getManufacturerId());
        if(source.getId()==null){
            car = new Car();
        }else{
            car = carService.findOne(source.getId());
        }
        model.setManufacturer(manufacturer);
        car.setId(source.getId());
        car.setDescription(source.getDescription());
        car.setEngineVolume(source.getEngineVolume());
        car.setEnginePower(source.getEnginePower());
        car.setSeats(source.getSeats());
        car.setDoors(source.getDoors());
        car.setPricePerDay(source.getPricePerDay());
        car.setBodyType(bodyType);
        car.setDriveType(driveType);
        car.setModel(model);
        car.setTransmissionType(transmissionType);
        car.setFuelType(fuelType);
        car.setCarName(carName);
        car.setPhoto(source.getPhoto());
        return car;
    }
}
