package com.fgonzalesv;

import java.util.Scanner;

/**
 * An application that will calculate the fine for a speeding ticket and then print
 * a notice that will be mailed to the violator.
 * 
 * @author Fernando Gonzales-Vigil
 *
 */
public class TicketDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name; 
		int speed, speedLimit;
		char school, work, repeat;
		boolean schoolZone, workZone;
		Ticket userTicket;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ticket Manager");		
		System.out.println();
		System.out.println();
		
		// REPEAT CYCLE FOR MULTIPLE TICKETS
		do {
			// SPEED TICKET INFORMATION by user
			System.out.print("Enter the name of the violator: ");
			name = scanner.nextLine();
			
			//Validate speed constraints
			do {
				System.out.print("Enter the speed of the violator (>0): ");
				speed = scanner.nextInt();
			} while(speed <= 0);
			
			//Validate speed limit constraints
			do {
				System.out.print("Enter the speed limit (>0,<=80): ");
				speedLimit = scanner.nextInt();
			} while (speedLimit <=0 || speedLimit > 80);
		
			//Validate school user input
			do {
				System.out.print("Was this in a school zone (Y/N): ");
				school = scanner.next().toLowerCase().charAt(0);
				//System.out.println(school);
			} while (school != 'y' && school != 'n');
			
			schoolZone = (school == 'y'); 
			
			//Validate work user input
			do {
				System.out.print("Was this in a work zone (Y/N): ");
				work = scanner.next().toLowerCase().charAt(0);
			} while (work != 'y' && work != 'n');
			
			workZone = (work == 'y');
			
			//Create Ticket instance with user data
			userTicket = new Ticket(name, speed, speedLimit, schoolZone, workZone);
			
			//PRINT TICKET NOTICE
			System.out.println();
			System.out.println();
			System.out.println(userTicket.printNotice());
			System.out.println();
			System.out.println();
				
			//Additional ticket
			System.out.print("Do you want to enter another ticket? (Y/N): ");
			repeat = scanner.next().toLowerCase().charAt(0);
	
		} while (repeat == 'y');
		
		scanner.close();	 
		System.out.println();
		System.out.println("Exiting the Ticket Manager\n");
					
	}
}
