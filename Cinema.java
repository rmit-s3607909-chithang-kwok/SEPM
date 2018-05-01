import java.util.ArrayList;

public class Cinema{

	private String location;
	private String id;
	ArrayList<Session> movieSessions = new ArrayList<Session>();
	
	public Cinema(String location, String id) 
	{
		this.location =location;
		this.id = id;
	}
	
	public void addSession(Session session)
	{
		movieSessions.add(session);
	}
	
	public void listSessions()
	{
		for(int i=0; i<movieSessions.size(); i++) 
		{
			System.out.println(movieSessions.get(i).getid() + movieSessions.get(i).getdate());
		}
	}
	
}
