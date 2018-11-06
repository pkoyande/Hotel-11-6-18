package com.cg.bean;



//import java.sql.Blob;


public class RoomDetails {
	
	
	//private int hotelId;
	private static int roomId=300;
	private static int count=0;
	private Hotel hotel;
	private String roomNo;
	
	private String roomType;
	
	private double perNightRate;
	private String availability;
//	private Blob photo;


	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}



/*	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
*/
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId() {
		this.roomId = this.roomId+count;
		count++;
	}

	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getPerNightRate() {
		return perNightRate;
	}
	public void setPerNightRate(double perNightRate) {
		this.perNightRate = perNightRate;
	}
	/*public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}*/
	/*public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	*/

	public String getAvailability() {
		return availability;
	}


}
