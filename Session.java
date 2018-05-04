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
	
		
	public void deleteBooking(Customer customer) 
	{
		for(int i = 0; i< bookings.size(); i++)
		{
			if(bookings.get(i).customer == customer)
			{
				bookings.remove(i);
			}
		}
	}
}	
	



