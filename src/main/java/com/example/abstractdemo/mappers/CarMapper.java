package com.example.abstractdemo.mappers;

import com.example.abstractdemo.beans.internal.Car;

public class CarMapper extends VehicleMapper {

    public static Car toInternal(com.example.abstractdemo.beans.external.Car external) {
        Car internal = new Car();
        toInternal(internal, external);
        internal.setWheels(external.getWheels());
        return internal;
    }

    public static com.example.abstractdemo.beans.external.Car toExternal(Car internal) {
        com.example.abstractdemo.beans.external.Car external = new com.example.abstractdemo.beans.external.Car();
        toExternal(external, internal);
        external.setWheels(internal.getWheels());
        return external;
    }

}
