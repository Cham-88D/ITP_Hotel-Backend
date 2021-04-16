package com.itp.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.hotel.model.FoodCount;
import com.itp.hotel.repository.FoodCountRepository;
import com.itp.hotel.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class FoodCountController {
	
	@Autowired
	private FoodCountRepository foodCountRepository;
	
	@GetMapping("/foodCount")
	public List<FoodCount> getAllCountDetails(){
		return foodCountRepository.findAll();
	}
	
	@PostMapping("/foodCount")
	public FoodCount createFoodCount(@RequestBody FoodCount foodCount) {
		return foodCountRepository.save(foodCount);
	}
	
	@GetMapping("/foodCount/{count_id}")
    public ResponseEntity<FoodCount> getFoodCountById(@PathVariable(value = "count_id") Integer count_id)
        throws ResourceNotFoundException {
		FoodCount foodCount = foodCountRepository.findById(count_id)
          .orElseThrow(() -> new ResourceNotFoundException("Food Count not found for this id :: " + count_id));
        return ResponseEntity.ok().body(foodCount);
    }

	@PutMapping("/foodCount/{count_id}")
    public ResponseEntity<FoodCount> updateFoodCount(@PathVariable(value = "count_id") Integer count_id,
         @RequestBody FoodCount foodCount) throws ResourceNotFoundException {
		FoodCount foodCount1 = foodCountRepository.findById(count_id)
        .orElseThrow(() -> new ResourceNotFoundException("Food Count found for this id :: " + count_id));

		foodCount1.setCount_id(foodCount.getCount_id());
		foodCount1.setName(foodCount.getName());
		foodCount1.setQuantity(foodCount.getQuantity());
		foodCount1.setDate(foodCount.getDate());
		foodCount1.setType(foodCount.getType());
        final FoodCount updateFoodCount = foodCountRepository.save(foodCount1);
        return ResponseEntity.ok(updateFoodCount);
    }
	
	@DeleteMapping("/foodCount/{count_id}")
    public Map<String, Boolean> deleteItem(@PathVariable(value = "count_id") Integer count_id)
         throws ResourceNotFoundException {
		FoodCount foodDetails = foodCountRepository.findById(count_id)
       .orElseThrow(() -> new ResourceNotFoundException("Food Count not found for this id :: " + count_id));

		foodCountRepository.delete(foodDetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
