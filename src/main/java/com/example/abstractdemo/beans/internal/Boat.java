package com.example.abstractdemo.beans.internal;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.time.OffsetDateTime;
import java.util.Objects;

@JsonTypeName("BOAT")
public class Boat extends Vehicle {

    private Integer sails;

    public Boat() {
    }

    public Boat(Integer id, VehicleType type, String name, OffsetDateTime createDate, Integer sails) {
        super(id, type, name, createDate);
        this.sails = sails;
    }

    public Integer getSails() {
        return sails;
    }

    public void setSails(Integer sails) {
        this.sails = sails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Boat boat = (Boat) o;

        return Objects.equals(sails, boat.sails);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (sails != null ? sails.hashCode() : 0);
        return result;
    }
}
