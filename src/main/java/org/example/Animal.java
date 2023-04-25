package org.example;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private int age;
    private LocalDate admissionDate;

    private String origin;


    @ManyToOne
    private Zoo zoo;

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Animal(String name, String type, int age, LocalDate admissionDate, String origin) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.admissionDate = admissionDate;
        this.origin = origin;
      //  this.zoo = zoo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Animal(String name, String type, LocalDate admissionDate, String origin) {
        this.name = name;
        this.type = type;
        this.admissionDate = admissionDate;
        this.origin = origin;
    }

    public Animal() {
    }

    public Animal(String name, String type, LocalDate admissionDate, String origin, Zoo zoo) {
        this.name = name;
        this.type = type;
        this.admissionDate = admissionDate;
        this.origin = origin;
        this.zoo = zoo;
    }
}
