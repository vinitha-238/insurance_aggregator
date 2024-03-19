package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifeinsurance.entity.LifeInsurancePlan;
import com.lifeinsurance.repository.LifeInsurancePlanRepository;

@Service
public class LifeInsurancePlanService {

    private final LifeInsurancePlanRepository lifeInsurancePlanRepository;

    @Autowired
    public LifeInsurancePlanService(LifeInsurancePlanRepository lifeInsurancePlanRepository) {
        this.lifeInsurancePlanRepository = lifeInsurancePlanRepository;
    }

    public List<LifeInsurancePlan> getAllPlans() {
        return lifeInsurancePlanRepository.findAll();
    }

    public LifeInsurancePlan createPlan(LifeInsurancePlan plan) {
        return lifeInsurancePlanRepository.save(plan);
    }

    public LifeInsurancePlan getPlanById(Long id) {
        return lifeInsurancePlanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Plan not found with id " + id));
    }

    public LifeInsurancePlan updatePlan(Long id, LifeInsurancePlan planDetails) {
        LifeInsurancePlan plan = lifeInsurancePlanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Plan not found with id " + id));
        plan.setPolicyNumber(planDetails.getPolicyNumber());
        plan.setPolicyHolderName(planDetails.getPolicyHolderName());
        plan.setCoverageAmount(planDetails.getCoverageAmount());
       
        return lifeInsurancePlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        if (!lifeInsurancePlanRepository.existsById(id)) {
            throw new NotFoundException("Plan not found with id " + id);
        }
        lifeInsurancePlanRepository.deleteById(id);
    }
}
