package com.lifeinsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lifeinsurance.entity.LifeInsurancePlan;
import com.lifeinsurance.service.LifeInsurancePlanService;
import com.lifeinsurance.service.NotFoundException;

@RestController
@RequestMapping("/life-insurance/plans")
public class LifeInsuranceController {

    private final LifeInsurancePlanService lifeInsurancePlanService;

    @Autowired
    public LifeInsuranceController(LifeInsurancePlanService lifeInsurancePlanService) {
        this.lifeInsurancePlanService = lifeInsurancePlanService;
    }

    @GetMapping
    public ResponseEntity<List<LifeInsurancePlan>> getAllPlans() {
        try {
            List<LifeInsurancePlan> plans = lifeInsurancePlanService.getAllPlans();
            return new ResponseEntity<>(plans, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<LifeInsurancePlan> createPlan(@RequestBody LifeInsurancePlan plan) {
        try {
         LifeInsurancePlan createdPlan = lifeInsurancePlanService.createPlan(plan);
            return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LifeInsurancePlan> getPlanById(@PathVariable Long id) {
        try {
            LifeInsurancePlan plan = lifeInsurancePlanService.getPlanById(id);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LifeInsurancePlan> updatePlan(@PathVariable Long id, @RequestBody LifeInsurancePlan planDetails) {
        try {
            LifeInsurancePlan updatedPlan = lifeInsurancePlanService.updatePlan(id, planDetails);
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
            lifeInsurancePlanService.deletePlan(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
