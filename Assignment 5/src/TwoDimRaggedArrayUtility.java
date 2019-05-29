package com.fgonzalesv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Manipulates a two-dimensional ragged array of doubles. This utility class will be used to create
 * a Sales Report for Retail District. It will accommodate positive and negative numbers.
 * 
 * @author Fernando Gonzales-Vigil
 *
 */
public class TwoDimRaggedArrayUtility {

  /**
   * Returns the average of the elements in the two dimensional array
   * 
   * @param data the two dimensional array getting the average of
   * @return the average of the elements in the two dimensional array (total of elements/num of
   *         elements)
   */
  public static double getAverage(double[][] data) {
    
    int elements = 0;
    double sum = 0;
    for (int i = 0;i < data.length;i++) {
      elements += data[i].length; 
      for (int j = 0;j < data[i].length;j++) {
        sum += data[i][j];
      }
    }
    
    return sum / elements;
  }

  /**
   * Returns the total of the selected column in the two dimensional array index 0 refers to the
   * first column. If a row in the two dimensional array doesn't have this column index, it is not
   * an error, it doesn't participate in this method.
   * 
   * @param data the two dimensional array
   * @param col the column index to take the total of (0 refers to the first column)
   * @return the total of the column
   */
  public static double getColumnTotal(double[][] data, int col) {
    double colTotal = 0;
    for (int i = 0;i < data.length;i++) {
      if (col >= data[i].length) {
        continue;
      }
        colTotal += data[i][col];
    }
    return colTotal;
  }

  /**
   * Returns the largest element in the two dimensional array
   * 
   * @param data the two dimensional array
   * @return the largest element in the two dimensional array
   */
  public static double getHighestInArray(double[][] data) {
    double high = -999999;
    for (int i = 0;i < data.length;i++) { 
      for (int j = 0;j < data[i].length;j++) {
        if (data[i][j] > high) {
          high = data[i][j];
        }
      }
    }
    return high;
  }

  /**
   * Returns the largest element of the selected column in the two dimensional array index 0 refers
   * to the first column. If a row in the two dimensional array doesn't have this column index, it
   * is not an error, it doesn't participate in this method.
   * 
   * @param data the two dimensional array
   * @param col the column index to find the largest element of (0 refers to the first column)
   * @return the largest element of the column
   */
  public static double getHighestInColumn(double[][] data, int col) {
    double high = -999999;
    for (int i = 0;i < data.length;i++) {
      if (col >= data[i].length) {
        continue;
      }
      if (data[i][col] > high) {
        high = data[i][col];
      }
    }
    return high;
  }

  /**
   * Returns index of the largest element of the selected column in the two dimensional array index
   * 0 refers to the first column. If a row in the two dimensional array doesn't have this column
   * index, it is not an error, it doesn't participate in this method.
   * 
   * @param data the two dimensional array
   * @param col the column index to find the largest element of (0 refers to the first column)
   * @return the index of the largest element of the column
   */
  public static int getHighestInColumnIndex(double[][] data, int col) {
    double high = -999999;
    int index = -1;
    for (int i = 0;i < data.length;i++) {
      if (col >= data[i].length) {
        continue;
      }
      if (data[i][col] > high ) {
        high = data[i][col];
        index = i;
      }
    }
    return index;
  }

  /**
   * Returns the largest element of the selected row in the two dimensional array index 0 refers to
   * the first row.
   * 
   * @param data the two dimensional array
   * @param row the row index to find the largest element of (0 refers to the first row)
   * @return the largest element of the row
   */
  public static double getHighestInRow(double[][] data, int row) {
    double high = -999999;
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] > high) {
        high = data[row][i];
      }
    }
    return high;
  }

  /**
   * Returns the largest element of the selected row in the two dimensional array index 0 refers to
   * the first row.
   * 
   * @param data the two dimensional array
   * @param row the row index to find the largest element of (0 refers to the first row)
   * @return the largest element of the row
   */
  public static int getHighestInRowIndex(double[][] data, int row) {
    double high = -999999;
    int index = -1;
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] > high) {
        high = data[row][i];
        index = i;
      }
    }
    return index;
  }

  /**
   * Returns the smallest element in the two dimensional array
   * 
   * @param data the two dimensional array
   * @return the smallest element in the two dimensional array
   */
  public static double getLowestInArray(double[][] data) {
    double low = 999999;
    for (int i = 0;i < data.length;i++) { 
      for (int j = 0;j < data[i].length;j++) {
        if (data[i][j] < low) {
          low = data[i][j];
        }
      }
    }
    return low;
  }

  /**
   * Returns the smallest element of the selected column in the two dimensional array index 0 refers
   * to the first column. If a row in the two dimensional array doesn't have this column index, it
   * is not an error, it doesn't participate in this method.
   * 
   * @param data the two dimensional array
   * @param col the column index to find the smallest element of (0 refers to the first column)
   * @return the smallest element of the column
   */
  public static double getLowestInColumn(double[][] data, int col) {
    double low = 999999;
    for (int i = 0;i < data.length;i++) {
      if (col >= data[i].length) {
        continue;
      }
      if (data[i][col] < low) {
        low = data[i][col];
      }
    }
    return low;
  }

  /**
   * Returns the index of the smallest element of the selected column in the two dimensional array
   * index 0 refers to the first column. If a row in the two dimensional array doesn't have this
   * column index, it is not an error, it doesn't participate in this method.
   * 
   * @param data the two dimensional array
   * @param col the column index to find the smallest element of (0 refers to the first column)
   * @return the index of the smallest element of the column
   */
  public static int getLowestInColumnIndex(double[][] data, int col) {
    double low = 999999;
    int index = -1;
    for (int i = 0;i < data.length;i++) {
      if (col >= data[i].length) {
        continue;
      }
      if (data[i][col] < low ) {
        low = data[i][col];
        index = i;
      }
    }
    return index;
  }

  /**
   * Returns the smallest element of the selected row in the two dimensional array index 0 refers to
   * the first row.
   * 
   * @param data the two dimensional array
   * @param row the row index to find the smallest element of (0 refers to the first row)
   * @return the smallest element of the row
   */
  public static double getLowestInRow(double[][] data, int row) {
    double low = 999999;
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] < low) {
        low = data[row][i];
      }
    }
    return low;
  }

  /**
   * Returns the index of the smallest element of the selected row in the two dimensional array
   * index 0 refers to the first row.
   * 
   * @param data the two dimensional array
   * @param row the row index to find the smallest element of (0 refers to the first row)
   * @return the index of the smallest element of the row
   */
  public static int getLowestInRowIndex(double[][] data, int row) {
    double low = 999999;
    int index = -1;
    for (int i = 0;i < data[row].length;i++) {
      if (data[row][i] < low) {
        low = data[row][i];
        index = i;
      }
    }
    return index;
  }

  /**
   * Returns the total of the selected row in the two dimensional array index 0 refers to the first
   * row.
   * 
   * @param data the two dimensional array
   * @param row the row index to take the total of (0 refers to the first row)
   * @return the total of the row
   */
  public static double getRowTotal(double[][] data, int row) {
    double sum = 0;
    for (int i = 0;i < data[row].length;i++) {
        sum += data[row][i];
    }
    return sum;
  }

  /**
   * Returns the total of all the elements of the two dimensional array
   * 
   * @param data the two dimensional array getting total of
   * @return the sum of all the elements in the two dimensional array
   */
  public static double getTotal(double[][] data) {
    double sum = 0;
    for (int i = 0;i < data.length;i++) { 
      for (int j = 0;j < data[i].length;j++) {
        sum += data[i][j];
      }
    }
    
    return sum;
  }

  /**
   * Reads from a file and returns a ragged array of doubles The maximum rows is 10 and the maximum
   * columns for each row is 10 Each row in the file is separated by a new line Each element in the
   * row is separated by a space Suggestion: You need to know how many rows and how many columns
   * there are for each row to create a ragged array. 1. Read the doubles from the file into an a
   * temporary array [10][10] of Strings which was initialized to nulls. 2. Find out how many rows
   * there are (any row that has the first element != null is a valid row) 3. Create the array based
   * on the num of rows, i.e. double[][]array = new double[#rows][] 4. Determine the number of
   * columns for the first row (any element != null is a valid element) 5. Create the first row,
   * i.e. array[0] = new double[#columns] 6. Put the values from the temporary array into in the row
   * (don't forget to convert from strings to doubles) 7. Repeat for all rows
   * 
   * @param file the file to read from
   * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty,
   *         returns a null if file is empty
   * @throws FileNotFoundException 
   */
  public static double[][] readFile(File file) throws FileNotFoundException  {
    Scanner sc = new Scanner(file);
    int indexRow = 0;
    String[][] temp = new String[10][]; 
    
    // read file and pass numbers to temp array as Strings
    while (sc.hasNextLine()) {
     String[] row = sc.nextLine().split(" ");
     temp[indexRow] = new String[row.length];
     for (int i = 0;i < row.length;i++) {
       temp[indexRow][i]=row[i];   
     }
     indexRow++;
    }
   // Create double data array and parse numbers as doubles
    double[][]data = new double[indexRow][];
    for (int i = 0; i < indexRow;i++) {
      data[i]= new double[temp[i].length];
      for (int j = 0;j < temp[i].length;j++) {
          System.out.print(temp[i][j] + " ");
          data[i][j] = Double.parseDouble(temp[i][j]);
      }
      System.out.println();
    }
    
    sc.close();
    return data;
  }

  /**
   * Writes the ragged array of doubles into the file. Each row is on a separate line within the
   * file and each double is separated by a space.
   * 
   * @param data two dimensional ragged array of doubles
   * @param outputFile the file to write to
   * @throws FileNotFoundException 
   */
  public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
    PrintWriter output = new PrintWriter(outputFile);
    StringBuilder sb = new StringBuilder();
    for (int i = 0;i < data.length;i++) {
      for (int j = 0;j < data[i].length;j++) {
        sb.append(data[i][j]+ " ");
      }
      sb.append("\n");
    }
    output.print(sb.toString());
    output.close();
  }

}
