package com.example.workshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Operation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String carName;
    private String mileage;
    private String description;

    public Operation() {
    }

    public Operation(String carName, String mileage, String description) {
        this.carName = carName;
        this.mileage = mileage;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", mileage='" + mileage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
