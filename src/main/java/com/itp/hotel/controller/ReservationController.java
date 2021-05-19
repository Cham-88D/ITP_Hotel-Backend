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
import com.itp.hotel.model.Reservation;
//import com.itp.hotel.model.Room;
import com.itp.hotel.repository.ReservationRepository;
//import com.itp.hotel.repository.RoomRepository;




@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class ReservationController {

	
	
	  @Autowired
	    private ReservationRepository reservationRepository;
	    @GetMapping("/reservations")
	    public List<Reservation> getAllReservations() {
	        return reservationRepository.findAll();
	    }

	    @GetMapping("/reservations/{Res_Id}")
	    public ResponseEntity<Reservation> getReservationtById(@PathVariable Integer Res_Id){
	        Reservation reservation = reservationRepository.findById(Res_Id)
	         .orElseThrow(() -> new ResourceNotFoundException(" Reservation  not found for this id :: " + Res_Id));
	        return ResponseEntity.ok(reservation);
	    }
	    
	    
	    @PostMapping("/reservations")
	    public Reservation createReservation ( @RequestBody Reservation reservation) {
	        return reservationRepository.save(reservation);
	    }
	    
	    
	    @PutMapping("/reservations/{Res_Id}")
	    public ResponseEntity<Reservation> updateReservation(@PathVariable Integer Res_Id,
	         @RequestBody Reservation reservationDetails) throws ResourceNotFoundException {
	    	Reservation reservation = reservationRepository.findById(Res_Id)
	        .orElseThrow(() -> new ResourceNotFoundException(" Reservation  not found for this id :: " + Res_Id));

//	    	reservation.setRes_Id(reservation.getRes_Id());
	    	reservation.setCus_Name(reservation.getCus_Name());
	    	reservation.setCus_Phone(reservation.getCus_Phone());
	    	reservation.setCheck_In(reservation.getCheck_In());
	    	reservation.setCheck_Out(reservation.getCheck_Out());
	    	reservation.setNo_Of_Ac_Rooms(reservation.getNo_Of_Ac_Rooms());
	    	reservation.setNo_Of_Non_Ac_Rooms(reservation.getNo_Of_Non_Ac_Rooms());
	    	reservation.setNo_Of_Child(reservation.getNo_Of_Child());
	    	reservation.setNo_Of_Adult(reservation.getNo_Of_Adult());
	       Reservation  updatedReservation  = reservationRepository.save(reservation);
	       return ResponseEntity.ok(updatedReservation);
	    }
	
	    @DeleteMapping("/reservations/{Res_Id}")
	    public Map<String, Boolean> deleteReservation(@PathVariable Integer Res_Id)
	         throws ResourceNotFoundException {
	    	Reservation reservation = reservationRepository.findById(Res_Id)
	       .orElseThrow(() -> new ResourceNotFoundException(" Reservation  not found for this id :: " + Res_Id));

	    	reservationRepository.delete(reservation);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
