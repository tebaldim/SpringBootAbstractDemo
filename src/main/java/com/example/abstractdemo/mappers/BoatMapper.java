package com.example.abstractdemo.mappers;

import com.example.abstractdemo.beans.internal.Boat;

public class BoatMapper extends VehicleMapper {
    
    public static Boat toInternal(com.example.abstractdemo.beans.external.Boat external) {
        Boat internal = new Boat();
        toInternal(internal, external);
        internal.setSails(external.getSails());
        return internal;
    }

    public static com.example.abstractdemo.beans.external.Boat toExternal(Boat internal) {
        com.example.abstractdemo.beans.external.Boat external = new com.example.abstractdemo.beans.external.Boat();
        toExternal(external, internal);
        external.setSails(internal.getSails());
        return external;
    }
    
}
