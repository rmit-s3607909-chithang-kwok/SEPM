
public class Booking{
	
	String id;
	Customer customer;	
	Session session;

	
	public Booking(String id, Customer customer, Session session) 
	{
		this.id = id;
		this.customer = customer;
		this.session = session;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getCustomer()
	{
		return customer.getEmail();
	}
	
	public String getSession()
	{
		return (session.getID() + " " + session.getMovie() +  " " + session.getDate());
	}
	

}