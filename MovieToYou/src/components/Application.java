package components;
import java.util.ArrayList;
/* 
Username: HIyCHr9sq4
Database name: HIyCHr9sq4
Password: QcvQ9fBLWp
Server: remotemysql.com
*/
import java.sql.*; 
import javax.swing.JOptionPane;

public class Application {
	 
	public ArrayList<String> movieList;
	
	public Application() {
		movieList = new ArrayList<String>();
	}
	public void setMovieList(ArrayList<String> MovieList) {
		this.movieList = MovieList;
	}
	public ArrayList<String> getMovieList() {
		return movieList;
	}
	
	public Application(ArrayList<String> movieList) {
		this.movieList = movieList;
	}
    public ArrayList<String> getMovieDetails(String title) throws SQLException{
    	ResultSet rs = getResultSet("SELECT * FROM Movies WHERE title = '" + title +"'");
    	ArrayList<String> mDetails = new ArrayList<String>();
   	 	while(rs.next()) {
   	 		System.out.println("Movie selected for details: "  + title);
   	 		System.out.println("Data found in database is follows:");
   	 		System.out.println(rs.getString("title"));
   	 		System.out.println(rs.getInt("runTime"));
   	 		System.out.println(rs.getString("rating"));
   	 		System.out.println(rs.getString("mpaaRating"));
   	 		System.out.println(rs.getString("releaseDate"));
   	 		mDetails.add(rs.getString("title"));
   	 		String runTime = rs.getInt("runTime") + ""; 
   	 		mDetails.add(runTime);
   	 		mDetails.add(rs.getString("rating"));
   	 		mDetails.add(rs.getString("mpaaRating"));
   	 		mDetails.add(rs.getString("releaseDate"));
   	 	}
		return mDetails;
    	
    }
     
     public static ResultSet getMovies(String input) {
    	 String sql = "SELECT title FROM Movies WHERE title LIKE '%" + input + "%'";
    	 return getResultSet(sql);
     }
     
     
     
     public static ArrayList<String> listResults(String input) throws SQLException {
    	 ResultSet movies = getMovies(input);
    	 ArrayList<String> movieList = new ArrayList<String>();
    	 //int i = 0; // start at 1?
    	 while(movies.next()) {
    		movieList.add(movies.getString(1));
    	 }
    	 return movieList;
     }
     
     public static ResultSet getResultSet(String sql) {
    	 /* 
    	 Username: HIyCHr9sq4
    	 Database name: HIyCHr9sq4
    	 Password: QcvQ9fBLWp
    	 Server: remotemysql.com
    	 */
    	 Connection con = null;
         ResultSet rs = null;
         PreparedStatement ps = null;
    	 try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://remotemysql.com/HIyCHr9sq4","HIyCHr9sq4","QcvQ9fBLWp");
             //con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9309198","sql9309198","TWVhcmyt29");
             ps = con.prepareStatement(sql);
             //ps.setString(1,s);
             rs = ps.executeQuery();
             }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
             }
             return rs;
     }
}
