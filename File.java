import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.util.*;



public class File {
	private Formatter x;
	
	
	public void openFile()
	{
		try
		{
			x = new Formatter("Booking.txt");
		}
		catch (Exception e)
		{
			System.out.println("You have an error");
		}
		
		
	}
	
	
	public void writeToFile(Cinema cinema, Movie movie, Session session, Customer customer)
	{
		
		x.format("%s%s%s%s", cinema, movie, session, customer);
		
	}
	
	public void closeFile()
	{
		x.close();
	}
	
	
}
