package com.healthinsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.healthinsurance.entity.HealthInsurancePlan;
import com.healthinsurance.service.HealthInsurancePlanService;
import com.healthinsurance.service.NotFoundException;

@RestController
@RequestMapping("/health-insurance/plans")
public class HealthInsuranceController {

    private final HealthInsurancePlanService healthInsurancePlanService;

    @Autowired
    public HealthInsuranceController(HealthInsurancePlanService healthInsurancePlanService) {
        this.healthInsurancePlanService = healthInsurancePlanService;
    }

    @GetMapping
    public ResponseEntity<List<HealthInsurancePlan>> getAllPlans() {
        try {
            List<HealthInsurancePlan> plans = healthInsurancePlanService.getAllPlans();
            return new ResponseEntity<>(plans, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<HealthInsurancePlan> createPlan(@RequestBody HealthInsurancePlan plan) {
        try {
            HealthInsurancePlan createdPlan = healthInsurancePlanService.createPlan(plan);
            return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthInsurancePlan> getPlanById(@PathVariable Long id) {
        try {
            HealthInsurancePlan plan = healthInsurancePlanService.getPlanById(id);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthInsurancePlan> updatePlan(@PathVariable Long id, @RequestBody HealthInsurancePlan planDetails) {
        try {
            HealthInsurancePlan updatedPlan = healthInsurancePlanService.updatePlan(id, planDetails);
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        try {
            healthInsurancePlanService.deletePlan(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
