package spring.rentACar.dto;

import java.util.Date;

public class CarDTO {
    private Long id;
    private String description;
    private int engineVolume;
    private int enginePower;
    private int seats;
    private int doors;
    private int pricePerDay;
    private Long bodyTypeId;
    private String bodyTypeName;
    private Long manufacturerId;
    private String manufacturerName;
    private Long modelId;
    private String modelName;
    private Long transmissionTypeId;
    private String transmissionTypeName;
    private int gearNumber;
    private Long driveTypeId;
    private String driveTypeName;
    private Long fuelTypeId;
    private String fuelTypeName;
    private Long carNameId;
    private String carNameName;

    private byte[] photo;

    private Long rentId;
    private Date rentFromDate;
    private Date rentToDate;

    public CarDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarNameId() {
        return carNameId;
    }

    public void setCarNameId(Long carNameId) {
        this.carNameId = carNameId;
    }

    public String getCarNameName() {
        return carNameName;
    }

    public void setCarNameName(String carNameName) {
        this.carNameName = carNameName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Long getBodyTypeId() {
        return bodyTypeId;
    }

    public void setBodyTypeId(Long bodyTypeId) {
        this.bodyTypeId = bodyTypeId;
    }

    public String getBodyTypeName() {
        return bodyTypeName;
    }

    public void setBodyTypeName(String bodyTypeName) {
        this.bodyTypeName = bodyTypeName;
    }


    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Long getTransmissionTypeId() {
        return transmissionTypeId;
    }

    public void setTransmissionTypeId(Long transmissionTypeId) {
        this.transmissionTypeId = transmissionTypeId;
    }

    public String getTransmissionTypeName() {
        return transmissionTypeName;
    }

    public void setTransmissionTypeName(String transmissionTypeName) {
        this.transmissionTypeName = transmissionTypeName;
    }

    public Long getDriveTypeId() {
        return driveTypeId;
    }

    public void setDriveTypeId(Long driveTypeId) {
        this.driveTypeId = driveTypeId;
    }

    public String getDriveTypeName() {
        return driveTypeName;
    }

    public void setDriveTypeName(String driveTypeName) {
        this.driveTypeName = driveTypeName;
    }

    public Long getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelTypeName() {
        return fuelTypeName;
    }

    public void setFuelTypeName(String fuelTypeName) {
        this.fuelTypeName = fuelTypeName;
    }

    public int getGearNumber() {
        return gearNumber;
    }

    public void setGearNumber(int gearNumber) {
        this.gearNumber = gearNumber;
    }

    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }

    public Date getRentFromDate() {
        return rentFromDate;
    }

    public void setRentFromDate(Date rentFromDate) {
        this.rentFromDate = rentFromDate;
    }

    public Date getRentToDate() {
        return rentToDate;
    }

    public void setRentToDate(Date rentToDate) {
        this.rentToDate = rentToDate;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
