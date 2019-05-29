import java.util.Scanner;
/**
 * 
 */

/**
 * @author Fernando Gonzales-Vigil
 *
 */
public class MovieDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		char answer;
		do {
			Movie movie = new Movie();
			
			System.out.println("Enter the title of a movie: ");
			String movieTitle = console.nextLine();
			movie.setTitle(movieTitle);
			
			System.out.println("Enter the movie's rating: ");
			String movieRating = console.nextLine();
			movie.setRating(movieRating);
			
			System.out.println("Enter the number of tickets sold at an iPic theather: ");
			int soldTickets = console.nextInt();
			movie.setSoldTickets(soldTickets);
			
			System.out.println(movie.toString());
			
			System.out.println("Do you want to enter another movie? (y or n)");
			answer = console.next().toLowerCase().charAt(0);
			console.nextLine();
		} while (answer != 'n');
		System.out.println("Goodbye");
		
		console.close();
	}

}
