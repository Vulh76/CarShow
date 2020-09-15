package ru.sbt.carshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sbt.cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;
    @Column(name = "brand")
    String brand;
    @Column(name = "model")
    String model;
    @Column(name = "color")
    String color;
    @Column(name = "cost")
    int cost;

    public Car() {
    }

    public Car(String brand, String model, String color, int cost) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public int getCost() {
        return cost;
    }

    public Car setCost(int cost) {
        this.cost = cost;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", cost=" + cost +
                '}';
    }
}
