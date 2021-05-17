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
import com.itp.hotel.model.ResModificationRequest;
import com.itp.hotel.model.Room;
import com.itp.hotel.repository.ResModificationRequestRepository;



@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")

public class Res_Modification_RequestController {

	
	
	  @Autowired
	    private ResModificationRequestRepository res_Modification_RequestRepository;

	  
	  
	    @GetMapping("/res_modification_requests")
	    public List<ResModificationRequest> getAllRes_Modification_Requests() {
	        return res_Modification_RequestRepository.findAll();
	    }

	    @GetMapping("/res_modification_requests/{Reserve_M_Id}")
	    public ResponseEntity<ResModificationRequest> getRes_Modification_RequestById(@PathVariable Integer Reserve_M_Id){
	       
	        ResModificationRequest res_Modification_Request = res_Modification_RequestRepository.findById(Reserve_M_Id)
	         .orElseThrow(() -> new ResourceNotFoundException("Res_Modification_Request not found for this id :: " + Reserve_M_Id));
	        return ResponseEntity.ok(res_Modification_Request);
	    }
	 
	    @PostMapping("/res_modification_requests")
	    public ResModificationRequest createRes_Modification_Request(@Valid @RequestBody ResModificationRequest res_Modification_Request) {
	        return res_Modification_RequestRepository.save(res_Modification_Request);
	    }
	 
	    @PutMapping("/res_modification_requests/{Reserve_M_Id}")
	    public ResponseEntity<ResModificationRequest> updateRes_Modification_Request(@PathVariable Integer Reserve_M_Id,
	         @RequestBody ResModificationRequest res_Modification_RequestDetails) throws ResourceNotFoundException {
	    	 ResModificationRequest res_Modification_Request = res_Modification_RequestRepository.findById(Reserve_M_Id)
	        .orElseThrow(() -> new ResourceNotFoundException("Res_Modification_Request not found for this id :: " + Reserve_M_Id));

	    	 
	    	 res_Modification_Request.setRm_id(res_Modification_Request.getRm_id());
//	        res_Modification_Request.setReserve_M_Id(res_Modification_Request.getReserve_M_Id());
	        res_Modification_Request.setRm_Type(res_Modification_Request.getRm_Type());
	        res_Modification_Request.setR_Reason(res_Modification_Request.getR_Reason());
	        res_Modification_Request.setR_Message(res_Modification_Request.getR_Message());
	        res_Modification_Request.setRm_Req_Date(res_Modification_Request.getRm_Req_Date());
	      
	        
	        
	        
	       ResModificationRequest updatedRes_Modification_Request = res_Modification_RequestRepository.save(res_Modification_Request);
	       return ResponseEntity.ok(updatedRes_Modification_Request);
	    }
	
	    @DeleteMapping("/res_modification_requests/{Reserve_M_Id}")
	    public Map<String, Boolean> deleteRes_Modification_Request(@PathVariable Integer Reserve_M_Id)
	         throws ResourceNotFoundException {
	    	 ResModificationRequest res_Modification_Request = res_Modification_RequestRepository.findById(Reserve_M_Id)
	       .orElseThrow(() -> new ResourceNotFoundException("Res_Modification_Request not found for this id :: " + Reserve_M_Id));

	    	res_Modification_RequestRepository.delete(res_Modification_Request);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}


