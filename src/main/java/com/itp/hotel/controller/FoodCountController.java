package com.itp.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.itp.hotel.model.FoodCount;
import com.itp.hotel.model.FoodDetails;
import com.itp.hotel.repository.FoodCountRepository;
import com.itp.hotel.repository.FoodDetailsRepository;
import com.itp.hotel.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")

public class FoodCountController {
	
	@Autowired
	private FoodCountRepository foodCountRepository;
	
	@Autowired
	private FoodDetailsRepository foodDetailsRepository;
	
	
	
	//get all foodCount
	@GetMapping("/foodCount")
	public List<FoodCount> getAllCountDetails(){
		return foodCountRepository.findAll();
	}
	
	//create foodCount rest api
		@PostMapping("/foodCount")
		public FoodCount createFoodCount(@RequestBody FoodCount foodCount) {
			FoodDetails foodDetails = foodDetailsRepository.findByName(foodCount.getName());
			foodCount.setFoodDetails(foodDetails);
			int count = Integer.parseInt(foodCount.getQuantity());
			int currentCount = foodDetails.getAvailability();
			if(foodCount.getType().equals("Consumed")) {
				if(currentCount<count) {
		           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Count Not Available");
				}else {
					foodDetails.setAvailability(currentCount-count);
				}
				
			}else {
				foodDetails.setAvailability(currentCount+count);
			}
			foodDetailsRepository.save(foodDetails);
			return foodCountRepository.save(foodCount);
		}

	

	
	//get foodCount by id rest api
	@GetMapping("/foodCount/{count_id}")
    public ResponseEntity<FoodCount> getFoodCountById(@PathVariable(value = "count_id") Integer count_id)
        throws ResourceNotFoundException {
		FoodCount foodCount = foodCountRepository.findById(count_id)
          .orElseThrow(() -> new ResourceNotFoundException("Food Count not found for this id :: " + count_id));
        return ResponseEntity.ok().body(foodCount);
    }

	// update foodCount rest api
	@PutMapping("/foodCount/{count_id}")
    public ResponseEntity<FoodCount> updateFoodCount(@PathVariable(value = "count_id") Integer count_id,
         @RequestBody FoodCount foodCount) throws ResourceNotFoundException {
		FoodCount foodCount1 = foodCountRepository.findById(count_id)
        .orElseThrow(() -> new ResourceNotFoundException("Food Count found for this id :: " + count_id));

		int count = Integer.parseInt(foodCount.getQuantity());
		int currentCount = foodCount1.getFoodDetails().getAvailability();
		if(foodCount.getType().equals("Consumed")) {
			if(currentCount<count) {
	           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Count Not Available");
			}else {
				foodCount1.getFoodDetails().setAvailability(currentCount-count);
			}
			
		}else {
			foodCount1.getFoodDetails().setAvailability(currentCount+count);
		}
		foodCount1.setName(foodCount.getName());
		
		foodCount1.setQuantity(foodCount.getQuantity());
		foodCount1.setDate(foodCount.getDate());
		foodCount1.setType(foodCount.getType());
        final FoodCount updateFoodCount = foodCountRepository.save(foodCount1);
        return ResponseEntity.ok(updateFoodCount);
    }

	//delete foodCount rest api
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
