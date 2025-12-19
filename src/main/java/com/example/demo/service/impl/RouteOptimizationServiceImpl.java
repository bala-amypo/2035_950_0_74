package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RouteOptimizationService;

public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepo;
    private final RouteOptimizationResultRepository resultRepo;

    public RouteOptimizationServiceImpl(ShipmentRepository s, RouteOptimizationResultRepository r) {
        this.shipmentRepo = s;
        this.resultRepo = r;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        Shipment shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double distance = Math.hypot(
                shipment.getPickupLocation().getLatitude() - shipment.getDropLocation().getLatitude(),
                shipment.getPickupLocation().getLongitude() - shipment.getDropLocation().getLongitude()
        ) + 1;

        double fuel = distance / shipment.getVehicle().getFuelEfficiency();

        return resultRepo.save(new RouteOptimizationResult(shipment, distance, fuel));
    }

    @Override
    public RouteOptimizationResult getResult(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
