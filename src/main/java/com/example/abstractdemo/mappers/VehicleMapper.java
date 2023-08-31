package com.example.abstractdemo.mappers;

import com.example.abstractdemo.beans.internal.*;

public abstract class VehicleMapper {

    public static Vehicle toInternal(Vehicle internal, com.example.abstractdemo.beans.external.Vehicle external) {
        internal.setType(VehicleType.valueOf(external.getType().name()));
        internal.setName(external.getName());
        return internal;
    }

    public static com.example.abstractdemo.beans.external.Vehicle toExternal(com.example.abstractdemo.beans.external.Vehicle external, Vehicle internal) {
        external.setType(com.example.abstractdemo.beans.external.VehicleType.valueOf(internal.getType().name()));
        external.setName(internal.getName());
        return external;
    }

    public static Vehicle toInternal(com.example.abstractdemo.beans.external.Vehicle external) throws Exception {
        switch (external.getType()) {
            case CAR -> {
                return CarMapper.toInternal((com.example.abstractdemo.beans.external.Car) external);
            }
            case BOAT -> {
                return BoatMapper.toInternal((com.example.abstractdemo.beans.external.Boat) external);
            }
            case PLANE -> {
                return PlaneMapper.toInternal((com.example.abstractdemo.beans.external.Plane) external);
            }
        }
        throw new Exception("Mapper not implemented for type " + external.getType());
    }

    public static com.example.abstractdemo.beans.external.Vehicle toExternal(Vehicle internal) throws Exception {
        switch (internal.getType()) {
            case CAR -> {
                return CarMapper.toExternal((Car) internal);
            }
            case BOAT -> {
                return BoatMapper.toExternal((Boat) internal);
            }
            case PLANE -> {
                return PlaneMapper.toExternal((Plane) internal);
            }
        }
        throw new Exception("Mapper not implemented for type " + internal.getType());
    }

}
