import java.util.Scanner;

/**
 * 
 * @author Fernando Gonzales-Vigil
 *
 */
public class SphereVolume {

	public static void main(String[] args) {
		
		// define variables
		double diam, radius, volume;
		Scanner scan = new Scanner(System.in);
		
		// Print header of program
		System.out.println("Volume of the Sphere Calculator");
		
		// Prompt for diameter from user and get radius
		System.out.print("Please enter the diameter of the sphere: ");
		diam = scan.nextDouble();
		radius = diam/2;
		
		// Calculate volume of sphere
		volume = (4 * Math.PI / 3) * Math.pow(radius, 3);	
		System.out.println("The volume of the sphere with diameter " + diam + " is " + volume);
		
		scan.close();
	}

}
