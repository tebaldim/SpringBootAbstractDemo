package com.example.abstractdemo.beans.external;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeName("PLANE")
public class Plane extends Vehicle {

    private Integer wings;

    public Plane() {
        super();
    }

    public Plane(VehicleType type, String name, Integer wings) {
        super(type, name);
        this.wings = wings;
    }

    public Integer getWings() {
        return wings;
    }

    public void setWings(Integer wings) {
        this.wings = wings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Plane plane = (Plane) o;

        return Objects.equals(wings, plane.wings);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wings != null ? wings.hashCode() : 0);
        return result;
    }
}
