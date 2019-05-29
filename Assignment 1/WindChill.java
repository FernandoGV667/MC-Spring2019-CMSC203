/**
 * A program that prompts for and reads two double numeric amounts that represent the Fahrenheit temperature
 * and the wind speed. The temperature must be between -45 and 40 inclusively. The wind speed must be between 
 * 5 and 60 inclusively. Use these two amounts in the formula below to calculate the wind chill temperature in 
 * degrees Fahrenheit.
 * 
 * @author Fernando Gonzales-Vigil
 *
 */

package com.fgonzalesv;

import java.util.Scanner;

public class WindChill {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// constants
		final String HEADER = "Wind Chill Calculator\n";
		final String PROGRAMMER_NAME = "Programmer: Fernando Gonzales-Vigil";
		final String ASK_TEMPERATURE = "Please enter the temperature in Fahrenheit (must be >= -45 and <= 40): ";
		final String ASK_WIND_SPEED = "Please enter the wind speed (must be >= 5 and <= 60): ";

		// Start Program
		System.out.println(HEADER);
		
		System.out.print(ASK_TEMPERATURE);
		final double TEMPERATURE = scan.nextDouble();
		System.out.println();
		
		System.out.print(ASK_WIND_SPEED);
		final double WIND_SPEED = scan.nextDouble();
		System.out.println();
		System.out.println();
		
		/*	Wind Chill (oF) = 35.74 + 0.6215T - 35.75(V0.16) + 0.4275T(V^0.16), 
		 *  where V is the Wind Speed in MPH, and 
	  	 *	T is the temperature in degrees F.
		 */
		
		final double WIND_CHILL = 35.74 + (0.6215 * TEMPERATURE) 
				- (35.75 * Math.pow(WIND_SPEED, 0.16))
				+ (0.4275 * TEMPERATURE * Math.pow(WIND_SPEED, 0.16));
		
		System.out.println("Wind chill temperature: " + WIND_CHILL + " degrees Fahrenheit");
		System.out.println();
		System.out.println(PROGRAMMER_NAME);
		// End of Program
		scan.close();

	}

}
