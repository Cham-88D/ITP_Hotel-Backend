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
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.Event;
import com.itp.hotel.repository.EventRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class EventController {

	@Autowired
    private EventRepository eventRepository;
	
	 @GetMapping("/events")
	    public List<Event> getAllEvents() {
	        return eventRepository.findAll();
	    }
	    
	    @GetMapping("/events/{Event_Id}")
	    public ResponseEntity<Event> getEventById(@PathVariable(value = "Event_Id") Integer Event_Id)
	        throws ResourceNotFoundException {
	    	Event event = eventRepository.findById(Event_Id)
	    			.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + Event_Id));
	        return ResponseEntity.ok().body(event);
	    }
	    
	    @PostMapping("/events")
	    public Event createEvent(@RequestBody Event event) {
	        return eventRepository.save(event);
	    }
	    
	    
	    @PutMapping("/events/{Event_Id}")
	    public ResponseEntity<Event> updateEvent(@PathVariable(value = "Event_Id") Integer Event_Id,
	         @RequestBody Event eventDetails) throws ResourceNotFoundException {
	        Event event = eventRepository.findById(Event_Id)
	        .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + Event_Id));

	    
	        event.setType(eventDetails.getType());
	        event.setPackage(eventDetails.getPackage());
	        event.setDescription(eventDetails.getDescription());
	        event.setPrice(eventDetails.getPrice());
	        
	        final Event updatedEvent = eventRepository.save(event);
	        return ResponseEntity.ok(updatedEvent);
	    }
	    
	    @DeleteMapping("/events/{Event_Id}")
	    public Map<String, Boolean> deleteEvent(@PathVariable(value = "Event_Id") Integer Event_Id)
	         throws ResourceNotFoundException {
	    	Event event = eventRepository.findById(Event_Id)
	       .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + Event_Id));

	    	eventRepository.delete(event);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    

}