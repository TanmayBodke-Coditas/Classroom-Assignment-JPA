package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
    private List<Animal> animals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Zoo() {
    }

    public Zoo(String name, String city, List<Animal> animals) {
        this.name = name;
        this.city = city;
        this.animals = animals;
    }
}
