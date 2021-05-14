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
import com.itp.hotel.model.Booking;
import com.itp.hotel.repository.BookingRepository;
@CrossOrigin(origins = "http://localhost:3000")
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
	    public ResponseEntity<Booking> getBookingById(@PathVariable(value = "Booking_Id") Long Booking_Id)
	        throws ResourceNotFoundException {
	    	Booking booking = bookingRepository.findById(Booking_Id)
	    			.orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + Booking_Id));
	        return ResponseEntity.ok().body(booking);
	    }
	    
	    @PostMapping("/bookings")
	    public Booking createBooking(@RequestBody Booking booking) {
	        return bookingRepository.save(booking);
	    }
	    
	    @PutMapping("/bookings/{Booking_Id}")
	    public ResponseEntity<Booking> updateBooking(@PathVariable Long Booking_Id,
	        @RequestBody Booking bookingDetails) throws ResourceNotFoundException {
	    	Booking booking = bookingRepository.findById(Booking_Id)
	        .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + Booking_Id));

	    	//booking.setBooking_Id(booking.getBooking_Id());
	    	booking.setDate(booking.getDate());
	    	booking.setCus_Name(booking.getCus_Name());
	    	booking.setCus_Phone_No(booking.getCus_Phone_No());
	    	booking.setNum_Participants(booking.getNum_Participants());
	    	booking.setBooking_Type(booking.getBooking_Type());
	    	booking.setBooking_Package(booking.getBooking_Package());
	    	booking.setTime_In(booking.getTime_In());
	    	booking.setTime_Out(booking.getTime_Out());
	        
	        Booking updatedBooking = bookingRepository.save(booking);
	        return ResponseEntity.ok(updatedBooking);
	    } 
	    
	    @DeleteMapping("/bookings/{Booking_Id}")
	    public Map<String, Boolean> deleteBooking(@PathVariable(value = "Booking_Id")  Long Booking_Id)
	         throws ResourceNotFoundException {
	    	Booking booking = bookingRepository.findById(Booking_Id)
	       .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + Booking_Id));

	    	bookingRepository.delete(booking);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	 
	        return response;
	    }
	    

}

/*import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import com.itp.hotel.model.Booking;
import com.itp.hotel.model.Customer;
import com.itp.hotel.model.Event;
import com.itp.hotel.repository.BookingRepository;
import com.itp.hotel.repository.CustomerRepository;
import com.itp.hotel.repository.EventRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")


public class BookingController {
	/*
	@Autowired
    private BookingRepository bookingRepository;
	
	 @GetMapping("/bookings")
	    public List<Booking> getAllBookings() {
	        return bookingRepository.findAll();
	    }
	    
	    @GetMapping("/bookings/{Booking_Id}")
	    public ResponseEntity<Booking> getBookingById(@PathVariable(value = "Booking_Id") Long Booking_Id)
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
	    public ResponseEntity<Booking> updateBooking(@PathVariable(value = "Booking_Id")  Long Booking_Id,
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
	    
	    @DeleteMapping("/bookings/{Booking_Id}")
	    public Map<String, Boolean> deleteBooking(@PathVariable(value = "Booking_Id")  Long Booking_Id)
	         throws ResourceNotFoundException {
	    	Booking booking = bookingRepository.findById(Booking_Id)
	       .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + Booking_Id));

	    	bookingRepository.delete(booking);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	 
	        return response;
	    }
	   
	
	 @Autowired
	    private BookingRepository bookRep;
	    @Autowired
	    private CustomerRepository cusRep;
	    @Autowired
	    private EventRepository eventRep;
	    @GetMapping("/bookings")
	    public List<Booking> getAllUsers() {
	        return bookRep.findAll();
	    }

	    

	    @PostMapping("/bookings/{id}/{cid}")
	    public Booking createUser( @PathVariable(value = "id") Integer kl,@PathVariable(value = "cid") Long kx, @RequestBody Booking book) {

	        Optional<Event> m =  eventRep.findById(kl);
	        Optional<Customer> bx = cusRep.findById(kx);
	        Booking b = new Booking();
	        b.setCus_Name(book.getCus_Name());
	        b.setCus_Phone_No(book.getCus_Phone_No());
	        b.setBooking_Type(book.getBooking_Type());
	        b.setBooking_Package(book.getBooking_Package());
	        b.setNum_Participants(book.getNum_Participants());
	        b.setTime_In(book.getTime_In());
	        b.setTime_Out(book.getTime_Out());
	        b.setDate(book.getDate());
	        b.setCustomer(bx.get());
	       b.setEvent(m.get());
	        return bookRep.save(b);
	    }

}*/