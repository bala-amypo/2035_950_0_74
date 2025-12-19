package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;

    @PrePersist
    public void onCreate() {
        generatedAt = LocalDateTime.now();
    }

    public RouteOptimizationResult() {}

    public RouteOptimizationResult(Shipment shipment, Double distance, Double fuel) {
        this.shipment = shipment;
        this.optimizedDistanceKm = distance;
        this.estimatedFuelUsageL = fuel;
    }   
 }

    
