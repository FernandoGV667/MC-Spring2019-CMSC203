package com.fgonzalesv;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerTestSTUDENT {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		//add tickets
		
		//add adults
        ticketList.addTicket("Avengers Endgame", "PG13", 8,15,"IMAX","Adult",0);
        ticketList.addTicket("Dune", "PG13", 11,21,"3D","Adult",0);
        ticketList.addTicket("The Goonies", "PG", 2,16,"NONE","Adult",0);
        
        //add children
        ticketList.addTicket("Shrek 5", "PG", 2,18,"3D","Child",0);
        ticketList.addTicket("Toy Story IX", "G", 5,13,"IMAX","Child",0);
        ticketList.addTicket("Lion King", "PG", 5,15,"3D","Child",0);
        
        //add employees
        ticketList.addTicket("The Exorcist", "NR", 5,19,"NONE","Employee",54321);
        ticketList.addTicket("Cool as Ice", "NR", 2,12,"NONE","Employee",65432);
        ticketList.addTicket("Tolkien", "PG13", 1,13,"IMAX","Employee",87654);
        
        //add MoviePass members
        ticketList.addTicket("Thunderdogs", "NR", 13,21,"NONE","MoviePass",99999);
        ticketList.addTicket("Thunderdogs", "G", 2,14,"IMAX","MoviePass",11111);
        ticketList.addTicket("Bobba Fett", "PG13", 3,13,"3D","MoviePass",77777);
		
	}

	@After
	public void tearDown() throws Exception {
	  //set tickets to null 
	   //(tickets reference is their location in ticketList, emptying the list means
	   // leaving the objects for GC
	  ticketList.getTicketList().clear();
	}

	/**
	 * Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		//Employees
	  assertEquals(1,ticketList.numVisits(87654));
      ticketList.addTicket("Bobba Fett", "PG13", 17,15,"3D","Employee",87654);
      assertEquals(2,ticketList.numVisits(87654));
      ticketList.addTicket("Bobba Fett", "PG13", 19,22,"3D","Employee",87654);
      assertEquals(3,ticketList.numVisits(87654));    
		
		//MoviePass members
      assertEquals(1,ticketList.numVisits(11111));
      ticketList.addTicket("Tolkien", "PG13", 6,13,"NONE","MoviePass",11111);
      assertEquals(2,ticketList.numVisits(11111));
      ticketList.addTicket("Judge Dredd", "R", 11,21,"IMAX","MoviePass",11111);
      assertEquals(3,ticketList.numVisits(11111));
		
	}

	/**
	 * Test the number of times this movie has been viewed
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		//Employees
	  assertEquals(1,ticketList.numThisMovie(54321,"The Exorcist"));
      ticketList.addTicket("La la land", "R", 5,16,"NONE","Employee",54321);
      assertEquals(1,ticketList.numThisMovie(54321,"The Exorcist"));
      ticketList.addTicket("The Exorcist", "R", 6,22,"3D","Employee",54321);
      assertEquals(2,ticketList.numThisMovie(54321,"The Exorcist"));

		//MoviePass members
      assertEquals(1,ticketList.numThisMovie(99999,"Thunderdogs"));
      ticketList.addTicket("Laberynth", "PG13", 11,14,"NONE","MoviePass",99999);
      assertEquals(1,ticketList.numThisMovie(99999,"Laberynth"));
      ticketList.addTicket("Laberynth", "PG13", 12,14,"NONE","MoviePass",99999);
      assertEquals(2,ticketList.numThisMovie(99999,"Laberynth"));	
	}

	/**
	 * Test the number of movies attended on a day
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumMoviesToday() {
		//Employees
	  assertEquals(1,ticketList.numMoviesToday(54321,5));
	  ticketList.addTicket("La la land", "R",5,18,"NONE","Employee",54321);
      assertEquals(2,ticketList.numMoviesToday(54321,5));
      ticketList.addTicket("La la land", "R", 9,19,"NONE","Employee",54321);
      assertEquals(1,ticketList.numMoviesToday(54321,9));

		//MoviePass members
      assertEquals(1,ticketList.numMoviesToday(99999,13));
      ticketList.addTicket("Tolkien", "NR", 13,15,"NONE","MoviePass",99999);
      assertEquals(2,ticketList.numMoviesToday(99999,13));
      ticketList.addTicket("Tolkien", "NR", 7,11,"NONE","MoviePass",99999);
      assertEquals(1,ticketList.numMoviesToday(99999,7));
	}

	/**
	 * Test adding tickets of the 4 types of tickets
	 */
	@Test
	public void testAddTicket() {
	  MovieTicketManager testList = new MovieTicketManager();
      //adule ticket
      assertEquals(17.54,testList.addTicket("Dune", "PG13", 11,21,"3D","Adult",0),.01);
      //child ticket
      assertEquals(8.49,testList.addTicket("Toy Story IX", "G", 5,13,"IMAX","Child",0),.01);
      //employee ticket - first movie this month
      assertEquals(0.00, testList.addTicket("The Exorcist", "NR", 5,19,"NONE","Employee",54321),.01);
      //employee ticket - second movie this month, different movie, different day
      assertEquals(0.00, testList.addTicket("The Mindbender", "NR", 8, 20,"NONE","Employee",54321),.01);
      //employee ticket - third movie this month, different movie, different day
      assertEquals(7.4, testList.addTicket("The Hills", "NR", 11,21,"NONE","Employee",54321),.01);
      //moviepass ticket - first movie this month
      assertEquals(9.99, testList.addTicket("Bobba Fett", "PG13", 3,13,"NONE","MoviePass",77777),.01);
      //moviepass ticket - second movie this month, different movie, different day
      assertEquals(0.00, testList.addTicket("Us", "R", 5,21,"NONE","MoviePass",77777),.01);
      //moviepass ticket - third movie - 3D so applies adult price
      assertEquals(17.54, testList.addTicket("Con Air", "PG13", 7,21,"3D","MoviePass",77777),.01);
      
	}

	/**
	 * Test the total of tickets sales for the month
	 */
	@Test
	public void testTotalSalesMonth() {
	  assertEquals(112.74,ticketList.totalSalesMonth(),.01);
      //add new employee who has only seen 1 movie - no change
	  ticketList.addTicket("The Exorcist", "NR", 5,19,"NONE","Employee",98765);
      assertEquals(112.74,ticketList.totalSalesMonth(),.01);
      //add same employee - second movie in month - no change
      ticketList.addTicket("The Mindbender", "NR", 8, 20,"NONE","Employee",98765);
      assertEquals(112.74,ticketList.totalSalesMonth(),.01);
      //add same employee - third movie in month - charged half of adult
      ticketList.addTicket("The Hills", "NR", 11,21,"NONE","Employee",98765);
      assertEquals(120.14,ticketList.totalSalesMonth(),.01);
      //add a new MoviePass member first movie 
      ticketList.addTicket("Bobba Fett", "PG13", 3,13,"NONE","MoviePass",2222);
      assertEquals(130.13,ticketList.totalSalesMonth(),.01);
      //add same MoviePass member with new movie - no change
      ticketList.addTicket("Us", "R", 5,21,"NONE","MoviePass",2222);
      assertEquals(130.13,ticketList.totalSalesMonth(),.01);
      //add a MoviePass member who watches a 3D movie - charge full adult
      ticketList.addTicket("Con Air", "PG13", 7,21,"3D","MoviePass",2222);
      assertEquals(147.67,ticketList.totalSalesMonth(),.01);
	}

	/**
	 * The 3D tickets sold this month in chronological order by day
	 */
	@Test
	public void testGet3DTickets() {
	  ArrayList<String> result = ticketList.get3DTickets();
      assertTrue("Day 2",result.get(0).contains("Shrek 5"));
      assertTrue("Day 3",result.get(1).contains("Bobba Fett"));
      assertTrue("Day 5",result.get(2).contains("Lion King"));
      assertTrue("Day 11",result.get(3).contains("Dune"));
      ticketList.addTicket("Mission Mars", "PG13", 4,21,"3D","Adult",0);
      ticketList.addTicket("Latitude", "PG13", 7,21,"3D","MoviePass",54321);
      result = ticketList.get3DTickets();
      assertTrue("Day 2",result.get(0).contains("Shrek 5"));
      assertTrue("Day 3",result.get(1).contains("Bobba Fett"));
      assertTrue("Day 4",result.get(2).contains("Mission Mars"));
      assertTrue("Day 5",result.get(3).contains("Lion King"));
      assertTrue("Day 7",result.get(4).contains("Latitude"));
      assertTrue("Day 11",result.get(5).contains("Dune"));	
	}

	/**
	 * All tickets sold this month in chronological order by day
	 * You don't need to worry about ordering within the day
	 */
	@Test
	public void testGetAllTickets() {
	  ArrayList<String> result = ticketList.getAllTickets();
      assertTrue("Day 1",result.get(0).contains("Day: 1"));
      assertTrue("Day 2",result.get(1).contains("Day: 2"));
      assertTrue("Day 2",result.get(2).contains("Day: 2"));
      assertTrue("Day 2",result.get(3).contains("Day: 2"));
      assertTrue("Day 2",result.get(4).contains("Day: 2"));
      assertTrue("Day 3",result.get(5).contains("Day: 3"));
      assertTrue("Day 5",result.get(6).contains("Day: 5"));
      assertTrue("Day 5",result.get(7).contains("Day: 5"));
      assertTrue("Day 5",result.get(8).contains("Day: 5"));
      assertTrue("Day 8",result.get(9).contains("Day: 8"));
      assertTrue("Day 11",result.get(10).contains("Day: 11"));
      assertTrue("Day 13",result.get(11).contains("Day: 13"));
	}

	/**
	 * The MoviePass tickets sold this month in order by MoviePass id
	 */
	@Test
	public void testGetMoviePassTickets() {
	  ArrayList<String> result = ticketList.getMoviePassTickets();
      assertTrue("11111",result.get(0).contains("11111"));
      assertTrue("77777",result.get(1).contains("77777"));
      assertTrue("99999",result.get(2).contains("99999"));
      ticketList.addTicket("Con Air", "PG13", 7,21,"3D","MoviePass",22222);
      ticketList.addTicket("The Mask", "PG13", 7,21,"3D","MoviePass",31415);
      result = ticketList.getMoviePassTickets();
      assertTrue("11111",result.get(0).contains("11111"));
      assertTrue("22222",result.get(1).contains("22222"));
      assertTrue("31415",result.get(2).contains("31415"));
      assertTrue("77777",result.get(3).contains("77777"));
      assertTrue("99999",result.get(4).contains("99999"));
	}

	/**
	 * The monthly sales report
	 */
	@Test
	public void testMonthlySalesReport(){
	  String result = ticketList.monthlySalesReport();
      Scanner scan = new Scanner(result);
      assertTrue(scan.nextLine().contains("Monthly Sales Report"));
      scan.nextLine();//blank line
      assertTrue(scan.nextLine().contains("Sales"));
      String line = scan.nextLine(); //Adult line
      assertTrue(line.contains("ADULT"));
      assertTrue(line.contains("43.84"));
      assertTrue(line.contains("3"));
      line = scan.nextLine(); //Child line
      assertTrue(line.contains("CHILD"));
      assertTrue(line.contains("29.87"));
      assertTrue(line.contains("3"));
      line = scan.nextLine(); //Employee line
      assertTrue(line.contains("EMPLOYEE"));
      assertTrue(line.contains("0.00"));
      assertTrue(line.contains("3"));
      line = scan.nextLine(); //Employee line
      assertTrue(line.contains("MOVIEPASS"));
      assertTrue(line.contains("39.03"));
      assertTrue(line.contains("3"));
	}
	
	/**
	 * Test readin from a file
	 * @throws FileNotFoundException when file is not found
	 */
	@Test
	public void testReadFile() throws FileNotFoundException {
	  PrintWriter testMovie = null;
      MovieTicketManager patrons;
      try {
          testMovie = new PrintWriter("ticketsFGV.txt"); 
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      testMovie.println("Avengers Endgame:PG13:8:15:IMAX:Adult:0");
      testMovie.println("Dune:PG13:11:21:3D:Adult:0");
      testMovie.println("The Goonies:PG:2:16:NONE:Adult:0");
      testMovie.println("Shrek 5:PG:2:18:3D:Child:0");
      testMovie.println("Toy Story IX:G:5:13:IMAX:Child:0");
      testMovie.println("Lion King:PG:5:15:3D:Child:0");
      testMovie.println("The Exorcist:NR:5:19:NONE:Employee:54321");
      testMovie.println("Cool as Ice:NR:2:12:NONE:Employee:65432");
      testMovie.println("Tolkien:PG13:1:13:IMAX:Employee:87654");
      testMovie.println("Thunderdogs:NR:13:21:NONE:MoviePass:99999");
      testMovie.println("Thunderdogs:G:2:14:IMAX:MoviePass:11111");
      testMovie.println("Bobba Fett:PG13:3:13:3D:MoviePass:77777");
      testMovie.close();
      
      patrons = new MovieTicketManager();
      patrons.readFile(new File("ticketsFGV.txt"));
      ArrayList<String> result = patrons.getAllTickets();
      assertTrue("Day 1",result.get(0).contains("Tolkien"));
      assertTrue("Day 2",result.get(1).contains("The Goonies"));
      assertTrue("Day 2",result.get(2).contains("Shrek 5"));
      assertTrue("Day 2",result.get(3).contains("Cool as Ice"));
      assertTrue("Day 2",result.get(4).contains("Thunderdogs"));
      assertTrue("Day 3",result.get(5).contains("Bobba Fett"));
      assertTrue("Day 5",result.get(6).contains("Toy Story IX"));
      assertTrue("Day 5",result.get(7).contains("Lion King"));
      assertTrue("Day 5",result.get(8).contains("The Exorcist"));
      assertTrue("Day 8",result.get(9).contains("Avengers Endgame"));
      assertTrue("Day 11",result.get(10).contains("Dune"));
      assertTrue("Day 13",result.get(11).contains("Thunderdogs"));
	}

}
