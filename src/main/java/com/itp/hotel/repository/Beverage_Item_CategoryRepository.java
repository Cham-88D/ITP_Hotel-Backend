package com.itp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.hotel.model.Beverage_Item_Category;

@Repository
public interface Beverage_Item_CategoryRepository extends JpaRepository<Beverage_Item_Category, Long> {

}
