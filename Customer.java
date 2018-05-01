
import java.util.ArrayList;

public class Customer
{
	
	String name;
	String id;
	String email;
	String suburb;
	
	ArrayList<Booking> bookings = new ArrayList<Booking>();
	
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
	
}