package com.cg.bean;

import java.sql.Date;


public class BookingDetails {
	

	private int bookingId;

/*	private String roomId;

	private String userId;*/
	
	private RoomDetails room;
	
	private Users user;
		private	String bookedFrom;

	private	String bookedTo;
	private int numberOfAdults;
	
	private int numberOfChildren;
	private double amount;

	
	public String getBookedFrom() {
		return bookedFrom;
	}


	public String getBookedTo() {
		return bookedTo;
	}

	
	public void setBookedFrom(String bookedFrom) {
		this.bookedFrom = bookedFrom;
	}


	public void setBookedTo(String bookedTo) {
		this.bookedTo = bookedTo;
	}





	

	//getters and setters
/*	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
*/	
	
	
	
	/*public String getRoomId() {
		return roomId;
	}*/
	public RoomDetails getRoom() {
		return room;
	}


	public void setRoom(RoomDetails room) {
		this.room = room;
	}



	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	/*public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}*/
	/*public LocalDate getBookedFrom() {
		return bookedFrom;
	}
	public void setBookedFrom(LocalDate bookedFrom) {
		this.bookedFrom = bookedFrom;
	}
	public LocalDate getBookedTo() {
		return bookedTo;
	}
	public void setBookedTo(LocalDate bookedTo) {
		this.bookedTo = bookedTo;
	}*/
	
	
	
	
	
	public int getNumberOfAdults() {
		return numberOfAdults;
	}
	


	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	public int getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
