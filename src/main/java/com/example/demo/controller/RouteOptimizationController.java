package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService routeService;

    // ✅ Constructor Injection
    public RouteOptimizationController(RouteOptimizationService routeService) {
        this.routeService = routeService;
    }

    // ✅ Optimize Route
    @PostMapping("/{shipmentId}")
    public ResponseEntity<RouteOptimizationResult> optimizeRoute(
            @PathVariable Long shipmentId) {

        RouteOptimizationResult result =
                routeService.optimizeRoute(shipmentId);

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // ✅ Get Optimization Result
    @GetMapping("/result/{resultId}")
    public ResponseEntity<RouteOptimizationResult> getResult(
            @PathVariable Long resultId) {

        return ResponseEntity.ok(
                routeService.getResult(resultId)
        );
    }
}
