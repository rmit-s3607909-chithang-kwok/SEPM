import java.util.Scanner;

public class Management {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 0;
		Scanner sc = new Scanner(System.in);
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
}