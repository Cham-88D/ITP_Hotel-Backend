package com.itp.hotel.model;


import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")

public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RoomId;
	
	
	@Column(name = "room_type", length=20,nullable=false)
	private String Room_Type;
	
	@Column(name = "room_status", length=20,nullable=false)
	private String Room_Status;
	
	@Column(name = "room_price",nullable=false)
	private double R_Price;
	
	
	
	public Room() {
		
		
		
	}



	public Room(  String room_Type, String room_Status, double r_Price) {
		super();
		
		Room_Type = room_Type;
		Room_Status = room_Status;
		R_Price = r_Price;
	}



	public void setRoomId(int roomId) {
		RoomId = roomId;
	}


	public void setRoom_Type(String room_Type) {
		Room_Type = room_Type;
	}



	public void setRoom_Status(String room_Status) {
		Room_Status = room_Status;
	}



	public void setR_Price(double r_Price) {
		R_Price = r_Price;
	}



	public int getRoomId() {
		return RoomId;
	}



	public String getRoom_Type() {
		return Room_Type;
	}



	public String getRoom_Status() {
		return Room_Status;
	}



	public double getR_Price() {
		return R_Price;
	}
	
	
	
	
	
}
