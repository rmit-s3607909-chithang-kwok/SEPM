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
		
		Cinema cinema3 = new Cinema("Melbourne CBD");
		cinemas.add(cinema3);
		
		Cinema cinema4 = new Cinema("St Kilda");
		cinemas.add(cinema4);
		
		Cinema cinema5 = new Cinema("Fitzroy");
		cinemas.add(cinema5);
		
		Movie movie1 = new Movie("Black Panther");
		movies.add(movie1);
		
		Movie movie2 = new Movie("Jumanji");
		movies.add(movie2);
		
		Movie movie3 = new Movie("Avengers");
		movies.add(movie3);
		
		cinema1.addMovie(movie1);
		cinema2.addMovie(movie1);
		cinema3.addMovie(movie1);
		cinema4.addMovie(movie1);
		cinema5.addMovie(movie1);
		
		cinema1.addMovie(movie2);
		cinema2.addMovie(movie2);
		cinema3.addMovie(movie2);
		cinema4.addMovie(movie2);
		cinema5.addMovie(movie2);
		
		cinema1.addMovie(movie3);
		cinema2.addMovie(movie3);
		cinema3.addMovie(movie3);
		cinema4.addMovie(movie3);
		cinema5.addMovie(movie3);
			
		cinema1.addSession("s1", "16:30 25th February", movie1);
		cinema2.addSession("s2", "18:30 1st March", movie1);
		cinema3.addSession("s3", "20:30 3rd March", movie1);
		cinema4.addSession("s4", "22:30 5th March", movie1);
		cinema5.addSession("s5", "00:30 7th March", movie1);
		
		cinema1.addSession("s10", "10:30 6th March", movie2);
		cinema2.addSession("s20", "12:30 9th March", movie2);
		cinema3.addSession("s30", "14:30 12th March", movie2);
		cinema4.addSession("s40", "16:30 14th March", movie2);
		cinema5.addSession("s50", "18:30 16th March", movie2);
		
		cinema1.addSession("s11", "18:30 15th March", movie3);
		cinema2.addSession("s21", "20:30 18th March", movie3);
		cinema3.addSession("s31", "22:30 21st March", movie3);
		cinema4.addSession("s41", "00:30 23rd March", movie3);
		cinema5.addSession("s51", "02:30 25rd March", movie3);
		
		Customer customer = new Customer("c1", "Naomi Scott", "naomi@gmail.com", "Ringwood East");
		customers.add(customer);
		
		Customer customer2 = new Customer("c2", "Liza Minnelli", "liza@gmail.com", "Sunbury");
		customers.add(customer2);
		
		Customer customer3 = new Customer("c3", "Jane Fonda", "jane@gmail.com", "Doncaster");
		customers.add(customer3);
		
		cinema1.cinemaSessions.get(0).makeBooking(customer);
		cinema2.cinemaSessions.get(1).makeBooking(customer2);
		cinema3.cinemaSessions.get(2).makeBooking(customer3);
		
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
	    		System.out.println("3. Search By Cinema");
	    		System.out.println("4. Search By Customer Email");
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
						searchByCinema();
						break;
					case 4:
						searchByCustomer();
						break;
					case 5:
						Toolkit.getDefaultToolkit().beep();
						baseMenu();						
	    		}
	    		
	    		if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5) 
	    		{
	    			System.out.println("Please enter a valid number ");
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
					System.out.println("Your username and password are correct.");
					System.out.println("You have logged in successfully. ");
					mainMenu();
					break;
				}
				else
					System.out.println("Your username and password are incorrect. Please type it again.");
				continue;
			}
		}
	public static void createBooking() 
	{
		Cinema cinemaSelected;
		Movie movieSelected;
		Session sessionSelected;
		Customer customerSelected;
		int confirmation = 0;
		sc.nextLine();
		
		//Variables
//				File g  = new File();
//				g.openFile();
		
		cinemaSelected = cinemaSelection();
		movieSelected = movieSelection(cinemaSelected);
		sessionSelected = sessionSelection(cinemaSelected, movieSelected);
		customerSelected = customerSelection(sessionSelected);
		System.out.println("Are you sure you want to create this booking?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		confirmation = sc.nextInt();
		if(confirmation == 1)
		{
			sessionSelected.makeBooking(customerSelected);		
			System.out.println("Booking has been created.");
			System.out.println();
			
			//writeToFile() and closeFile() method inside if statement
//			g.writeToFile(cinemaSelected, movieSelected, sessionSelected, customerSelected);
//			g.closeFile();
		}
		else if(confirmation ==2)
		{
			System.out.println("Booking has been cancelled");
			System.out.println();
		}
				
		
	}
	
	public static void deleteBooking()
	{
		Cinema cinemaSelected;
		Movie movieSelected;
		Session sessionSelected;
		Customer customerSelected;
		sc.nextLine();
		int confirmation = 0;
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
			
			System.out.println("Are you sure you want to delete this booking?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			confirmation = sc.nextInt();
			
			if(confirmation == 1)
			{
				sessionSelected.deleteBooking(bookingSelect);
				System.out.println("The Booking has been deleted");
			}
			else if(confirmation == 2)
			{
				System.out.println("Booking will not be deleted");
			}
		}
		System.out.println();
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
				System.out.println((i) + ". " + cinemaSelected.cinemaSessions.get(i).getID() + " " + cinemaSelected.cinemaSessions.get(i).getDate());
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
		
	private static void searchByCinema()
	{
		//String CinemaSearch;
		Cinema cinemaSelected;
		int cinemaSelection;
		int movieSelection;
		Movie movieSelected;
		
		System.out.println("Select a cinema: ");
		//Cinema.listSessions();
		
		//CinemaSearch = sc.nextLine();         
		
		for(int i = 0; i < cinemas.size(); i++)
		{
			System.out.println((i) + ". " + cinemas.get(i).getLocation());
		}
		cinemaSelection = sc.nextInt();
		cinemaSelected = cinemas.get(cinemaSelection);
		
		
		System.out.println("Select a movie: ");
		
		for(int i = 0; i < cinemaSelected.movies.size(); i ++)
		{
			System.out.println((i) + ". " + cinemaSelected.movies.get(i).getName());
		}
		
		movieSelection = sc.nextInt();
		movieSelected = cinemaSelected.movies.get(movieSelection);
		
		System.out.println("List of sessions: ");
		int index = 1;
		for(int i = 0; i < cinemaSelected.cinemaSessions.size(); i++)
		{
			if(cinemaSelected.cinemaSessions.get(i).movie == movieSelected)
			{
				System.out.println((index++) + ". " + cinemaSelected.cinemaSessions.get(i).getID() + " " + cinemaSelected.cinemaSessions.get(i).getDate());
			}
			index++;
		}
		System.out.println();
		
	}
	
	private static void searchByCustomer()
	{
		int customerSelect = 0;
		Customer customerSelected;
		sc.nextLine();
		System.out.println("Select a customer: ");
		for(int i = 0; i< customers.size(); i++)
		{
			System.out.println((i) + "." + customers.get(i).email);
		}
		customerSelect = sc.nextInt();
		customerSelected = customers.get(customerSelect);
		
		customerSelected.listBookings();
		if(customerSelected.bookings.size() == 0)
		{
			System.out.println("There are no bookings to display");
		}
		System.out.println();
	}
}
