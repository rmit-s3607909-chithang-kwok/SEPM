import java.util.ArrayList;

public class BookingClerk {
	private String username;
	private String password;
	private String id;
	 private static ArrayList<BookingClerk> bookingClerks = new ArrayList<BookingClerk>();
	
	public BookingClerk(String username, String password, String id) {
		this.username=username;
		this.password=password;
		this.id=id;
	}

	public String getUsername(){
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getid() {
		return id;
	}

	public void addBookingClerk(BookingClerk BookingClerk)
	{
		bookingClerks.add(BookingClerk);
	}
}


