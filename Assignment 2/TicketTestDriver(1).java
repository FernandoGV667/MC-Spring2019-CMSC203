

import java.util.Scanner;

/**  	
 * 
 * This is a driver to test the Ticket class
 * @author Professor Kartchner
 */

public class TicketTestDriver
{
	public static void main(String[] args)
	{
		Ticket ticket1, ticket2, ticket3;

		ticket1 = new Ticket("Bob Brown",36, 25, true, false);
		ticket2 = new Ticket("Betty Boop",66,45,false, true);
		ticket3 = new Ticket("Edward Cullen",88,45);

		//test the getName
		if(!"Bob Brown".equals(ticket1.getName())) print("getName Error 1");
		if(!"Betty Boop".equals(ticket2.getName())) print("getName Error 2");

		//test the getSpeed
		if(!(36==ticket1.getSpeed())) print("getSpeed Error 1");
		if(!(66==ticket2.getSpeed())) print("getSpeed Error 2");
		if(!(88==ticket3.getSpeed())) print("getSpeed Error 3");

		//test the getSpeedLimit
		if(!(25==ticket1.getSpeedLimit())) print("getSpeedLimit Error 1");
		if(!(45==ticket2.getSpeedLimit())) print("getSpeedLimit Error 2");
		if(!(45==ticket3.getSpeedLimit())) print("getSpeedLimit Error 3");

		//test the isSchoolZone
		if(!(ticket1.isSchoolZone()==true)) print("isSchoolZone Error 1");
		if(!(ticket2.isSchoolZone()==false)) print("isSchoolZone Error 2");
		if(!(ticket3.isSchoolZone()==false)) print("isSchoolZone Error 3");

		//test the isWorkZone
		if(!(ticket1.isWorkZone()==false)) print("isWorkZone Error 1");
		if(!(ticket2.isWorkZone()==true)) print("isWorkZone Error 2");
		if(!(ticket3.isWorkZone()==false)) print("isWorkZone Error 3");	

		//test calculateFine
		if(!(310.0==ticket1.calculateFine())) print("calculateFine Error 1");
		if(!(660.0==ticket2.calculateFine())) print("calculateFine Error 2");
		if(!(675.0==ticket3.calculateFine())) print("calculateFine Error 3");

		//test getTicketType
		if(!"PAYABLE".equals(ticket1.getTicketType())) print("getTicketType Error 1");
		if(!"PAYABLE".equals(ticket2.getTicketType())) print("getTicketType Error 2");
		if(!"MUST APPEAR".equals(ticket3.getTicketType())) print("getTicketType Error 3");

		//test printNotice
		String result = ticket1.printNotice();
		Scanner scan = new Scanner(result);
		if(!"Department of Motor Vehicles".equals(scan.nextLine())) print("printNotice Error 1");
		scan.nextLine(); //Automated Traffic Enforcement
		scan.nextLine(); scan.nextLine(); //two blank lines
		if(!"Dear Bob Brown,".equals(scan.nextLine())) print("printNotice Error 2");
		scan.nextLine(); // blank line
		if(!(scan.nextLine().contains("fine of $310.00"))) print("printNotice Error 3");
		scan.nextLine();//receiving this notice
		String line = scan.nextLine();
		if(!(line.contains("for going 36 MPH in a 25 MPH school zone"))) print("printNotice Error 4");
		scan.nextLine(); //blank line
		line = scan.nextLine();
		if(!(line.contains("Ticket Type: PAYABLE"))) print("printNotice Error 5");
		scan.close();

		//test toString
		String result1 = ticket1.toString();
		if(!(result1.contains("Bob Brown"))) print("toString Error 1");
		if(!(result1.contains("36"))) print("toString Error 2");
		if(!(result1.contains("25"))) print("toString Error 3");
		if(!(result1.contains("PAYABLE"))) print("toString Error 4");

		//test setName
		ticket1.setName("Ronald Reagan");
		if(!"Ronald Reagan".equals(ticket1.getName())) print("setName Error 1");

		//test setSpeed
		ticket2.setSpeed(68);
		if(!(68==ticket2.getSpeed())) print("setSpeed Error 1");

		//test setSpeedLimit
		ticket3.setSpeedLimit(50);
		if(!(50==ticket3.getSpeedLimit())) print("setSpeedLimit Error 1");

		//test setSchoolZone
		ticket1.setSchoolZone(false);
		if(!(ticket1.isSchoolZone()==false)) print("setSchoolZone Error 1");
		ticket2.setSchoolZone(true);
		if(!(ticket2.isSchoolZone()==true)) print("setSchoolZone Error 2");

		//test setWorkZone
		ticket1.setWorkZone(true);
		if(!(ticket1.isWorkZone()==true)) print("setWorkZone Error 1");
		ticket2.setWorkZone(false);
		if(!(ticket2.isWorkZone()==false)) print("setWorkZone Error 2");
		print("Test complete");
	}
	
	public static void print(String message)
	{
		System.out.println(message);
	}
}

