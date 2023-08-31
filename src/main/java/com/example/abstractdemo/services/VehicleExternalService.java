package com.example.abstractdemo.services;

import com.example.abstractdemo.beans.external.Vehicle;
import com.example.abstractdemo.mappers.VehicleMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleExternalService {

    private final VehicleInternalService vehicleInternalService;

    public VehicleExternalService(VehicleInternalService vehicleInternalService) {
        this.vehicleInternalService = vehicleInternalService;
    }

    public Integer create(Vehicle vehicle) throws Exception {
        return this.vehicleInternalService.create(VehicleMapper.toInternal(vehicle));
    }

    public void update(Integer id, Vehicle vehicle) throws Exception {
        this.vehicleInternalService.update(id, VehicleMapper.toInternal(vehicle));
    }

    public void delete(Integer id) throws Exception {
        this.vehicleInternalService.delete(id);
    }

    public List<Vehicle> getAll() throws Exception {
        List<Vehicle> vehicleList = new ArrayList<>();
        for (com.example.abstractdemo.beans.internal.Vehicle vehicle : vehicleInternalService.getAll()) {
            vehicleList.add(VehicleMapper.toExternal(vehicle));
        }
        return vehicleList;
    }

    public Vehicle get(Integer id) throws Exception {
        return VehicleMapper.toExternal(this.vehicleInternalService.get(id));
    }
}
