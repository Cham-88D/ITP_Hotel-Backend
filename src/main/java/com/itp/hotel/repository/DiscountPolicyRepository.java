package com.itp.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itp.hotel.model.DiscountPolicy;
import com.itp.hotel.model.ResOrder;

public interface DiscountPolicyRepository extends JpaRepository<DiscountPolicy,Long>{

	@Query("SELECT d FROM DiscountPolicy d WHERE d.min_bill_amount<=?1")
	public List<DiscountPolicy> getApplicablePolicies(float currentTotal);
}
