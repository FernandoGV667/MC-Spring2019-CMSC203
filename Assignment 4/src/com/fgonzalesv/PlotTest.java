package com.fgonzalesv;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlotTest {
	private Plot plot1, plot3, plot4, plot5, plot6, plot9, plot10, plot11;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2,2,6,6); 
		plot3 = new Plot(1,1,3,2);
		plot4 = new Plot(6,1,4,2);
		plot5 = new Plot(3,4,4,3);
		plot6 = new Plot(6,5,3,1);
		plot9 = new Plot(1,4,2,1);
		plot10 = new Plot(9,2,2,2);
		plot11 = new Plot(2,2,2,1);
	}

	@After
	public void tearDown() throws Exception {
		plot1=null;
	}

	@Test
	public void testOverlaps1() {
		assertTrue(plot1.overlaps(plot5)); //plot5 is entirely inside plot1
		assertTrue(plot5.overlaps(plot1));
	}
	
	@Test
	public void testOverlaps2() {
		assertTrue(plot1.overlaps(plot3)); //plot3 overlaps the lower left corner of plot1
		assertTrue(plot3.overlaps(plot1));
		assertTrue(plot1.overlaps(plot4)); //plot4 overlaps the lower right corner of plot1
		assertTrue(plot4.overlaps(plot1));
	}
	@Test
	public void testOverlaps4() {
		assertTrue(plot1.overlaps(plot9)); //plot9 overlaps the left side of plot1
		assertTrue(plot9.overlaps(plot1));
		assertTrue(plot1.overlaps(plot6)); //plot6 overlaps the right side of plot1
		assertTrue(plot6.overlaps(plot1));
	}
	@Test
	public void testOverlaps6() {
		assertFalse(plot3.overlaps(plot4)); //plot3 does not overlap plot4
		assertFalse(plot4.overlaps(plot3));
		assertFalse(plot1.overlaps(plot10)); //plot1 does not overlap plot10
		assertFalse(plot10.overlaps(plot1));
	}
	@Test
	public void testEncompasses1() {
		assertTrue(plot1.encompasses(plot5)); //plot5 is contained in plot1
		assertFalse(plot5.encompasses(plot1));
		assertTrue(plot1.encompasses(plot11)); //plot11 is contained in plot1
		assertFalse(plot11.encompasses(plot1));	
		
		assertFalse(plot3.encompasses(plot1)); //plot3 does not encompass plot1
		assertFalse(plot1.encompasses(plot3)); //plot1 does not encompass plot3
	}

}
