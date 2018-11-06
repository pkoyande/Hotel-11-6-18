package com.cg.ui;

import java.util.List;
import java.util.Scanner;


import com.cg.bean.BookingDetails;
import com.cg.bean.Hotel;
import com.cg.bean.RoomDetails;
import com.cg.bean.Users;
import com.cg.dao.BookingDAO;
import com.cg.dao.IBookingDAO;
import com.cg.service.BookingService;
import com.cg.service.IBookingService;

public class BookingClient {



	public static void main(String[] args) {
		 IBookingService service = new BookingService();
		 IBookingDAO bref = new BookingDAO();
		Client c = new Client();
		System.out.print("\n\t Welcome to Hotel Booking Management System\n"
				+ "1. Register into the system ( For New User ).\n" 
				+ "2. Login to the system.\n"
				+ " Enter choice: ");

		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			// IBookingService service = new BookingService();
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
			System.out.print("Your role? (User): ");
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
				String abc = service.addUser(user);

				System.out.println("USer Added Successfully  " + abc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
			
		case 2: {

			Scanner scan = new Scanner(System.in);
			System.out.print("Enter User Name: ");
			String username = scan.next();
			System.out.print("Enter Password: ");
			String password = scan.next();
			try {
				// Scanner scn= new Scanner(System.in);
				String flag = service.validateUser(username, password);
				if (flag.equalsIgnoreCase("user")) {
					System.out.print("\n\tMENU\n"
							+ "1. View Hotels \n" 
							+ "2. Search Hotel Rooms\n"
							+ "3. Book Hotel Rooms.\n" 
							+ "4. Exit\n" 
					
							+ " Enter choice: ");

					int choice = scan.nextInt();
					switch (choice) {
					case 1:
						//while(true){
							
							/*if(clist.size()==0){
								System.out.println("No Hotels Available.");
								break;
							}*/
							
							System.out.println("Following Hotels are available:");
							bref.viewAllHotels();
							//int i=1;
							/*for(Hotel h:clist)
							{
								System.out.print(i + h.getHotelName() + " " + h.getAddress() + " " + h.getCity() + "  " + h.getDescription() + "  " + h.getEmail() + "  " + h.getEmail() + "  "
								+ "  " + h.getFax() + "  " + h.getPhoneNo1() + "  " + h.getPhoneNo2() + "  " + h.getRating() + "  " + h.getAverageRatePerNight()+ " "+ h.getHotelId());
								i++;
							
							}*/
							
						//}
						break;
					case 2:

						//RoomDetails room = new RoomDetails();
						System.out.println("Enter Hotel ID");
						int hotelId = scan.nextInt();
						service.searchRoom(hotelId);

						break;
					case 3:
						BookingDetails book = new BookingDetails();

						System.out.println("Enter Date from (dd-mm-yyyy)");
						book.setBookedFrom(scan.next());

						System.out.println("Enter Date To(dd-mm-yyyy)");
						book.setBookedTo(scan.next());

						System.out.println("Enter no. of Adults");
						book.setNumberOfAdults(scan.nextInt());

						System.out.println("Enter no. of children");
						book.setNumberOfChildren(scan.nextInt());

						System.out.println("Enter Booking amount");
						book.setAmount(scan.nextDouble());

						int bid = service.addBooking(book);

						System.out.println("Booked Room sucessfully with booking ID " + bid);

						break;
					case 4:
						System.exit(0);
					
						
					default:
						break;
					}
				}

				else if (flag.equalsIgnoreCase("admin")) {
					System.out.println("\n\tMENU\n" 
				+ "1. Perform Hotel Management.\n" 
				+ "2. Perform Room Management.\n"
							+ "3. Exit" + " Enter choice: ");
					int chi = scan.nextInt();
					switch (chi) {
					case 1:
						performHotelManagement();
						break;
					case 2:
						performRoomManagement();
						break;
					case 3:
						System.exit(0);
					default:
						System.out.println("Please enter a valid option!");
					}
				}

				else
					System.out.println("Invalid User");

			} catch (

			Exception e) {
				System.out.println(e.getMessage());
			}
		}

		}

	}

	private static void performRoomManagement() {
		// TODO Auto-generated method stub
		
		

	}

	private static void performHotelManagement() {
		while (true) {

			System.out.println("PERFORM HOTEL MANAGEMENT");
			System.out.println("1. Add a new hotel to database."); // Done
			System.out.println("2. Delete an existing hotel in database.");
			System.out.println("3. Go to previous menu.\n");

			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				Hotel hotel = new Hotel();
				String HotelName = null;
				System.out.println("ADD HOTEL TO DATABASE");
				System.out.print("Enter Hotel Name: ");
				hotel.setHotelName(sc.next());

				System.out.print("Enter City Name: ");
				hotel.setCity(sc.next());

				System.out.print("Enter Hotel Address ");
				hotel.setAddress(sc.next());

				System.out.print("Enter Hotel Description: ");
				hotel.setDescription(sc.next());

				System.out.print("Enter Average Rate per night: ");
				hotel.setAverageRatePerNight(sc.nextDouble());

				System.out.print("Enter Rating of Hotel: ");
				hotel.setRating(sc.next());

				System.out.print("Enter email of Hotel ");
				hotel.setEmail(sc.next());

				System.out.print("Enter Hotel Fax: ");
				hotel.setFax(sc.next());

				System.out.print("Enter Hotel Phone 1: ");
				hotel.setPhoneNo1(sc.next());

				System.out.print("Enter Hotel Phone 2: ");
				hotel.setPhoneNo2(sc.next());

				try {
					//HotelName = service.addHotels(hotel);
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}
				if (HotelName != null) {
					System.out.println("Hotel added to the database. Hotel name is " + HotelName);
				} else {
					System.out.println("Hotel not added!");
				}

				break;

			case 2:
				Scanner scn = new Scanner(System.in);
				System.out.println("Enter Hotel Id to delete the Hotel: ");
				int hotelId = scn.nextInt();

				boolean flag1 = false;
				try {
					//flag1 = service.deleteHotel(hotelId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (flag1)
					System.out.println("Hotel with " + hotelId + "deleted sucessfully!!");
				// deleteHotel();
				break;

			case 3:
				return;

			default:
				System.out.println("Please enter a valid option!");
			}
		}
	}

	// TODO Auto-generated method stub

}
