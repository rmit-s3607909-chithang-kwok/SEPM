
public class Booking{
	
	String id;
	Customer customer;	

	
	public Booking(/*String id, */Customer customer) 
	{
		this.id = id;
		this.customer = customer;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getCustomer()
	{
		return customer.getEmail();
	}

	

}