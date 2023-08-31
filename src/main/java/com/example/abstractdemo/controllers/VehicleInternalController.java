package com.example.abstractdemo.controllers;

import com.example.abstractdemo.beans.internal.Vehicle;
import com.example.abstractdemo.services.VehicleInternalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/internal/vehicle")
public class VehicleInternalController {

    private final VehicleInternalService vehicleInternalService;

    public VehicleInternalController(VehicleInternalService vehicleInternalService) {
        this.vehicleInternalService = vehicleInternalService;
    }

    @PostMapping("/")
    public Integer create(@RequestBody Vehicle vehicle) {
        return vehicleInternalService.create(vehicle);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Vehicle vehicle) throws Exception {
        vehicleInternalService.update(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        vehicleInternalService.delete(id);
    }

    @GetMapping("/")
    public List<Vehicle> getAll() {
        return vehicleInternalService.getAll();
    }

    @GetMapping("/{id}")
    public Vehicle get(@PathVariable Integer id) throws Exception {
        return vehicleInternalService.get(id);
    }
}
