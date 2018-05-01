import java.util.Scanner;

public class Management {

	

	public static void main(String[] args) {
		int input = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Welcome to the CinenoPlex Management System (JMOSS). ");
			System.out.println("=================================");
			System.out.println("1. Create Booking");
			System.out.println("2. Delete Booking");
			System.out.println("3. Search Movie");
			System.out.println("4. Search Cinema");
			System.out.println("5. Logout");
			System.out.println("                                ");
			System.out.println("Enter an Option:                ");
			
			input = sc.nextInt();
			System.out.println("  Your options are:  " + input);
			
			switch(input) {
			case 1:
				createBooking();
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
	}
	while(input!=5);

}
}