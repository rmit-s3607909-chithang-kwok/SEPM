import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Management 
{
	 //private static String userName;
	 //private static String password;
	
	 private static ArrayList<Customer> customers = new ArrayList<Customer>();
	 private static ArrayList<Movie> movies = new ArrayList<Movie>(); //need for movies search
	 //private static ArrayList<BookingClerk> bookingClerks = new ArrayList<BookingClerk>();
	 private static ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
	
	 static Scanner sc = new Scanner(System.in);
	 static int counter = 0;

	public static void main(String[] args) 
	{	
		Cinema cinema1 = new Cinema("Lilydale");
		cinemas.add(cinema1);
		
		Cinema cinema2 = new Cinema("Sunshine");
		cinemas.add(cinema2);
		
		Cinema cinema3 = new Cinema("CBD");
		cinemas.add(cinema3);
		
		Movie movie1 = new Movie("Black Panther");
		movies.add(movie1);
		
		Movie movie2 = new Movie("Jumanji");
		movies.add(movie2);
		
		Movie movie3 = new Movie("Avengers");
		movies.add(movie3);
		
		cinema1.addMovie(movie1);
		cinema2.addMovie(movie1);
		cinema3.addMovie(movie1);
		
		cinema1.addMovie(movie2);
		cinema2.addMovie(movie2);
		cinema3.addMovie(movie2);
		
		cinema1.addMovie(movie3);
		cinema2.addMovie(movie3);
		cinema3.addMovie(movie3);
			
		cinema1.addSession("s1", "25th February", movie1);
		cinema2.addSession("s2", "1st March", movie1);
		cinema3.addSession("s3", "3rd March", movie1);
		
		cinema1.addSession("s4", "6th March", movie2);
		cinema2.addSession("s5", "9th March", movie2);
		cinema3.addSession("s6", "12th March", movie2);
		
		cinema1.addSession("s7", "15th March", movie3);
		cinema2.addSession("s8", "18th March", movie3);
		cinema3.addSession("s9", "21st March", movie3);
		
		int input = 0;
		
		Customer customer = new Customer("c1", "Naomi Scott", "naomi@gmail.com", "Ringwood East");
		customers.add(customer);
		
		Customer customer2 = new Customer("c2", "Liza Minnelli", "liza@gmail.com", "Sunbury");
		customers.add(customer2);
		
		Customer customer3 = new Customer("c3", "Jane Fonda", "jane@gmail.com", "Doncaster");
		customers.add(customer3);
		
		//Scanner sb = new Scanner(System.in);
		/*//not needed until sprint 3
		System.out.println("Please enter your username and password");
		String username = sb.nextLine();
		String Password = sb.nextLine();
		 System.out.print("Please re-enter the password to confirm : ");
	    String Confirm = sb.nextLine();
	    boolean condition;
		condition = isValid(Password);
	    while (!Password.equals(Confirm) && (!condition)) {
	        System.out.println("The password is invalid");
	        System.out.print("Please enter the password again : ");
	        Password = sb.nextLine();
	        System.out.print("Please re-enter the password to confirm : ");
	        Confirm = sb.nextLine();
		}
		System.out.println("Your username is " + username + "and Your Password is " + Password);
		System.out.println("You have login successfully. ");
		
*/
		do 
		{			
			System.out.println("Welcome to the CinenoPlex Management System (JMOSS). ");
			System.out.println("=================================");
			System.out.println("1. Create Booking");
			System.out.println("2. Delete Booking");
			System.out.println("3. Search Movie");
			System.out.println("4. Search Cinema");
			System.out.println("5. Logout");
			System.out.println("                                ");
			System.out.println("Enter an Option:                ");
			
			input = sc.nextInt();
			
			switch(input) 
			{
				case 1:
					createBooking();
					break;
				case 2:
					deleteBooking();
					break;
				case 3:
					searchByMovie();
					break;
				case 4:
					searchByCinema();
					break;
				//case 5:
					//break
			}if (input != 1 && input != 2 && input != 3 && input != 4);
			System.out.println("Please enter the correct number? ");
		}
		while(input!=5);
		System.out.println("Program exit");
}
	
	public static void createBooking() 
	{
		Cinema cinemaSelected;
		//Movie movieSelected;
		Session sessionSelected;
		Customer customerSelected;
		int selection = 0;

		System.out.println("Select a cinema: ");
		listCinemas();
		
		selection = sc.nextInt();
		cinemaSelected = cinemas.get(selection-1);
		System.out.println("Select a session: ");
		cinemaSelected.listSessions();
		selection = sc.nextInt();
		sessionSelected = cinemaSelected.cinemaSessions.get(selection-1);
		
		System.out.println("Select a customer: ");
		
		for(int i = 0; i < customers.size(); i++)
		{
			System.out.println((i+1) + ". " + customers.get(i).getID() + " " + customers.get(i).getEmail());
		}
		selection = sc.nextInt();
		customerSelected = customers.get(selection-1);
		
		sessionSelected.makeBooking(customerSelected);
		
		System.out.println("The following Booking have been created.");
	
	}
	
	public static void deleteBooking()
	{
		Cinema cinemaSelected;
		//Movie movieSelected;
		Session sessionSelected;
		//Customer customerSelected;
		Booking bookingSelected;
		int selection = 0;
		
		System.out.println("Select a customer: ");
		listCinemas();
		
		selection = sc.nextInt();
		cinemaSelected = cinemas.get(selection-1);
		
		System.out.println("Select a session: ");
		cinemaSelected.listSessions();
		selection = sc.nextInt();
		sessionSelected = cinemaSelected.cinemaSessions.get(selection-1);
		
		System.out.println("Select a booking to delete: ");
		sessionSelected.listBookings();
		selection = sc.nextInt();
		bookingSelected = sessionSelected.bookings.remove(selection-1);
		
		System.out.println("Booking deleted");
	}
	
	private static void listCinemas()
	{
		for(int i = 0; i < cinemas.size(); i++)
		{
			System.out.println((i+1) + ". " + cinemas.get(i).getLocation());
		}
	}
	
	private static void searchByMovie()
	{
		String movieSearch;
		
		Movie movieSearched;
		System.out.println("Enter movie name");
		sc.nextLine();
		movieSearch = sc.nextLine();         
		
		for(int i = 0; i < movies.size(); i++)
		{
			if(movieSearch == movies.get(i).getName())
			{
				System.out.println((i+1) + ". " + movies.get(i).getName());
				movieSearched = movies.get(i);
			}
		}
		
		System.out.println("You have choosed " + movieSearch + " to watch today.");
	}
	
	private static void searchByCinema()
	{
		   String CinemaSearched;
		   int cinemainput;
		   
		   Scanner sa = new Scanner(System.in);
		   
		   System.out.println("Please enter the Cinema number you want to watch the movie?");
		   System.out.println("1. St Kilda ");
		   System.out.println("2. Fitzroy");
		   System.out.println("3. Melbourne CBD");
		   System.out.println("4. Sunshine");
		   System.out.println("5. Lilydale");
		   
		   cinemainput = sa.nextInt();
		   
		   System.out.println("You have choose " + cinemainput + " to watch the movie today.");
	}
	
	public static boolean isValid(String password) {
	    Boolean atleastOneUpper = false;
	    Boolean atleastOneLower = false;
	    Boolean atleastOneDigit = false;

	    if (password.length() < 8) { // If its less then 8 characters, its automatically not valid
	        return false;
	    }

	    for (int i = 0; i < password.length(); i++) { // Lets iterate over only once. Saving time
	        if (Character.isUpperCase(password.charAt(i))) {
	            atleastOneUpper = true;
	        }
	        else if (Character.isLowerCase(password.charAt(i))) {
	            atleastOneLower = true;
	        }
	        else if (Character.isDigit(password.charAt(i))) {
	            atleastOneDigit = true;
	        }
	    }

	    return (atleastOneUpper && atleastOneLower && atleastOneDigit); // Return true IFF the password is atleast eight characters long, has atleast one upper, lower and digit
	}
}