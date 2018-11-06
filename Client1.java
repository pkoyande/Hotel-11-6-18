package com.cg.ui;

import java.util.Scanner;

import com.cg.bean.BookingDetails;
import com.cg.bean.Hotel;
import com.cg.bean.RoomDetails;
import com.cg.bean.Users;
import com.cg.dao.BookingDAO;
import com.cg.dao.IBookingDAO;
import com.cg.service.BookingService;
import com.cg.service.IBookingService;

public class Client {

	IBookingService service = new BookingService();
	IBookingDAO bref = new BookingDAO();

	public static void main(String[] args) {

		Client c = new Client();
		System.out.print("\n\t Welcome to Hotel Booking Management System\n"
				+ "1. Register into the system ( For new User ).\n" + "2. Login to the system.\n" + " Enter choice: ");

		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			IBookingService service = new BookingService();
			System.out.print("Enter Name: ");
			String name = sc.next();
			System.out.print("Enter Email id: ");
			String emailid = sc.next();
			System.out.print("Enter Phone number: ");
			String phoneno = sc.next();
			System.out.print("Enter Mobile number: ");
			String mobileno = sc.next();
			System.out.print("Enter Address: ");
			String addr = sc.next();
			System.out.print("Your role? (Customer): ");
			String role = sc.next();
			System.out.print("Create your Password: ");
			String pwd = sc.next();

			Users user = new Users();
			user.setAddress(addr);
			user.setEmail(emailid);
			user.setMobileNo(mobileno);
			user.setPassword(pwd);
			user.setPhone(phoneno);
			user.setRole(role);
			user.setUserName(name);
			try {
				service.addUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// register();
			break;
		case 2: 
			c.login();
			break;
		
			
		case 3: 
			System.out.println("Exit");
			break;
		
		default:
			System.out.println("Invalid Option");
			break;
		}
		sc.close();
	}

	// private static void register() throws Exception {
	/*
	 * Scanner sc = new Scanner(System.in); System.out.print("Enter Name: ");
	 * String name = sc.next(); System.out.print("Enter Email id: "); String
	 * emailid = sc.next(); System.out.print("Enter Phone number: "); String
	 * phoneno = sc.next(); System.out.print("Enter Mobile number: "); String
	 * mobileno = sc.next(); System.out.print("Enter Address: "); String addr =
	 * sc.next(); System.out.print("Your role? (Customer): "); String role =
	 * sc.next(); System.out.print("Create your Password: "); String pwd =
	 * sc.next();
	 * 
	 * Users user = new Users(); user.setAddress(addr); user.setEmail(emailid);
	 * user.setMobileNo(mobileno); user.setPassword(pwd);
	 * user.setPhone(phoneno); user.setRole(role); user.setUserName(name);
	 */
	// String uid=service.addUser(user);
	// }

	private void login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter User Name: ");
		String username = sc.next();
		System.out.print("Enter Password: ");
		String password = sc.next();
		IBookingService bookserve= new BookingService();

		try {
			String flag = service.validateUser(username, password);
			if (flag.equalsIgnoreCase("user")) {
				System.out.print("\n\tMENU\n" + "1. Search for hotel rooms.\n" + "2. Book Hotel Rooms.\n"
						+ "3. Exit" + " Enter choice: ");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					// this.search();
					System.out.println("\n Enter Hotel Name: ");
					String hname=sc.next();
					bookserve.SearchHotels(hname);
					
					break;
				case 2:
					// this.book();
					System.out.println("\n Enter RoomId: ");
					int rid= sc.nextInt();
					System.out.println("\n UserId: ");
					int uid= sc.nextInt();
					System.out.println("\n Number of days: ");
					int nd= sc.nextInt();
					System.out.println("\n BoookedFromDate: ");
					String bfd= sc.next();
					System.out.println("\n BoookedtoDate: ");
					String btd= sc.next();
					System.out.println("\n Number of adults: ");
					int na=sc.nextInt();
					System.out.println("\n Number of children: ");
					int nc= sc.nextInt();
					double amount=bookserve.CalculatingAmount(rid, nd);
					BookingDetails bookingd= new BookingDetails(uid, bfd, btd, na, nc , amount);
					
					bookserve.addBooking(bookingd);
					
					break;
				
				case 3:
					System.exit(0);
				default:
					break;
				}
			} else if (flag.equalsIgnoreCase("admin")) {
				System.out.println("\n\tMENU\n" + "1. Perform Hotel Management.\n" + "2. Perform Room Management.\n"
						+ "\n 3.View list of hotels \n 4.Bookings of specifichotels \n 5.View bookings for specified date"+"6. Exit" + " Enter choice: ");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					performHotelManagement();
					break;
				case 2:
					performRoomManagement();
					break;
				case 3: System.out.println("\n List of hotels");
				        bookserve.viewAllHotels();
				        break;
				case 4: System.out.println("\n Enter hotel id");
				        String hid= sc.next();
				        bookserve.viewBookingsForHotel(hid);
				        break;
				case 5: System.out.println("\n Enter date(dd-mm-yyyy): ");
				        String date= sc.next();
				        bookserve.viewBookingsForDate(date);
				        break;
				case 6:
					System.exit(0);
				default:
					System.out.println("Please enter a valid option!");
				}
			}

			// ud,city,name,address,description,avg rate per
			// night,ph1,ph2,rating,email,fax
			else
				System.out.println("Invalid User");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void addHotel() {
		
		IBookingDAO daoRef = new BookingDAO();
		Hotel hb = new Hotel();
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		System.out.println("Enter Hotels's city ");
		hb.setCity(sc.next());

		System.out.println("Enter Hotels's name ");
		hb.setHotelName(sc.next());

		System.out.println("Enter Hotels's address ");
		hb.setAddress(sc.next());

		System.out.println("Enter Hotels's description ");
		hb.setDescription(sc.next());

		System.out.println("Enter Hotels's average Rate per night ");
		hb.setAverageRatePerNight(sc.nextDouble());

		System.out.println("Enter Hotels's phone number 1 ");
		hb.setPhoneNo1(sc.next());

		System.out.println("Enter Hotels's phone number 2 ");
		hb.setPhoneNo2(sc.next());

		System.out.println("Enter Hotels's rating ");
		hb.setRating(sc.next());

		System.out.println("Enter Hotels's email ");
		hb.setEmail(sc.next());

		System.out.println("Enter Hotels's fax ");
		hb.setFax(sc.next());

		try {
			daoRef.addHotels(hb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteHotel() {
		
		IBookingService bookserve=new BookingService();
		
		System.out.println("DELETE HOTEL");

		System.out.println("Enter the hotel ID of hotel to be deleted:");
		Scanner sc=new Scanner(System.in);
		int hotelId = sc.nextInt();
		try {
			boolean a = bookserve.deleteHotel(hotelId);
			if (a) {
				System.out.println("Hotel deleted from database.");
			} else {
				System.out.println("Hotel could not be deleted.");
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public void performHotelManagement() throws Exception {

		int option1 = 0;
		Hotel hotel = null;
		String hotelId = null;

		loop1: while (true) {

			System.out.println("PERFORM HOTEL MANAGEMENT");
			System.out.println("1. Add a new hotel to database."); // Done
			System.out.println("2. Delete an existing hotel in database.");
			System.out.println("3. Modify Hotel\n");
			System.out.println("4. Exit");

			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();

			switch (ch) {

			case 1:

				addHotel();
				break;

			case 2:

				deleteHotel();
				break;
				
			case 3:
				
				modifyHotel();
				break;

			case 4:
				return;

			default:
				System.out.println("Please enter a valid option!");
			}
		}
	}

	private void modifyHotel() throws Exception {
		// TODO Auto-generated method stub

		IBookingDAO daoRef = new BookingDAO();
		Hotel hb = new Hotel(); 
		
		System.out.println("\n enter Hotel Id to update: ");
		 Scanner sc=new Scanner(System.in);
		int id= sc.nextInt();
		 
		
		System.out.println("Enter Hotels's city to modify ");
		hb.setCity(sc.next());


		System.out.println("Enter Hotels's Name to modify");
		hb.setHotelName(sc.next());

		System.out.println("Enter Hotels's address to modify");
		hb.setAddress(sc.next());
		
		System.out.println("Enter Hotels's Description to modify");
		hb.setDescription(sc.next());


		System.out.println("Enter Hotels's Average rate per night to modify ");
		hb.setAverageRatePerNight(sc.nextDouble());

		System.out.println("Enter Hotels's Phone number 1 to modify");
		hb.setPhoneNo1(sc.next());
		
		System.out.println("Enter Hotels's Phone number 2 to modify");
		hb.setPhoneNo2(sc.next());


		System.out.println("Enter Hotels's rating to modify");
		hb.setRating(sc.next());

		System.out.println("Enter Hotels's Email to modify");
		hb.setEmail(sc.next());
		
		System.out.println("Enter Hotels's Fax to modify");
		hb.setFax(sc.next());
		
		
		daoRef.modifyHotel(hb);
			
		
	}

	public void performRoomManagement() throws Exception {

		

		loop1: while (true) {

			System.out.println("PERFORM ROOM MANAGEMENT");
			System.out.println("1. Add a new room to database.");
			System.out.println("2. Delete an existing room in database.");
			System.out.println("3. Go to previous menu.\n");

			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			switch (ch) {

			case 1:

				addRoom();
				break;

			case 2:

				deleteRoom();

			case 3:
				return;

			default:

				System.out.println("Please enter a valid option!");

			}
		}
	}

	private  void deleteRoom() {

		int roomId;
		System.out.println("DELETE ROOM");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the room ID of hotel to be deleted:");
		IBookingService bookingserve=new BookingService();
		roomId = sc.nextInt();
		try {
			if (bookingserve.deleteRoom(roomId)) {
				System.out.println("Room deleted from database.");
			} else {
				System.out.println("Room could not be deleted.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void addRoom() throws Exception {
		IBookingDAO daoRef = new BookingDAO();
		RoomDetails rb = new RoomDetails();
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		System.out.println("Enter Room Id ");
		rb.setRoomId(sc.nextInt());


		System.out.println("Enter Hotel ID ");
		rb.getHotel().setHotelId(sc.nextInt());
		
		
		System.out.println("Enter Room type ");
		rb.setRoomType(sc.next());

		System.out.println("Enter Rooms average Rate per night ");
		rb.setPerNightRate(sc.nextDouble());

		System.out.println("Availability ");
		rb.setAvailability(sc.next());

		int id=daoRef.addRoom(rb);
		System.out.println("\n Room: "+ id+" is created");
		
		
		
	}// end of method
	
	private void modifyRoom() throws Exception {
		// TODO Auto-generated method stub

		IBookingDAO daoRef = new BookingDAO();
		RoomDetails rb = new RoomDetails(); 
		
		System.out.println("\n enter Room type to update: ");
		 Scanner sc=new Scanner(System.in);
		int id= sc.nextInt();
		 
		
		System.out.println("enter Room type to update: ");
		rb.setRoomType(sc.next());


		System.out.println("enter Room's availability to modify");
		rb.setAvailability(sc.next());

		System.out.println("Enter Room's per night stay cost to modify");
		rb.setPerNightRate(sc.nextDouble());
		

		
		
		daoRef.modifyRoom(rb);
			
		
	}

	/*
	 * private void search() {
	 * 
	 * try { List<Hotel> hotelList = service.viewAllHotels(); for (Hotel hotel :
	 * hotelList) { System.out.println(hotel); } } catch (Exception e) {
	 * System.out.println(e.getMessage()); } }
	 */
	/*
	 * private void book() throws Exception {
	 * 
	 * Scanner sc = new Scanner(System.in); Hotel hotel = new Hotel();
	 * List<Hotel> hotelList = service.viewAllHotels(hotel); for (Hotel hotel :
	 * hotelList) { System.out.println(hotel); }
	 * 
	 * System.out.print("Enter Hotel ID: "); String hId = sc.next(); try {
	 * List<RoomDetails> roomList = service.getAllRooms(hId); for (RoomDetails
	 * rd : roomList) { System.out.println(rd); }
	 * 
	 * System.out.print("Enter Room ID to book Room: "); String roomId =
	 * sc.next(); System.out.print("Enter your ID: "); String userId =
	 * sc.next(); System.out.print("From (dd-MM-yyyy): "); String fdate =
	 * sc.next(); DateTimeFormatter format =
	 * DateTimeFormatter.ofPattern("dd-MM-yyyy"); LocalDate bookedFrom =
	 * LocalDate.parse(fdate, format);
	 * 
	 * System.out.print("To (dd-MM-yyyy): "); String tdate = sc.next();
	 * LocalDate bookedTo = LocalDate.parse(tdate, format); System.out.print(
	 * "Total number of Adults: "); int noAdult = sc.nextInt();
	 * System.out.print("Total number of Childrens: "); int noChild =
	 * sc.nextInt();
	 * 
	 * BookingDetails bookingDetails = new BookingDetails();
	 * bookingDetails.setRoomId(roomId); bookingDetails.setUserId(userId);
	 * bookingDetails.setBookedFrom(bookedFrom);
	 * bookingDetails.setBookedTo(bookedTo);
	 * bookingDetails.setNumberOfAdults(noAdult);
	 * bookingDetails.setNumberOfChildren(noChild);
	 * 
	 * BookingDetails bid = service.addBookingDetails(bookingDetails);
	 * System.out.println("Your Booking ID: " + bid.getBookingId()); } catch
	 * (Exception e) { System.out.println(e.getMessage()); } sc.close(); }
	 *//*
		 * private void view() { Scanner sc = new Scanner(System.in);
		 * System.out.print("Enter Booking ID: "); String bid = sc.next(); try {
		 * BookingDetails bookingDetails = service.viewBookingDetails(bid);
		 * System.out.println(bookingDetails); } catch (Exception e) {
		 * System.out.println(e.getMessage()); } sc.close(); }
		 */
}
