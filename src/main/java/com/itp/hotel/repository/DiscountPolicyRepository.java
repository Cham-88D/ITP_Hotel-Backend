package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itp.hotel.model.DiscountPolicy;

public interface DiscountPolicyRepository extends JpaRepository<DiscountPolicy,Long>{

}
