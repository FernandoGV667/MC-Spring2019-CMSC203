package com.fgonzalesv;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENTTest {
  // create several (more than 2) data sets for testing. These data sets must be different
  // then the data sets in TwoDimRaggedArrayUtilityTest
  private double[][] dataSet1 = {{1.1, 2.2, 3.3, 4.4}, {5.5, 6.6, 7.7}, {8.8, 9.9}};
  private double[][] dataSet2 = {{-1, 2, -3, 4}, {-5}, {6, -7, 8}, {-9, 10, -11, 12}};
  private double[][] dataSet3 = {{-15.1, -33.3, -9.9, -71.6}, {-9.5, -21.3}, {-18.9, -11.7, -23.8}, {-17.6, -26.9, -27.7, -32.1}};

  private File inputFile,outputFile;
  
  @Before
  public void setUp() throws Exception {
    outputFile = new File("TestOut.txt");
  }

  @After
  public void tearDown() throws Exception {
    // set your data sets to null
    dataSet1 = dataSet2 = dataSet3 = null;
    inputFile = outputFile = null;
  }

  /**
   * Test getTotal method Returns the total of all the elements in the two dimensional array
   */
  @Test
  public void testGetTotalSTUDENT() {
    // Test for all your data sets
    assertEquals(49.5,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
    assertEquals(6.0,TwoDimRaggedArrayUtility.getTotal(dataSet2),.001);
    assertEquals(-319.4,TwoDimRaggedArrayUtility.getTotal(dataSet3),.001);
  }

  /**
   * Test getAverage method Returns the average of all the elements in the two dimensional array
   */
  @Test
  public void testGetAverageSTUDENT() {
    // Test for all your data sets
    assertEquals(5.5,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
    assertEquals(0.5,TwoDimRaggedArrayUtility.getAverage(dataSet2),.001);
    assertEquals(-24.569,TwoDimRaggedArrayUtility.getAverage(dataSet3),.001);
  }


  /**
   * Test getRowTotal method Returns the total of all the elements of the row. Row 0 refers to the
   * first row in the two dimensional array
   */
  @Test
  public void testGetRowTotalSTUDENT() {
    // Test for at least 2 rows within each data set
    assertEquals(19.8,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
    assertEquals(18.7,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,2),.001);
    assertEquals(2.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,0),.001);
    assertEquals(7.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,2),.001);
    assertEquals(-54.4,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,2),.001);
    assertEquals(-104.3,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,3),.001);
  }


  /**
   * Test getColumnTotal method Returns the total of all the elements in the column. If a row in the
   * two dimensional array doesn't have this column index, it is not an error, it doesn't
   * participate in this method. Column 0 refers to the first column in the two dimensional array
   */
  @Test
  public void testGetColumnTotalSTUDENT() {
    // Test for at least 2 columns in each data set
    assertEquals(15.4,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,0),.001);
    assertEquals(11.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,2),.001);
    assertEquals(-9.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2,0),.001);
    assertEquals(16.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2,3),.001);
    assertEquals(-93.2,TwoDimRaggedArrayUtility.getColumnTotal(dataSet3,1),.001);
    assertEquals(-103.7,TwoDimRaggedArrayUtility.getColumnTotal(dataSet3,3),.001);
  }


  /**
   * Test getHighestInRow method Returns the largest of all the elements in the row. Row 0 refers to
   * the first row in the two dimensional array
   */
  @Test
  public void testGetHighestInRowSTUDENT() {
    // Test for at least 2 rows within each data set
    assertEquals(4.4,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,0),.001);
    assertEquals(7.7,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,1),.001);
    assertEquals(-5.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet2,1),.001);
    assertEquals(8.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet2,2),.001);
    assertEquals(-11.7,TwoDimRaggedArrayUtility.getHighestInRow(dataSet3,2),.001);
    assertEquals(-17.6,TwoDimRaggedArrayUtility.getHighestInRow(dataSet3,3),.001);
  }

  /**
   * Test getHighestInRowIndex method Returns the index of the largest of all the elements in the
   * row. Row 0 refers to the first row in the two dimensional array
   */
  @Test
  public void testGetHighestInRowIndexSTUDENT() {
    // Test for at least 2 rows within each data set
    assertEquals(3,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,0));
    assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,1));
    assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2,1));
    assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2,2));
    assertEquals(1,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet3,2));
    assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet3,3));
  }


  /**
   * Test getLowestInColumn method Returns the smallest of all the elements in the column. If a row
   * in the two dimensional array doesn't have this column index, it is not an error, it doesn't
   * participate in this method. Column 0 refers to the first column in the two dimensional array
   */

  @Test
  public void testGetLowestInColumnSTUDENT() {
    // Test for at least 2 columns in each data set
    assertEquals(1.1,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,0),.001);
    assertEquals(3.3,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,2),.001);
    assertEquals(-9.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2,0),.001);
    assertEquals(-11.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2,2),.001);
    assertEquals(-33.3,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet3,1),.001);
    assertEquals(-71.6,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet3,3),.001);
  }

  /**
   * Test getLowestInColumnIndex method Returns the index of the smallest of all the elements in the
   * column. If a row in the two dimensional array doesn't have this column index, it is not an
   * error, it doesn't participate in this method. Column 0 refers to the first column in the two
   * dimensional array
   */

  @Test
  public void testGetLowestInColumnIndexSTUDENT() {
    // Test for at least 2 columns in each data set
    assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,0));
    assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,2));
    assertEquals(3,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2,0));
    assertEquals(3,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2,2));
    assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet3,1));
    assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet3,3));
  }


  /**
   * Test getLowestInArray method Returns the smallest of all the elements in the two dimensional
   * array.
   */
  @Test
  public void testGetLowestInArraySTUDENT() {
    // Test for each data set
    assertEquals(1.1,TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),.001);
    assertEquals(-11.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet2),.001);
    assertEquals(-71.6,TwoDimRaggedArrayUtility.getLowestInArray(dataSet3),.001);
  }

}
