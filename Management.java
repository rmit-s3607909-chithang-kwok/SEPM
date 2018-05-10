import java.util.ArrayList;
import java.util.Scanner;

public class Management 
{
	 private static String userName;
	 private static String password;
	
	 private static ArrayList<Customer> customers = new ArrayList<Customer>();
	 private static ArrayList<Movie> movies = new ArrayList<Movie>(); //need for movies search
	 //private static ArrayList<BookingClerk> bookingClerks = new ArrayList<BookingClerk>();
	 private static ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
	
	 static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) 
	{
		int input = 0;
		
		Cinema lilydale = new Cinema("Lilydale");
		cinemas.add(lilydale);
		Movie blackPanther = new Movie("Black Panther");
		lilydale.addMovie(blackPanther);
		lilydale.addSession("25th February", blackPanther);
		
		Customer customer = new Customer("Naomi", "a", "naomi@gmail.com", "Ringwood East");
		customers.add(customer);
		
		
		//Booking[] Booking = new Booking[20];
		//System.out.println("Please enter your username and passsword");
		//System.out.println("Your username" + username + "Your Password" + Password);
		
	   // if (isValid != TRUE) {
	    	//System.out.println("Your uaername and password are not valid please type again.");
	    	//else
	    	//System.out.println("Login Successfully");
			
	    //}
		
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
					//break;
			}if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5);
			System.out.println("Please enter the correct number? ");
		}
		while(input!=5);
		System.out.println("Program exit");
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
		customerSelected = customerSelection(sessionSelected);
		sessionSelected.deleteBooking(customerSelected);	
		System.out.println("The following Booking have been cancelled");
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
		String customerID;
		Customer customerSelected;
		
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
}