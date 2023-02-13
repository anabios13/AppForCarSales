package by.anabios13.appforcarsales.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "car_blank")
public class CarBlank {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @ManyToOne
    @JoinColumn(name="person_id",referencedColumnName = "id")
    private Person owner;
    @NotEmpty(message = "car brand should not be empty")
    @Size(min=1,max=200,message = "Name should be between 1 and 199 characters")
    @Column(name = "name_of_car_blank")
    private String nameOfCarBlank;
    @Min(value =1768, message="Year Of Release should be later than 1768")
    @Column(name = "year_of_release")
    private int yearOfRelease;
    @NotEmpty(message = "description should not be empty")
    @Size(min=1,max=1500,message = "Name should be between 1 and 1500 characters")
    @Column(name = "description")
    private String description;
    @Min(value =1, message="Cost should be higher than 1")
    @Column(name = "cost")
    private int cost;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public CarBlank() {

    }

    public CarBlank(Person owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCarBlank() {
        return nameOfCarBlank;
    }

    public void setNameOfCarBlank(String nameOfCar) {
        this.nameOfCarBlank = nameOfCar;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
