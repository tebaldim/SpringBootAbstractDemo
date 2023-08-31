package com.example.abstractdemo.mappers;

import com.example.abstractdemo.beans.internal.Plane;

public class PlaneMapper extends VehicleMapper {

    public static Plane toInternal(com.example.abstractdemo.beans.external.Plane external) {
        Plane internal = new Plane();
        toInternal(internal, external);
        internal.setWings(external.getWings());
        return internal;
    }


    public static com.example.abstractdemo.beans.external.Plane toExternal(Plane internal) {
        com.example.abstractdemo.beans.external.Plane external = new com.example.abstractdemo.beans.external.Plane();
        toExternal(external, internal);
        external.setWings(internal.getWings());
        return external;
    }
    
}
