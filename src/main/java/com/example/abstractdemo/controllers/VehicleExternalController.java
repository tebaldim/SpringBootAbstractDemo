package com.example.abstractdemo.controllers;

import com.example.abstractdemo.beans.external.Vehicle;
import com.example.abstractdemo.services.VehicleExternalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/external/vehicle")
public class VehicleExternalController {

    private final VehicleExternalService vehicleExternalService;

    public VehicleExternalController(VehicleExternalService vehicleExternalService) {
        this.vehicleExternalService = vehicleExternalService;
    }

    @PostMapping("/")
    public Integer create(@RequestBody Vehicle vehicle) throws Exception {
        return vehicleExternalService.create(vehicle);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Vehicle vehicle) throws Exception {
        vehicleExternalService.update(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        vehicleExternalService.delete(id);
    }

    @GetMapping("/")
    public List<Vehicle> getAll() throws Exception {
        return vehicleExternalService.getAll();
    }

    @GetMapping("/{id}")
    public Vehicle get(@PathVariable Integer id) throws Exception {
        return vehicleExternalService.get(id);
    }
}
