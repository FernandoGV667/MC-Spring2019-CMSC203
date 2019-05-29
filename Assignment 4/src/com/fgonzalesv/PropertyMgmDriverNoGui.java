package com.fgonzalesv;


/**
 * A test driver class.
 * 
 * @author Professor khandan Monshi
 *
 */
public class PropertyMgmDriverNoGui {
	
	public static void main(String[] args) {

		//Create management company object
		ManagementCompany m = new ManagementCompany("Alliance", "1235",6,0,0,10,10);
		
		//Add the properties to the list of properties of the management company
		System.out.println(m.addProperty("Belmar", "Silver Spring", 1200, "John Smith",0,0,1,1));   //Should add the property and display the index where the property is added to the array
		System.out.println(m.addProperty("Camden Lakeway", "Rockville", 5000, "Ann Taylor",1,1,1,1)); //should display 1 to indicate the second property added
		System.out.println(m.addProperty("Hamptons", "Rockville", 1250, "Rick Steves",2,2,1,1)); //should display 2 to indicate the third property added
	 	System.out.println(m.addProperty("Mallory Square", "Wheaton", 1000, "Abbey McDonald",3,3,1,1)); //should display 3 to indicate the fourth property added
		System.out.println(m.addProperty("Lakewood", "Rockville", 3000, "Alex Tan",4,4,11,11));   //should display -3 to indicate property plot is not contained in the MgmtCo plot
		System.out.println(m.addProperty("Lakewood", "Rockville", 3000, "Alex Tan",0,0,2,2)); //should display -4 to indicate property plot overlaps another one
		System.out.println(m.addProperty("Lakewood", "Rockville", 3000, "Alex Tan",0,6,2,2)); //should display 4 to indicate the fourth property added
		System.out.println(m.addProperty("Lakewood", "Rockville", 3000, "Alex Tan",4,4,1,1));   //it should display -4 to indicate the property is not added to the array due to size
		
		//Display the information of the property that has the maximum rent amount
		System.out.println("The property with the highest rent:\n" + m.maxPropertyRent());  
	 		
		//Display the total rent of the properties within the management company
		System.out.println("\nTotal Rent of the properties: "+m.totalRent()+ "\n");  
		
		System.out.println(m); //List the information of all the properties and the total management fee 
	}

}
