package spring.rentACar.dto;

import javax.persistence.Column;

public class FuelTypeDTO {
    private Long id;
    private String name;

    public FuelTypeDTO() {
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
}
