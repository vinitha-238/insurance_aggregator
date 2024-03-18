package com.healthinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthinsurance.entity.HealthInsurancePlan;
import com.healthinsurance.repository.HealthInsurancePlanRepository;

@Service
public class HealthInsurancePlanService {

    private final HealthInsurancePlanRepository healthInsurancePlanRepository;

    @Autowired
    public HealthInsurancePlanService(HealthInsurancePlanRepository healthInsurancePlanRepository) {
        this.healthInsurancePlanRepository = healthInsurancePlanRepository;
    }

    public List<HealthInsurancePlan> getAllPlans() {
        return healthInsurancePlanRepository.findAll();
    }

    public HealthInsurancePlan createPlan(HealthInsurancePlan plan) {
        return healthInsurancePlanRepository.save(plan);
    }

    public HealthInsurancePlan getPlanById(Long id) {
        return healthInsurancePlanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Plan not found with id " + id));
    }

    public HealthInsurancePlan updatePlan(Long id, HealthInsurancePlan planDetails) {
        HealthInsurancePlan plan = healthInsurancePlanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Plan not found with id " + id));

        plan.setName(planDetails.getName());
        plan.setDescription(planDetails.getDescription());
        plan.setAnnualPremium(planDetails.getAnnualPremium());
        plan.setCoPay(planDetails.getCoPay());
        plan.setAnnualDeductible(planDetails.getAnnualDeductible());

        return healthInsurancePlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        if (!healthInsurancePlanRepository.existsById(id)) {
            throw new NotFoundException("Plan not found with id " + id);
        }
        healthInsurancePlanRepository.deleteById(id);
    }
}
