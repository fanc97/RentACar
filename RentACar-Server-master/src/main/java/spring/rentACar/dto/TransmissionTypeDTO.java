package spring.rentACar.dto;

import javax.persistence.Column;

public class TransmissionTypeDTO {
    private Long id;
    private String name;
    private int gearNumber;

    public TransmissionTypeDTO() {
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

    public int getGearNumber() {
        return gearNumber;
    }

    public void setGearNumber(int gearNumber) {
        this.gearNumber = gearNumber;
    }
}
