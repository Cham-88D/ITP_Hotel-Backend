package com.itp.hotel.controller;

import java.util.HashMap;





import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.itp.hotel.exception.*;
import com.itp.hotel.model.Room;
import com.itp.hotel.repository.RoomRepository;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class RoomController {

	
	
	  @Autowired
	    private RoomRepository roomRepository;

	  
	  
	    @GetMapping("/rooms")
	    public List<Room> getAllRooms() {
	        return roomRepository.findAll();
	    }

	    @GetMapping("/rooms/{RoomId}")
	    public ResponseEntity<Room> getRoomById(@PathVariable Integer RoomId){
	    Room room = roomRepository.findById(RoomId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + RoomId));
	        return ResponseEntity.ok(room);
	    }
	    @PostMapping("/rooms")
	    public Room createRoom (@RequestBody Room room) {
	        return roomRepository.save(room);
	    }
	    
	    
	    @PutMapping("/rooms/{RoomId}")
	    public ResponseEntity<Room> updateRoom(@PathVariable Integer  RoomId,
	          @RequestBody Room roomDetails) throws ResourceNotFoundException {
	    	Room room = roomRepository.findById(RoomId)
	        .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + RoomId));

//	        room.setRoomId(room.getRoomId());
	        room.setRoom_Type(roomDetails.getRoom_Type());
	        room.setRoom_Status(roomDetails.getRoom_Status());
	        room.setR_Price(roomDetails.getR_Price());
		   Room updatedRoom = roomRepository.save(room);
	       return ResponseEntity.ok(updatedRoom);
	    }
	    
	    @DeleteMapping("/rooms/{RoomId}")
	    public Map<String, Boolean> deleteRoom(@PathVariable(value = "RoomId") Integer RoomId)
	         throws ResourceNotFoundException {
	    	Room room = roomRepository.findById(RoomId)
	        .orElseThrow(() -> new ResourceNotFoundException("Room not found for this id :: " + RoomId));

	    	roomRepository.delete(room);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    

}
