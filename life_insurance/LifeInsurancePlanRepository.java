package com.lifeinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifeinsurance.entity.LifeInsurancePlan;


public interface LifeInsurancePlanRepository extends JpaRepository<LifeInsurancePlan, Long>   {

}
