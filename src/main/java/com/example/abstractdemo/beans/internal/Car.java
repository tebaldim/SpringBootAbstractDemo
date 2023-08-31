package com.example.abstractdemo.beans.internal;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.OffsetDateTime;
import java.util.Objects;

@JsonTypeName("CAR")
public class Car extends Vehicle {

    private Integer wheels;

    public Car() {
    }

    public Car(Integer id, VehicleType type, String name, OffsetDateTime createDate, Integer wheels) {
        super(id, type, name, createDate);
        this.wheels = wheels;
    }

    public Integer getWheels() {
        return wheels;
    }

    public void setWheels(Integer wheels) {
        this.wheels = wheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        return Objects.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wheels != null ? wheels.hashCode() : 0);
        return result;
    }

}
