package spring.rentACar.dto;

import spring.rentACar.entity.Manufacturer;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class ModelDTO {
    private Long id;
    private String name;
    private int manufacturerId;
    private String manufacturerName;

    public ModelDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
