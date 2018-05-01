import java.util.ArrayList;

public class Cinema{

	public Cinema() {
		String location;
		String id;
		
		ArrayList movieSessions = new ArrayList();
		
		public void listSessions()
		{
			for(int i=0; i<movieSessions.size(); i++) {
				System.out.println(movieSessions.get(i). +":"+ movieSessions.get(i).mark +", "+ movieSessions.get(i).grade);
			}
		}
		
	}

}
