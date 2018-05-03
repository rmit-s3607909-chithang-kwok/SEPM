import java.util.ArrayList;
import java.util.Scanner;

public class Management 
{
	 private static String username;
	 private static String Password;
	
	 ArrayList<Customer> customers = new ArrayList<Customer>();
	 ArrayList<Movie> movies = new ArrayList<Movie>();
	 ArrayList<BookingClerk> bookingClerks = new ArrayList<BookingClerk>();
	 ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
	
	 Scanner sc = new Scanner(System.in);

	public static void main(String[] args) 
	{
		int input = 0;
		
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
			System.out.println("  Your options are:  " + input);
			
			switch(input) 
			{
				case 1:
					createBooking();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
			}
		}
		while(input!=5);
}
	
	public void createBooking() 
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
	}
	public void deleteBooking()
	{
		String customerID;
		String movieID;
		int cinemaSelection;
		int movieSelection;
		int sessionSelection;
		Cinema cinemaSelected;
		Movie movieSelected;
		Session sessionSelected;
		Customer customerSelected;
		//Cinema
		System.out.println("Please enter cinema: ");
		for(int i = 0; i < cinemas.size(); i++)
		{
			System.out.println((i+1) + ". " + cinemas.get(i).getLocation());
		}
		cinemaSelection = sc.nextInt();
		cinemaSelected = cinemas.get(cinemaSelection-1); 
		//Movie
		System.out.println("Please enter movie: ");
		for(int i = 0; i < cinemaSelected.movies.size(); i++)
		{
			System.out.println((i+1) + ". " + cinemaSelected.movies.get(i).getName());
		}
		movieSelection=sc.nextInt();
		movieSelected = cinemaSelected.movies.get(movieSelection-1); 
		//Session
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
		sessionSelection = sc.nextInt();
		sessionSelected = cinemaSelected.cinemaSessions.get(number);
	}
	private Cinema cinemaSelection()
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
	private Movie movieSelection(Cinema cinemaSelected)
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
	private Session sessionSelection(Cinema cinemaSelected, Movie movieSelected)
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
	private Customer customerSelection(Session sessionSelected)
	{
		String customerID;
		Customer customerSelected;
		
		System.out.println("Please enter Customer ID: ");
		customerID = sc.nextLine();
		for(int i = 0; i < customers.size(); i++)
		{
			if(customerID.equals(customers.get(i).getID()))
			{
				customerSelected = customers.get(i);
				return customerSelected;
			}
		}
		
	}
}