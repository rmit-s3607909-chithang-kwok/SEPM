import java.util.ArrayList;
import java.util.Scanner;

public class Management {
	 private static String username;
	 private static String Password;
	
	 ArrayList<Customer> customers = new ArrayList<Customer>();
	 ArrayList<Movie> movies = new ArrayList<Movie>();
	 ArrayList<BookingClerk> bookingClerks = new ArrayList<BookingClerk>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		Scanner sc = new Scanner(System.in);
		
		//Booking[] Booking = new Booking[20];
		//System.out.println("Please enter your username and passsword");
		//System.out.println("Your username" + username + "Your Password" + Password);
		
	   // if (isValid != TRUE) {
	    	//System.out.println("Your uaername and password are not valid please type again.");
	    	//else
	    	//System.out.println("Login Successfully");
			
	    //}
		
		do {
			System.out.println("Welcome to the CinenoPlex Management System (JMOSS). ");
			System.out.println("=================================");
			System.out.println("1. Search movie");
			System.out.println("2. Search Cinema");
			System.out.println("3. Create Booking");
			System.out.println("4. Delete Booking");
			System.out.println("5. Logout");
			System.out.println("                                ");
			System.out.println("Enter an Option:                ");
			
			input = sc.nextInt();
			System.out.println("  Your options are:  " + input);
			
			switch(input) {
			case 1:
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
	}while(input!=5);

}
	public void createBooking() 
	{
		String CustomerID;
		int movieSelection;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your Customer ID: ");
		CustomerID = sc.nextLine();
		
		for(int i = 0; i < customers.size(); i++)
		{
		if(CustomerID.equals(customers.get(i).getID()))
			{
			break;
			}
		}
		
		System.out.println("Please enter movie: ");
		for(int i = 0; i < movies.size(); i++)
		{
			System.out.println(i+1 + ". " + movies.get(i).getName());
		}
		
		movieSelection=sc.nextInt();
		
		
		
	}
	///public boolean isValid() {
		
	
	//}
}