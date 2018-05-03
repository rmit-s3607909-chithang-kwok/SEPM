import java.util.*;
import java.util.ArrayList;

public class Session{
ArrayList<Booking> bookings =  new ArrayList<Booking>(20);
private int date;
private int id;
public Movie movie;

	public Session(int date, int id, Movie movie) {
		this.date = date;
		this.id=id;
		this.movie=movie;
	     
	}

	public int getID() {
		return id;
	}
	
	public int getDate() {
		return date;
	}
	
	public void setID() {
		this.id = id;
	}
	
	public void setDate() {
		this.date=date;
	}
	
	public void makeBooking(Customer customer) 
	{
		Booking booking = new Booking(customer);
		bookings.add(booking);
	}
	
		
	public static void deleteBooking() {
		int input;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select the Movie you want to delete?");
		System.out.println("1. Avenger3");
		System.out.println("2. Black Panther");
		System.out.println("3. Rampage");
		
		
		input = sc.nextInt();
		System.out.println("Your option  are" + input);
		System.out.println("Movie has been deleted.");
		
	}
		
}	
	



