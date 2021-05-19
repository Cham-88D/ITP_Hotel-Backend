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
import com.itp.hotel.model.EvModificationRequest;

import com.itp.hotel.repository.EvModificationRequestRepository;

@CrossOrigin(origins = "http://localhost:3000" ,maxAge = 3600)
@RestController
@RequestMapping("/api/auth")

public class Ev_Modification_RequestController {
	@Autowired
    private EvModificationRequestRepository ev_Modification_RequestRepository;
	
	 @GetMapping("/ev_Modification_Requests")
	    public List<EvModificationRequest> getAllEv_Modification_Requests() {
	        return ev_Modification_RequestRepository.findAll();
	    }
	    
	    @GetMapping("/ev_Modification_Requests/{Ev_M_ID}")
	    public ResponseEntity<EvModificationRequest> getEv_Modification_RequestById(@PathVariable Integer Ev_M_ID){
	    	EvModificationRequest ev_Modification_Request = ev_Modification_RequestRepository.findById(Ev_M_ID)
	    			.orElseThrow(() -> new ResourceNotFoundException("Ev_Modification_Request not found for this id :: " + Ev_M_ID));
	        return ResponseEntity.ok(ev_Modification_Request);
	    }
	    
	    @PostMapping("/ev_Modification_Requests")
	    public EvModificationRequest createEv_Modification_Request(@RequestBody EvModificationRequest ev_Modification_Request) {
	        return ev_Modification_RequestRepository.save(ev_Modification_Request);
	    }
	    
	    @PutMapping("/ev_Modification_Requests/{Ev_M_ID}")
	    public ResponseEntity<EvModificationRequest> updateEv_Modification_Request(@PathVariable(value = "Ev_M_ID") Integer Ev_M_ID,
	         @RequestBody EvModificationRequest ev_Modification_RequestDetails) throws ResourceNotFoundException {
	    	EvModificationRequest ev_Modification_Request = ev_Modification_RequestRepository.findById(Ev_M_ID)
	        .orElseThrow(() -> new ResourceNotFoundException("Ev_Modification_Request not found for this id :: " + Ev_M_ID));

	    	ev_Modification_Request.setEv_M_ID(ev_Modification_Request.getEv_M_ID());
	    	ev_Modification_Request.setReason(ev_Modification_Request.getReason());
	    	ev_Modification_Request.setMessage(ev_Modification_Request.getMessage());
	    	ev_Modification_Request.setEmail(ev_Modification_Request.getEmail());
	    	ev_Modification_Request.setDays_Remain_Booking(ev_Modification_Request.getDays_Remain_Booking());
	    //	ev_Modification_Request.setCustomer(ev_Modification_Request.getCustomer());
	    //	ev_Modification_Request.setBooking(ev_Modification_Request.getBooking());
	        
	        final EvModificationRequest updatedEv_Modification_Request = ev_Modification_RequestRepository.save(ev_Modification_Request);
	        return ResponseEntity.ok(updatedEv_Modification_Request);
	    }
	    
	    @DeleteMapping("/ev_Modification_Request/{Ev_M_ID}")
	    public Map<String, Boolean> deleteEv_Modification_Request(@PathVariable(value = "Ev_M_ID") Integer Ev_M_ID)
	         throws ResourceNotFoundException {
	    	EvModificationRequest ev_Modification_Request = ev_Modification_RequestRepository.findById(Ev_M_ID)
	       .orElseThrow(() -> new ResourceNotFoundException("Ev_Modification_Request not found for this id :: " + Ev_M_ID));

	    	ev_Modification_RequestRepository.delete(ev_Modification_Request);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    

}

/*@GetMapping("/ev_Modification_Requests/{Ev_M_ID}")
public ResponseEntity<EvModificationRequest> getEv_Modification_RequestById(@PathVariable Integer Ev_M_ID)
	EvModificationRequest ev_Modification_Request = ev_Modification_RequestRepository.findById(Ev_M_ID)
			.orElseThrow(() -> new ResourceNotFoundException("Ev_Modification_Request not found for this id :: " + Ev_M_ID));
    return ResponseEntity.ok(ev_Modification_Request);
}*/

/*@GetMapping("/reservations/{Res_Id}")
public ResponseEntity<Reservation> getReservationtById(@PathVariable Integer Res_Id){
    Reservation reservation = reservationRepository.findById(Res_Id)
     .orElseThrow(() -> new ResourceNotFoundException(" Reservation  not found for this id :: " + Res_Id));
    return ResponseEntity.ok(reservation);
}*/
