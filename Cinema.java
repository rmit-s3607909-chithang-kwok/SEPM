import java.util.ArrayList;

public class Cinema
{
	private String location;
	ArrayList<Movie> movies = new ArrayList<Movie>();
	public ArrayList<Session> cinemaSessions = new ArrayList<Session>();

	public Cinema(String location) 
	{
		this.location=location;
		//this.id=id;
	}
	
	public String getLocation()
	{
		return location;
	}

	public void addSession(String id, String date, Movie movie)
	{
		Session session = new Session(id, date, movie);
		cinemaSessions.add(session);
	}
	
	public void addMovie(Movie movie)
	{
		movies.add(movie);
	}
	
	public void listSessions()
	{
		for(int i = 0; i < cinemaSessions.size(); i++)
		{
			System.out.println((i+1) + "." + cinemaSessions.get(i).getMovie() + " " + cinemaSessions.get(i).getDate());
		}
	}
}
