package com.cg.dao;



import java.sql.Date;
import java.util.List;

import com.cg.bean.BookingDetails;
import com.cg.bean.Hotel;
import com.cg.bean.RoomDetails;
import com.cg.bean.Users;



public interface IBookingDAO {
	//18 Functions
	
	
	//Users
	public String registerUser(Users user)throws Exception;  //Add User
	public String validateUser(String username,String password) throws Exception;  //Validate User
	public Users getUser(int userId) throws Exception; 
	
	//Hotels
	public String addHotels(Hotel hotel)throws Exception; //Add Hotel - Admin
	public Hotel SearchHotels(String hotelname)throws Exception; //Search Hotel - User
	public void viewAllHotels() throws Exception;  //View Hotel - User
	public boolean deleteHotel(int hotelId) throws Exception; //Delete Hotel - Admin
	public Hotel getHotel(int hotelId) throws Exception;  
	public boolean modifyHotel(Hotel hotel) throws Exception;  //Modify Hotel - Admin 
	
	
	//Rooms
	public void searchRoom(int hotelId)throws Exception; // Search Room - User
	public int addRoom(RoomDetails room) throws Exception; // Add Room - ADMIN
	public boolean deleteRoom(int roomId) throws Exception; // Delete Room - ADMIN
	public RoomDetails getRoom(int roomId) throws Exception; 
	public boolean modifyRoom(RoomDetails room) throws Exception; //Modify Room - ADMIN
	
	//Booking
	public int addBooking(BookingDetails book) throws Exception; // User
	public BookingDetails viewBookingsForHotel(String hotelId) throws Exception; // ADMIN
	public BookingDetails viewBookingsForDate(Date date) throws Exception; // ADMIN
	public BookingDetails getBooking(int BookingId) throws Exception;
	
	
	
	
}
