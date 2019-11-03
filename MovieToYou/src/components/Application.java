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
	 
	
	 
     public ResultSet getMovieDetails(String title){
         return getResultSet("select * from movies where movieId = " + title);
     }
     
     static public ResultSet getMovies(String input) {
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
     
     static public ResultSet getResultSet(String sql) {
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
