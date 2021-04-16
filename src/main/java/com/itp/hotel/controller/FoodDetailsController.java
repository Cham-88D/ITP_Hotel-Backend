package com.itp.hotel.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.itp.hotel.model.FoodDetails;
import com.itp.hotel.repository.FoodDetailsRepository;
import com.itp.hotel.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/v1")
public class FoodDetailsController {
	
	@Autowired
	private FoodDetailsRepository foodRepository;
	
	@GetMapping("/foodDetails")
	public List<FoodDetails> getAllFoodDetails(){
		return foodRepository.findAll();
	}
	
	
	@PostMapping("/foodDetails")
	public FoodDetails createFoodDetails(@RequestBody FoodDetails foodDetails) {
		return foodRepository.save(foodDetails);
	}
	
	@GetMapping("/foodDetails/{Food_Id}")
    public ResponseEntity<FoodDetails> getFoodDetailsById(@PathVariable(value = "Food_Id") Integer Food_Id)
        throws ResourceNotFoundException {
        FoodDetails foodDetails = foodRepository.findById(Food_Id)
          .orElseThrow(() -> new ResourceNotFoundException("Food detail not found for this id :: " + Food_Id));
        return ResponseEntity.ok().body(foodDetails);
    }
	@PutMapping("/foodDetails/{Food_Id}")
    public ResponseEntity<FoodDetails> updateFoodDetails(@PathVariable(value = "Food_Id") Integer Food_Id,
         @RequestBody FoodDetails foodDetails) throws ResourceNotFoundException {
		FoodDetails foodDetails1 = foodRepository.findById(Food_Id)
        .orElseThrow(() -> new ResourceNotFoundException("Food detailt found for this id :: " + Food_Id));

		foodDetails1.setFood_Id(foodDetails.getFood_Id());
		foodDetails1.setFood_Name(foodDetails.getFood_Name());
		foodDetails1.setFood_Type(foodDetails.getFood_Type());
		foodDetails1.setUnit_Price(foodDetails.getUnit_Price());
		foodDetails1.setAvailability(foodDetails.getAvailability());
        final FoodDetails updateFoodDetails = foodRepository.save(foodDetails1);
        return ResponseEntity.ok(updateFoodDetails);
    }
	
	@DeleteMapping("/foodDetails/{Food_Id}")
    public Map<String, Boolean> deleteItem(@PathVariable(value = "Food_Id") Integer Food_Id)
         throws ResourceNotFoundException {
		FoodDetails foodDetails = foodRepository.findById(Food_Id)
       .orElseThrow(() -> new ResourceNotFoundException("Food Details not found for this id :: " + Food_Id));

		foodRepository.delete(foodDetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
}
