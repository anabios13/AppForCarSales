package by.anabios13.appforcarsales.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<CarBlank> carBlanks;
    @NotEmpty(message = "name of person should not be empty")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "password should not be empty")
    @Column(name = "password")
    private String password;


    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Min(value = 1900, message = "Value must be more than 1900 year")
    @NotNull(message = "year of birth should not be empty")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CarBlank> getCarBlanks() {
        return carBlanks;
    }

    public void setCarBlanks(List<CarBlank> carBlanks) {
        this.carBlanks = carBlanks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int age) {
        this.yearOfBirth = age;
    }

    public Person() {
    }


    public Person(String name, int age) {
        this.name = name;
        this.yearOfBirth = age;
    }
}
