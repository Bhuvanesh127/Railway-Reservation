package com.acbhu.railway;

public class ReservationSystem {

	public static void main(String[] args) {
		BookingSystem bookingSystem = new BookingSystem();
		
		bookingSystem.printAvailableTickets();
		Passanger pas1 = new Passanger("Bhuvanesh", 26, "U");
		Passanger pas2 = new Passanger("AC", 26, "M");
		Passanger pas3 = new Passanger("Mani", 21, "M");
		Passanger pas4= new Passanger("Naveen", 24, "U");
		Passanger pas5 = new Passanger("Bala", 29, "U");
		Passanger pas6 = new Passanger("Shan", 28, "U");
		Passanger pas7 = new Passanger("Rja", 21, "L");
		bookingSystem.bookTicket(pas1);
		bookingSystem.bookTicket(pas2);
		bookingSystem.bookTicket(pas3);
		bookingSystem.bookTicket(pas4);
		bookingSystem.bookTicket(pas5);
		bookingSystem.bookTicket(pas6);
		bookingSystem.bookTicket(pas7);
		
		bookingSystem.printBookedTickets();
		
		bookingSystem.cancelTicket(pas2);
		bookingSystem.printBookedTickets();
		bookingSystem.printAvailableTickets();
	}

}
