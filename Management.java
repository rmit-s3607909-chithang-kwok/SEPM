import java.util.ArrayList;
import java.util.Scanner;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class Management 
{
	 private static String userName;
	 private static String password;
	
	 private static ArrayList<Customer> customers = new ArrayList<Customer>();
	 private static ArrayList<Movie> movies = new ArrayList<Movie>(); //need for movies search
	 private static ArrayList<BookingClerk> bookingClerks = new ArrayList<BookingClerk>();
	 private static ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
	 static ArrayList<Session> cinemaSessions = new ArrayList<Session>();
	
	 static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) 
	{
		int input = 0;
		//String username;
		//String Password;
		//String Confirm;
		
		BookingClerk BookingClerk1 = new BookingClerk("b1", "b2", "b3");
		bookingClerks.add(BookingClerk1);
		BookingClerk BookingClerk2 = new BookingClerk("c1", "c2", "c3");
		bookingClerks.add(BookingClerk2);
		BookingClerk BookingClerk3 = new BookingClerk("d1", "d2", "d3");
		bookingClerks.add(BookingClerk3);
		
		Booking[] Booking = new Booking[20];
		
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
		
		
		
		Customer customer = new Customer("c1", "Naomi Scott", "naomi@gmail.com", "Ringwood East");
		customers.add(customer);
		
		Customer customer2 = new Customer("c2", "Liza Minnelli", "liza@gmail.com", "Sunbury");
		customers.add(customer2);
		
		Customer customer3 = new Customer("c3", "Jane Fonda", "jane@gmail.com", "Doncaster");
		customers.add(customer3);
		Scanner sb = new Scanner(System.in);
		
		do
		{
			System.out.println("Please choose the options?");
			System.out.println("1. Login");
			System.out.println("2. Exit Program");
			System.out.println("                 ");
			
			input = sc.nextInt();
			
			if(input == 1) {
				UserLogin();
			}else {
				System.out.println("Program exit");
			}if (input != 1 && input != 2) {
				System.out.println("Invalid Choice.");
			}
		}while (input != 2);
		
	}	
		
		
		
	   
	    public static void SubMenu() {
	    	int input = 0;
	    	Scanner sc = new Scanner (System.in);
		do 
		{			
			System.out.println("Welcome to the CinenoPlex Management System (JMOSS). ");
			System.out.println("=================================");
			System.out.println("1. Create Booking");
			System.out.println("2. Delete Booking");
			System.out.println("3. Search Movie");
			System.out.println("4. Search Cinema");
<<<<<<< HEAD
			System.out.println("5. Search Customer");
			System.out.println("6. Logout");
=======
			System.out.println("5. Logout");
			System.out.println("6. Exit");
<<<<<<< HEAD
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
=======
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
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
				case 5:
<<<<<<< HEAD
<<<<<<< HEAD
					searchByCustomerEmail();	
					break;
				case 6:
					//userLogin();
					mainMenu();
			}
			if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5) 
			{
				System.out.println("Please enter a valid option ");
=======
=======
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
					System.out.println("Go back to the Beginnning");
					continue;
					
			}if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != 6) {
				System.out.println("Please enter the correct number? ");
<<<<<<< HEAD
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
=======
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
			}
		}
		while(input != 6 );
			System.out.println("Program Exit");
}
	
	public static void createBooking() 
	{
		Cinema cinemaSelected;
		Movie movieSelected;
		Session sessionSelected;
		Customer customerSelected;
		
		cinemaSelected = cinemaSelection();
		movieSelected = movieSelection(cinemaSelected);
		sessionSelected = sessionSelection(cinemaSelected, movieSelected);
		customerSelected = customerSelection(sessionSelected);
		sessionSelected.makeBooking(customerSelected);		
		System.out.println("The following Booking have been created.");
	}
	
	public static void deleteBooking()
	{
		Cinema cinemaSelected;
		Movie movieSelected;
		Session sessionSelected;
		Customer customerSelected;
		
		cinemaSelected = cinemaSelection();
		movieSelected = movieSelection(cinemaSelected);
		sessionSelected = sessionSelection(cinemaSelected, movieSelected);
<<<<<<< HEAD
<<<<<<< HEAD
		
		if(sessionSelected.bookings.size() < 1)
		{
			System.out.println("No bookings to delete");
		}
		else
		{
			System.out.println("Enter the booking to delete: ");
			sessionSelected.listBookings();
			bookingSelect = sc.nextInt();
			sessionSelected.deleteBooking(bookingSelect);
			System.out.println("The Booking have been cancelled");
		}
=======
		customerSelected = customerSelection(sessionSelected);
		sessionSelected.deleteBooking(customerSelected);	
		System.out.println("The following Booking have been cancelled");
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
=======
		customerSelected = customerSelection(sessionSelected);
		sessionSelected.deleteBooking(customerSelected);	
		System.out.println("The following Booking have been cancelled");
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
	}
	
	private static Cinema cinemaSelection()
	{
		int cinemaSelection;
		Cinema cinemaSelected;
	
		System.out.println("Please enter cinema: ");
		for(int i = 0; i < cinemas.size(); i++)
		{
			System.out.println((i+1) + ". " + cinemas.get(i).getLocation());
		}
		cinemaSelection = sc.nextInt();
		cinemaSelected = cinemas.get(cinemaSelection-1); 
		return cinemaSelected;
	}
	
	private static Movie movieSelection(Cinema cinemaSelected)
	{
		//int cinemaSelection;
		int movieSelection;
		Movie movieSelected;
		System.out.println("Please enter movie: ");
		for(int i = 0; i < cinemaSelected.movies.size(); i++)
		{
			System.out.println((i+1) + ". " + cinemaSelected.movies.get(i).getName());
		}
		movieSelection=sc.nextInt();
		movieSelected = cinemaSelected.movies.get(movieSelection-1); 
		return movieSelected;
	}
	
	private static Session sessionSelection(Cinema cinemaSelected, Movie movieSelected)
	{
		//int sessionSelection;
		Session sessionSelected;
		
		System.out.println("Please enter session: ");
		int number = 0;
		for(int i = 0; i < cinemaSelected.cinemaSessions.size(); i++)
		{
			int counter = 0;
			if(movieSelected == cinemaSelected.cinemaSessions.get(i).movie)
			{
				counter ++;
				System.out.println((counter++) + ". " + cinemaSelected.cinemaSessions.get(i).getDate());
				number = i;
			}
		}
		//sessionSelection = sc.nextInt();
		sessionSelected = cinemaSelected.cinemaSessions.get(number);
		return sessionSelected;
	}
	
	private static Customer customerSelection(Session sessionSelected)
	{
<<<<<<< HEAD
<<<<<<< HEAD
		//String customerID;
		int selecto = 0;
		//Customer customerSelected;
=======
=======
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
		String customerID;
		Customer customerSelected;
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
		
		System.out.println("Please enter Customer ID: ");
		sc.nextLine();
		customerID = sc.nextLine();
		for(int i = 0; i < customers.size(); i++)
		{
			if( customerID.equals(customers.get(i).getID()) )
			{
				customerSelected = customers.get(i);
				return customerSelected;
			}
		}
		return null;
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
		String CinemaSearch;
		
		Cinema CinemaSearched;
		System.out.println("Enter the cinema name you wish to enter?");
		sc.nextLine();
		CinemaSearch = sc.nextLine();         
		
		for(int i = 0; i < cinemaSessions.size(); i++)
		{
			
			
				System.out.println(cinemaSessions.get(i).getID() + cinemaSessions.get(i).getDate());
		}
		
		System.out.println("You have choosed " + CinemaSearch + " to watch the movie today.");
		
	}
		   
	
	
<<<<<<< HEAD
<<<<<<< HEAD
	private static void searchByCustomerEmail()
	{
		int selecti = 0;
		System.out.println("Select a customer: ");
		for(int j = 0; j < customers.size(); j++)
		{
			System.out.println((j+1) + ". " + customers.get(j).getEmail());
		}
		selecti = sc.nextInt();
		
		customers.get(selecti-1).listBookings();
	}	
=======
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
=======
>>>>>>> 5ad0935059b5e2bbc701c422f7b953c569e4a840
	
	
	public static void UserLogin()
	{
		String username;
		String password;

		Scanner sb = new Scanner(System.in);
		 
		
			System.out.println("Please enter your username?"); 
			username = sb.nextLine();
			System.out.println("Please enter your password?");
			password = sb.nextLine();
		
	
		
		
		for(int i = 0; i < bookingClerks.size(); i++) 
		{
			if ( username.equals(bookingClerks.get(i).getUsername()) && password.equals(bookingClerks.get(i).getPassword()) )
			{
				System.out.println("Your username and Your Password are correct.");
				System.out.println("You have login successfully. ");
				SubMenu();
			}
			else
				System.out.println("Your username and password are incorrect please type it again.");
			continue;
    }
	}
}
