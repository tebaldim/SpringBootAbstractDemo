package com.example.abstractdemo.beans.internal;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.OffsetDateTime;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "CAR"),
        @JsonSubTypes.Type(value = Boat.class, name = "BOAT"),
        @JsonSubTypes.Type(value = Plane.class, name = "PLANE"),
})
public abstract class Vehicle {

    private Integer id;
    private VehicleType type;
    private String name;
    private OffsetDateTime createDate;

    public Vehicle() {
    }

    public Vehicle(Integer id, VehicleType type, String name, OffsetDateTime createDate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (!Objects.equals(id, vehicle.id)) return false;
        if (type != vehicle.type) return false;
        if (!Objects.equals(name, vehicle.name)) return false;
        return Objects.equals(createDate, vehicle.createDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
