package spring.rentACar.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import spring.rentACar.dto.RentDTO;
import spring.rentACar.entity.*;
import spring.rentACar.service.*;

@Component
public class RentDTOToRent implements Converter<RentDTO, Rent> {
    @Autowired
    private RentService rentService;
    @Autowired
    private CarService carService;
    @Autowired
    private UserServiceIterface userServiceIterface;
    @Override
    public Rent convert(RentDTO source) {
        Rent rent;
        Car car = carService.findOne(source.getCarId());
        User user = userServiceIterface.findOne(source.getUserId().intValue());
        if(source.getId()==null){
            rent = new Rent();
        }else{
            rent = rentService.findOne(source.getId());
        }
        rent.setCar(car);
        rent.setUser(user);
        rent.setFromDate(source.getFromDate());
        rent.setId(source.getId());
        rent.setToDate(source.getToDate());
        rent.setTotalPrice(source.getTotalPrice());
        return rent;
    }
}
