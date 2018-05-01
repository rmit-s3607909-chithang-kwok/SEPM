import java.util.*;
import java.util.ArrayList;

public class Session{
ArrayList<Booking> bookings =  new ArrayList<Booking>(20);
private int date;
private int id;
Movie movie;

	public Session(int date, int id, Movie movie) {
		this.date = date;
		this.id=id;
		this.movie=movie;
	     
	}

	public int getid() {
		return id;
	}
	
	public int getdate() {
		return date;
	}
	
	public void setid() {
		this.id = id;
	}
	
	public void setdate() {
		this.date=date;
	}
	
	public static void MakeBooking() {
		int input;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select the Movie you want to watch?");
		System.out.println("1. Avenger3");
		System.out.println("2. Black Panther");
		System.out.println("3. Rampage");
		
		
		input = sc.nextInt();
		System.out.println("Your option  are" + input);
		System.out.println("Movie Booking has been created.");
		
		
		
		System.out.println("Thank you for your booking.");
		
		
		}
	
		
	
	

	public static void DeleteBooking() {
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
	



