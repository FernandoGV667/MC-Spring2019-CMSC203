package com.fgonzalesv;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * A Ticket class to receive input from user about a driving ticket, calculate fine and output fine notice.
 * @author Fernando Gonzales-Vigil
 *
 */
public class Ticket {
	private String name;
	private int speed;
	private int speedLimit;
	private boolean school;
	private boolean work;
	
	/**
	 * Creates a Ticket object with the given name, speed, speed limit, school zone and work zone.
	 * @param name name of the violator
	 * @param speed speed violator was going
	 * @param speedLimit the speedlimit
	 * @param school whether in a school zone or not
	 * @param work whether in a work zone or not
	 */
	public Ticket(String name, int speed, int speedLimit, boolean school, boolean work) {
		super();
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.school = school;
		this.work = work;
	}

	/**
	 * Creates a Ticket object with the given name, speed, speed limit.
	 * @param name name of the violator
	 * @param speed speed violator was going
	 * @param speedLimit the speedlimit
	 */
	public Ticket(String name, int speed, int speedLimit) {
		super();
		this.name = name;
		this.speed = speed;
		this.speedLimit = speedLimit;
		this.school = false;
		this.work = false;
	}

	/**
	 * Get name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * @param name name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get speed
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Set speed
	 * @param speed speed to be set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Get speedlimit
	 * @return speedLimit
	 */
	public int getSpeedLimit() {
		return speedLimit;
	}

	/**
	 * Set speedlimit
	 * @param speedLimit speedLimit to be set
	 */
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
	}

	/**
	 * Whether violater was in school zone
	 * @return true if in school zone, false if not
	 */
	public boolean isSchoolZone() {
		return school;
	}

	/**
	 * Set if violator was in school zone 
	 * @param school if violater was in school zone
	 */
	public void setSchoolZone(boolean school) {
		this.school = school;
	}

	/**
	 * Whether violator was in work zone
	 * @return true if in work zone, false if not
	 */
	public boolean isWorkZone() {
		return work;
	}

	/**
	 * Set if violator was in work zone 
	 * @param work if violater was in work zone
	 */
	public void setWorkZone(boolean work) {
		this.work = work;
	}
	
	/**
	 * Calculate the speeding fine. Calculate the fine based on the following:
	 * 1 - 10 MPH over limit - $140 minimum
	 * school zone - $200
	 * work zone - $250
	 * 
	 * 11 - 30 MPH over limit - $195 minimum
	 * school zone - $310
	 * work zone - $360
	 * surcharge of $300 for 21 - 30 MPH over
	 * 
	 * 31 MPH + over limit - must appear personally
	 * surcharge of $450 for 31 - 40 MPH over
	 * surcharge of $675 for 41 MPH and up 
	 * @return the fine for this speed based on the speedLimit
	 */
	public double calculateFine() {
		double fine = 0;
		int overspeed = speed-speedLimit;
		
		if (overspeed > 30) {
			if (work) {
				fine = 360;
			} else if(school) {
				fine = 310;
			}
			
			if (overspeed > 40) {
				fine += 675;
			} else {
				fine += 450;
			}
			
		} else if (overspeed > 10) {

			if (work) {
				fine = 360;
			} else if (school) {
				fine = 310;
			} else {
				fine = 195;
			}
			
			if(overspeed > 20) {
				fine += 300;
			} 
			
		} else if (overspeed > 0) {
			
			if (work) {
				fine = 250;
			} else if (school) {
				fine = 200;
			}  else {
				fine = 140;
			}
		}
		
		return fine;
	}
	/**
	 * Return the ticketType of Payable or Must Attend
	 * @return the ticketType
	 */
	private String TicketType() {
		if (speed-speedLimit > 30) {
			return "MUST APPEAR";
		} 
		return "PAYABLE";
	}
	
	/**
	 * Get the ticketType
	 * @return the ticketType
	 */
	public String getTicketType() {
		return TicketType();
	}
	
	/**
	 * Generate a random ticket number between 100,000 and 999,999
	 * @return random ticket number
	 */
	private int generateTicketNum() {
		return new Random().nextInt(900000) + 100000;
	}
	
	/**
	 * Get the ticket number
	 * @return  the ticket number
	 */
	public int getTicketNum() {
		return generateTicketNum();
	}
	
	
	/**
	 * Generate a day of the month between 1 and 31 of October 2018 to appear in court
	 * @return the day of the month to appear at court
	 */
	private int generateCourtDate() {
		return new Random().nextInt(31)+1;
	}
	
	/**
	 * Generate a string to describe the driving zone according to ticket conditions.
	 * @return the driving zone string depending if work or school is true, or both are false.
	 */
	private String getDrivingZone() {
		if (work) return "work";
		else if (school) return "school";
		else return "";
	}
	
	/**
	 * Print a notice to be sent to the speeder Must follow exact format. See assignment description
	 * Note: There are no blank lines before "Department of Motor Vehicles"
	 * There are two blank lines between "Automated Traffic Enforcement" and the "Dear (name)"
	 * There is one black line between "Dear (name)" and "Please pay ..."
	 * Based on the following data:
	 * Name: Betty Boop
	 * Speed: 58
	 * Speed Limit: 25
	 * School Zone: No
	 * Work Zone: Yes
	 * 
	 * Department of Motor Vehicles
	 * Automated Traffic Enforcement
	 * 
	 * 
	 * Dear Betty Boop,
	 * 
	 * Please pay the following speeding fine of $450.00 to the DMV within 10 days of
	 * receiving this notice to avoid a driver’s license suspension. You are being fined
	 * for going 58 MPH in a 25 MPH work zone.
	 * 
	 * Ticket Type: MUST APPEAR
	 * You must appear at the County Court House on October 5, 2018 (day is randomly generated)
	 * Ticket Number: 936826 (number is randomly generated)
	 * 
	 * Returned checks are subject to a returned check fee of $35.00.
	 * 
	 * Sincerely,
	 * Fernando Gonzales-Vigil 
	 * 
	 * @return the notice to be sent to the speeder
	 */
	public String printNotice() {
		NumberFormat formatter = new DecimalFormat("#0.00"); 
		
		return  "Department of Motor Vehicles\n" + 
				"Automated Traffic Enforcement\n" + 
				"\n\n" + 
				"Dear "+ name + ",\n" + 
				"\n" + 
				"Please pay the following speeding fine of $" + formatter.format(calculateFine()) + " to the DMV within 10 days of\n" + 
				"receiving this notice to avoid a driver’s license suspension. You are being fined\n" + 
				"for going " + speed + " MPH in a " + speedLimit + " MPH " + getDrivingZone() + " zone.\n" + 
				"\n" + 
				"Ticket Type: " + getTicketType() + "\n" + 
				"You must appear at the County Court House on October " + generateCourtDate() + ", 2018\n" + 
				"Ticket Number: " + getTicketNum() + "\n" + 
				"\n" + 
				"Returned checks are subject to a returned check fee of $35.00.\n" + 
				"\n" + 
				"Sincerely,\n" + 
				"Fernando Gonzales-Vigil";
	}

	/** 
	 * A toString method that returns a string representation of a Ticket, including the ticket number and ticket type. 
	 * No specific format required.
	 *@Overrides toString in class java.lang.Object
	 */
	@Override
	public String toString() {
		return "Ticket [name=" + name + ", speed=" + speed + ", speedLimit=" + speedLimit + ", school=" + school + ", work=" + work + ", ticketNumber=" + generateTicketNum()
				+ ", ticketType=" + getTicketType() + "]";
	}
	
	
	
	
}
