package by.anabios13.appforcarsales.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

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
    @Min(value =18, message="You must older than 18")
    @Max(value =130, message="You mast be younger than 130")
    @Column(name = "age")
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
