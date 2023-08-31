package com.example.abstractdemo.services;

import com.example.abstractdemo.beans.internal.Vehicle;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class VehicleInternalService {

    private final List<Vehicle> vehicleList = new ArrayList<>();
    private Integer vehicleIndex = 0;

    public Integer create(Vehicle vehicle) {
        vehicle.setId(vehicleIndex++);
        vehicle.setCreateDate(OffsetDateTime.now());
        vehicleList.add(vehicle);
        return vehicle.getId();
    }

    public void update(Integer id, Vehicle vehicle) throws Exception {
        if (!Objects.equals(id, vehicle.getId())) {
            throw new Exception("id mismatch");
        }
        for (Vehicle existingVehicle : vehicleList) {
            if (Objects.equals(existingVehicle.getId(), id)) {
                existingVehicle.setName(vehicle.getName());
                return;
            }
        }
        throw new Exception("Vehicle not found");
    }

    public void delete(Integer id) throws Exception {
        for (Vehicle existingVehicle : vehicleList) {
            if (Objects.equals(existingVehicle.getId(), id)) {
                vehicleList.remove(existingVehicle);
                return;
            }
        }
        throw new Exception("Vehicle not found");
    }

    public List<Vehicle> getAll() {
        return vehicleList;
    }

    public Vehicle get(Integer id) throws Exception {
        for (Vehicle existingVehicle : vehicleList) {
            if (Objects.equals(existingVehicle.getId(), id)) {
                return existingVehicle;
            }
        }
        throw new Exception("Vehicle not found");
    }
}
