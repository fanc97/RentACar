package spring.rentACar.entity;


import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="description")
    private String description;
    @Column(name="engine_volume")
    private int engineVolume;
    @Column(name="engine_power")
    private int enginePower;
    @Column(name="seats")
    private int seats;
    @Column(name="doors")
    private int doors;
    @Column(name="price_per_day")
    private int pricePerDay;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private BodyType bodyType;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private Model model;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private TransmissionType transmissionType;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private DriveType driveType;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private FuelType fuelType;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private CarName carName;
    @OneToOne
    private Rent rent;

    @Lob
    @Column(name = "photo")
    private byte[] photo;
    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }


    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public DriveType getDriveType() {
        return driveType;
    }

    public void setDriveType(DriveType driveType) {
        this.driveType = driveType;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Model getModel() {
        return model;
    }

    public CarName getCarName() {
        return carName;
    }

    public void setCarName(CarName carName) {
        this.carName = carName;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
