package com.itp.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itp.hotel.model.Barroom_Order;
import com.itp.hotel.model.Beverage;
import com.itp.hotel.model.Bill;
import com.itp.hotel.model.User;
import com.itp.hotel.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> listAll(){
		return repo.findAll();
	}
	
	public void save(User user) {
		repo.save(user);
	}
	
	public User get(long id) {
		User u = repo.getUserById(id);
		return  u;
	}
	
	public User getUserByUsername(String username) {
		User u = repo.getUserByUsername(username);
		return  u;
	}
}
