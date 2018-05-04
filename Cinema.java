import java.util.ArrayList;

public class Cinema
{
	private String location;
	//private int id;
	ArrayList<Movie> movies = new ArrayList<Movie>();
	ArrayList<Session> cinemaSessions = new ArrayList<Session>();
	/*
	public void listSessions(String match)
	{
		for(int i=0; i<cinemaSessions.size(); i++) 
		{
			//System.out.println(cinemaSessions.get(i).getid() + cinemaSessions.get(i).getdate());
			
		}
	}	
*/
	public Cinema(String location) 
	{
		this.location=location;
		//this.id=id;
	}
	
	public String getLocation()
	{
		return location;
	}

	public void addSession(String date, Movie movie)
	{
		Session session = new Session(date, movie);
		cinemaSessions.add(session);
	}
	
	public void addMovie(Movie movie)
	{
		movies.add(movie);
	}
}
