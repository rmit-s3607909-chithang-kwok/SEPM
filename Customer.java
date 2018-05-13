
import java.util.ArrayList;

public class Customer
{
	
	String name;
	String email;
	String suburb;
	String id;
	ArrayList<Booking> bookings =  new ArrayList<Booking>();
	//ArrayList<Booking> bookings = new ArrayList<Booking>();
	
	public Customer(String name, String id, String email, String suburb)
	{
		this.name = name;
		this.id = id;
		this.email = email;
		this.suburb = suburb;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void listBookings()
	{
		for(int k = 0; k<bookings.size(); k++)
		{
			System.out.println((k+1) + ". " + bookings.get(k).getSession());
		}
	}
	public void addBooking(Booking booking)
	{
		bookings.add(booking);
	}
}