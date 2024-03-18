package com.healthinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthinsurance.entity.HealthInsurancePlan;

public interface HealthInsurancePlanRepository extends JpaRepository<HealthInsurancePlan, Long>  {

}
