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
import com.itp.hotel.exception.ResourceNotFoundException;
import com.itp.hotel.model.Booking;
import com.itp.hotel.repository.BookingRepository;

@RestController
@RequestMapping("/api/v1/")


public class BookingController {
	@Autowired
    private BookingRepository bookingRepository;
	
	 @GetMapping("/bookings")
	    public List<Booking> getAllBookings() {
	        return bookingRepository.findAll();
	    }
	    
	    @GetMapping("/bookings/{Booking_Id}")
	    public ResponseEntity<Booking> getBookingById(@PathVariable(value = "Booking_Id") Integer Booking_Id)
	        throws ResourceNotFoundException {
	    	Booking booking = bookingRepository.findById(Booking_Id)
	    			.orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + Booking_Id));
	        return ResponseEntity.ok().body(booking);
	    }
	    
	    @PostMapping("/bookings")
	    public Booking createBooking(@Valid @RequestBody Booking booking) {
	        return bookingRepository.save(booking);
	    }
	    
	    @PutMapping("/bookings/{Booking_Id}")
	    public ResponseEntity<Booking> updateBooking(@PathVariable(value = "Booking_Id") Integer Booking_Id,
	         @Valid @RequestBody Booking bookingDetails) throws ResourceNotFoundException {
	    	Booking booking = bookingRepository.findById(Booking_Id)
	        .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + Booking_Id));

	    	booking.setBooking_Id(booking.getBooking_Id());
	    	booking.setDate(booking.getDate());
	    	booking.setCus_Name(booking.getCus_Name());
	    	booking.setCus_Phone_No(booking.getCus_Phone_No());
	    	booking.setNum_Participants(booking.getNum_Participants());
	    	booking.setBooking_Type(booking.getBooking_Type());
	    	booking.setBooking_Package(booking.getBooking_Package());
	    	booking.setTime_In(booking.getTime_In());
	    	booking.setTime_Out(booking.getTime_Out());
	        
	        final Booking updatedBooking = bookingRepository.save(booking);
	        return ResponseEntity.ok(updatedBooking);
	    }
	    
	    @DeleteMapping("/booking/{Booking_Id}")
	    public Map<String, Boolean> deleteBooking(@PathVariable(value = "Booking_Id") Integer Booking_Id)
	         throws ResourceNotFoundException {
	    	Booking booking = bookingRepository.findById(Booking_Id)
	       .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + Booking_Id));

	    	bookingRepository.delete(booking);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    

}