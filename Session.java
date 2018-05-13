import java.util.*;
import java.util.ArrayList;

public class Session{
ArrayList<Booking> bookings =  new ArrayList<Booking>(20);
private String date;
private String id;
public Movie movie;

	public Session(String id, String date, Movie movie) {
		this.date = date;
		this.id = id;
		this.movie=movie;
	}
	public void makeBooking(/*String id,*/ Customer customer) 
	{
		Booking booking = new Booking(id, customer, this);
		bookings.add(booking);
		customer.addBooking(booking);
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getDate()
	{
		return date;
	}
		
	public String getMovie()
	{
		return movie.getName();
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
	public void listBookings()
	{
		for(int i = 0; i < bookings.size(); i++)
		{
			System.out.println((i+1) + ". " + bookings.get(i).getID() + " " + bookings.get(i).getCustomer());
		}
	}
}	
	



