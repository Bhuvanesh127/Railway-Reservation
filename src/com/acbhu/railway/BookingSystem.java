package com.acbhu.railway;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingSystem {
	
	public static TrainCurrentCapacity currentAvailability = new TrainCurrentCapacity(0,0,0,0,0);
	public List<Passanger> chart = new ArrayList<Passanger> (BookingConstants.TOTAL_BIRTH_CAPACITY);
//	public Map<Integer, Passanger> RACList = new HashMap<Integer, Passanger> ();
//	public Map<Integer, Passanger> WLList = new HashMap<Integer, Passanger> (); 
	public List<Passanger> RACList = new ArrayList<Passanger> (BookingConstants.TOTAL_RAC_TICKET);
	public List<Passanger> WLList = new ArrayList<Passanger> (BookingConstants.TOTAL_WAITING_LIST);

	/*
	 * This method is to book a train ticket
	 */
	public void bookTicket(Passanger passanger) {
		//System.out.println("BookTicket called for - "+passanger.getName());
		if ( BookingConstants.TOTAL_BIRTH_CAPACITY > findTotalCapacity()) {
			if(checkPreferedBirthAvailability(passanger.getBirthPreference())) {
				chart.add(passanger);
				System.out.println("Birth Ticket Booked Successfully for a prefered birth : " +passanger.getBirthPreference()+ ".");
			}
			else if(!checkPreferedBirthAvailability(passanger.getBirthPreference())) {
				String pre = bookTicketForAvailableBirth(passanger);
				System.out.println("Birth Ticket Booked Successfully. Birth : " +pre+ ".");
			}
		}
		else if ( BookingConstants.TOTAL_BIRTH_CAPACITY == findTotalCapacity()) {
			if(BookingConstants.TOTAL_RAC_TICKET > currentAvailability.getRACcount()) {
				currentAvailability.setRACcount(currentAvailability.getRACcount()+1);
				//RACList.put(RACList.size()+1, passanger);
				RACList.add(passanger);
				System.out.println("RAC Ticket Booked Successfully");
			}
			else if(BookingConstants.TOTAL_WAITING_LIST > currentAvailability.getWaitingListCount()) {
				currentAvailability.setWaitingListCount(currentAvailability.getWaitingListCount()+1);
				//WLList.put(WLList.size()+1, passanger);
				WLList.add(passanger);
				System.out.println("Your ticket is in waiting status");
			}
			else
				System.out.println("Sorry there is no available ticket");
		}
	}
	
	private boolean checkPreferedBirthAvailability(String preference) {
		boolean isBirthAvailable = false;		
		if(BookingConstants.TOTAL_LOWER_BIRTH_CAPACITY > currentAvailability.getLowerBirthCount() && preference.equals("L")) {
			isBirthAvailable = true;
			currentAvailability.setLowerBirthCount(currentAvailability.getLowerBirthCount()+1);
		}
		else if (BookingConstants.TOTAL_MIDDLE_BIRTH_CAPACITY > currentAvailability.getMiddleBirthCount() && preference.equals("M")) {
			isBirthAvailable = true;
			currentAvailability.setMiddleBirthCount(currentAvailability.getMiddleBirthCount()+1);
		}
		else if (BookingConstants.TOTAL_UPPER_BIRTH_CAPACITY > currentAvailability.getUpperBirthCount() && preference.equals("U")) {
			isBirthAvailable = true;
			currentAvailability.setUpperBirthCount(currentAvailability.getUpperBirthCount()+1);
		}		
		return isBirthAvailable;
	}
	
	private String bookTicketForAvailableBirth(Passanger p) {
		if(BookingConstants.TOTAL_LOWER_BIRTH_CAPACITY > currentAvailability.getLowerBirthCount()) {
			p.setBirthPreference("L");
			chart.add(p);
			currentAvailability.setLowerBirthCount(currentAvailability.getLowerBirthCount()+1);
			return p.getBirthPreference();
		}
		else if(BookingConstants.TOTAL_MIDDLE_BIRTH_CAPACITY > currentAvailability.getMiddleBirthCount()) {
			p.setBirthPreference("M");
			chart.add(p);
			currentAvailability.setMiddleBirthCount(currentAvailability.getMiddleBirthCount()+1);
			return p.getBirthPreference();
		}
		else if (BookingConstants.TOTAL_UPPER_BIRTH_CAPACITY > currentAvailability.getUpperBirthCount()) {
			p.setBirthPreference("U");
			chart.add(p);
			currentAvailability.setUpperBirthCount(currentAvailability.getUpperBirthCount()+1);
			return p.getBirthPreference();
		}
		else
			return "NA";
	}
	
	private int findTotalCapacity() {
		return currentAvailability.getLowerBirthCount()+currentAvailability.getMiddleBirthCount()+currentAvailability.getUpperBirthCount();
	}
	
	/*
	 * This method is to print the booked ticket
	 */
	public void printBookedTickets() {
		System.out.println("Birth booked : "+findTotalCapacity());
		System.out.println("RAC count    : "+currentAvailability.getRACcount());
		System.out.println("WL count     : "+currentAvailability.getWaitingListCount());
		for (Passanger pass : chart) {
			System.out.println("Birth Passanger details : "+pass.getID()+" - "+pass.getName()+" - "+pass.getBirthPreference());
		}
//		for (Map.Entry<Integer, Passanger> passRAC: RACList.entrySet()) {
//			System.out.println("RAC Passanger details : "+passRAC.getValue().getID()+" - "+passRAC.getValue().getName()+" - "+passRAC.getValue().getBirthPreference());
//		}
//		for (Map.Entry<Integer, Passanger> passWL: WLList.entrySet()) {
//			System.out.println("WL Passanger details : "+passWL.getValue().getID()+" - "+passWL.getValue().getName()+" - "+passWL.getValue().getBirthPreference());
//		}
		for (Passanger pass : RACList) {
			System.out.println("RAC Passanger details : "+pass.getID()+" - "+pass.getName()+" - "+pass.getBirthPreference());
		}
		for (Passanger pass : WLList) {
			System.out.println("WL Passanger details : "+pass.getID()+" - "+pass.getName()+" - "+pass.getBirthPreference());
		}
	}
	
	/*
	 * This method is to cancel the booked ticket
	 */
	public void cancelTicket(Passanger passanger) {
		int count = 0, cancelIndex=0;
		for (Passanger pass : chart) {
			++count;
			if (passanger.getID() == pass.getID()) {
				cancelIndex= --count;
				System.out.println("Cancelling index : "+ count);
				}
			}
				chart.remove(cancelIndex);
				if(passanger.getBirthPreference().equals("L")) 
					currentAvailability.setLowerBirthCount(currentAvailability.getLowerBirthCount()-1);
				
				else if (passanger.getBirthPreference().equals("M")) 
					currentAvailability.setMiddleBirthCount(currentAvailability.getMiddleBirthCount()-1);
				
				else if (passanger.getBirthPreference().equals("U")) 
					currentAvailability.setUpperBirthCount(currentAvailability.getUpperBirthCount()-1);
				
				checkRACandBookTicket(passanger);
		
	}
	
	private void checkRACandBookTicket(Passanger passanger) {
		if (!RACList.isEmpty()) {
			bookTicket(RACList.get(0));
			RACList.remove(0);
			currentAvailability.setRACcount(currentAvailability.getRACcount() - 1);
		}
		if (!WLList.isEmpty()) {
			bookTicket(WLList.get(0));
			WLList.remove(0);
			currentAvailability.setWaitingListCount(currentAvailability.getWaitingListCount() - 1);
		}
	}
	
	/*
	 * This method is to print the available ticket
	 */
	public void printAvailableTickets() {
		int lowerBirthAvailable = 0, middleBirthAvailable = 0, upperBirthAvailable = 0, RACavailable = 0, WLavailable=0;
		lowerBirthAvailable = BookingConstants.TOTAL_LOWER_BIRTH_CAPACITY - currentAvailability.getLowerBirthCount();
		middleBirthAvailable = BookingConstants.TOTAL_MIDDLE_BIRTH_CAPACITY - currentAvailability.getMiddleBirthCount();
		upperBirthAvailable = BookingConstants.TOTAL_UPPER_BIRTH_CAPACITY - currentAvailability.getUpperBirthCount();
		RACavailable = BookingConstants.TOTAL_RAC_TICKET - currentAvailability.getRACcount();
		WLavailable = BookingConstants.TOTAL_WAITING_LIST - currentAvailability.getWaitingListCount();
		System.out.println("lowerBirthAvailable : "+lowerBirthAvailable+". middleBirthAvailable : "+middleBirthAvailable+". upperBirthAvailable : "
				+upperBirthAvailable+". RACavailable - "+RACavailable+". WLavailable : "+WLavailable+".");
	}
}
