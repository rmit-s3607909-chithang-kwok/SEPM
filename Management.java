import java.awt.Toolkit;
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
	 static Boolean condition = true;

	public static void main(String[] args) 
	{
		//int input = 0;
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
		//Scanner sb = new Scanner(System.in);
		while(condition)
		{
			baseMenu();
		}
	}	
	
	public static void baseMenu()
		{
			int input = 0;
			do
			{
				System.out.println("Please choose the options?");
				System.out.println("1. Login");
				System.out.println("2. Exit Program");
				System.out.println("                 ");
				
				input = sc.nextInt();
				
				if(input == 1) 
				{
					UserLogin();
				}
				if(input == 2)
				{
					condition = false;
					break;
				}
			}
			while (input != 0);
			System.out.println("System Exit");
			//input = 0;
		}
		
	    public static void mainMenu() 
	    {
	    	int input = 0;
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
					case 5:
						//System.out.println("Go back to the Beginnning");
						Toolkit.getDefaultToolkit().beep();
						baseMenu();
						//break;
						//continue;
	    		}
	    		
	    		if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5) 
	    		{
	    			System.out.println("Please enter the correct number? ");
	    		}
	    	}
	    	
	    	while(input != 5 );
			System.out.println("Program Exit");
	    }
	    public static void UserLogin()
		{
			String username;
			String password;
			sc.nextLine();
			System.out.println("Please enter your username?"); 
			username = sc.nextLine();
			System.out.println("Please enter your password?");
			password = sc.nextLine();
			
			for(int i = 0; i < bookingClerks.size(); i++) 
			{
				if ( username.equals(bookingClerks.get(i).getUsername()) && password.equals(bookingClerks.get(i).getPassword()) )
				{
					System.out.println("Your username and Your Password are correct.");
					System.out.println("You have login successfully. ");
					mainMenu();
					break;
				}
				else
					System.out.println("Your username and password are incorrect please type it again.");
				continue;
	    }
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
		int bookingSelect;
		cinemaSelected = cinemaSelection();
		movieSelected = movieSelection(cinemaSelected);
		sessionSelected = sessionSelection(cinemaSelected, movieSelected);
		
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
		int sessionSelection;
		Session sessionSelected;
		sc.nextLine();
		System.out.println("Please enter session: ");
		
		for(int i = 0; i < cinemaSelected.cinemaSessions.size(); i++)
		{
			if(movieSelected == cinemaSelected.cinemaSessions.get(i).movie)
			{
				System.out.println((i) + ". " + cinemaSelected.cinemaSessions.get(i).getDate());
			}
		}
		sessionSelection = sc.nextInt();
		sessionSelected = cinemaSelected.cinemaSessions.get(sessionSelection);
		return sessionSelected;
	}
	
	private static Customer customerSelection(Session sessionSelected)
	{
		int customerSelection;
		Customer customerSelected;
		sc.nextLine();
		
		System.out.println("Please enter Customer ID: ");
		
		for(int i = 0; i < customers.size(); i++)
		{
			System.out.println((i+1) + ". " + customers.get(i).getEmail());
		}
		customerSelection = sc.nextInt();
		
		return customers.get(customerSelection-1);
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
		System.out.println("List the cinema Session");
		//Cinema.listSessions();
		
		CinemaSearch = sc.nextLine();         
		
		for(int i = 0; i < cinemaSessions.size(); i++)
		{
			
			
				System.out.println(cinemaSessions.get(i).getID() + cinemaSessions.get(i).getDate());
		}
		
		System.out.println("You have choosed " + CinemaSearch + " to watch the movie today.");
		
	}
}
