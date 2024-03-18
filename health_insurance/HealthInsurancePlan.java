package com.healthinsurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HealthInsurancePlan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double annualPremium;
    private double coPay;
    private double annualDeductible;
    
    public HealthInsurancePlan() {
        // Default constructor with default values
        this.name = "Basic Plan";
        this.description = "Standard health insurance plan";
        this.annualPremium = 1000.0; // Default annual premium
        this.coPay = 20.0; // Default co-pay amount
        this.annualDeductible = 500.0; // Default annual deductible
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAnnualPremium() {
		return annualPremium;
	}
	public void setAnnualPremium(double annualPremium) {
		this.annualPremium = annualPremium;
	}
	public double getCoPay() {
		return coPay;
	}
	public void setCoPay(double coPay) {
		this.coPay = coPay;
	}
	public double getAnnualDeductible() {
		return annualDeductible;
	}
	public void setAnnualDeductible(double annualDeductible) {
		this.annualDeductible = annualDeductible;
	}
	public HealthInsurancePlan(Long id, String name, String description, double annualPremium, double coPay,
			double annualDeductible) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.annualPremium = annualPremium;
		this.coPay = coPay;
		this.annualDeductible = annualDeductible;
	}
    

}
