package com.lifeinsurance.entity;
 
import java.time.LocalDate;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity
public class LifeInsurancePlan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  
 
	private Long id;
    private String policyNumber;
    private String policyHolderName;
 
    private double coverageAmount;
    public LifeInsurancePlan() {
        // Default constructor with default values
    	    String policyNumber = "DEFAULT_POLICY_NUMBER";
    	    String policyHolderName = "DEFAULT_POLICY_HOLDER";
    	
    	    double coverageAmount = 100000.0;// Default coverage amount
    	
    	    
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicyHolderName() {
		return policyHolderName;
	}
	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}
	
	public double getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	
	
	public LifeInsurancePlan(Long id, String policyNumber, String policyHolderName, String beneficiaryName,
			double coverageAmount, String description) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.policyHolderName = policyHolderName;
		
		this.coverageAmount = coverageAmount;
		
	}
	
}