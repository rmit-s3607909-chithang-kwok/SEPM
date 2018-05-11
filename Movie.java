
public class Movie {
    // read
	private String name;
    private String[] date;
    
    public Movie(String name) {
		// TODO Auto-generated constructor stub
    	this.name = name;
	}

    public String getName()
    {
    	return name;
    }

	public void addSession(String date[]) {
		this.date = date;
		
	}  
	
	
	public String[] getDate()
	{
		return date;
	}
	
	

}





