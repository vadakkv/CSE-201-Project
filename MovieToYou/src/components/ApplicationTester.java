package components;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

class ApplicationTester {

	@Test
	void getResultSetTest() {
		//This test in order to test whether connect to online database successfully.
		// In the very beginning, we set rs(ResultSet Object) as null,
		// if we successfully connect to database, the rs will no longer be null.
	 getResultSet("SELECT title FROM Movies WHERE title LIKE '%Wanted%'");
	 assertTrue(rs!=null);
	}
	@Test
	void getMoviesTest() {
		assertTrue( getResultSet("SELECT title FROM Movies WHERE title LIKE '%Wanted%'")!=null);
		// This test in order to test whether the sql syntax is correct. If it is not correct, it will throws
		//sqlexception.
	}
	
	@Test
	void listResultsTest() throws SQLException {
		ResultSet movies = getMovies("Wanted");
   	 ArrayList<String> movieList = new ArrayList<String>();
   	 // before add objects to arraylist, test the arraylist is empty.
   	 assertTrue(movieList.isEmpty());
   	 assertEquals(movieList.size(),0);
   	 while(movies.next()) {
   		movieList.add(movies.getString(1));
   		// create a resultSet object arraylist. then add objects to movie list.
   		assertFalse(movieList.isEmpty()); // after add, there should be some objects in the arraylist.
   	 }
	}
  	 static Connection con = null;
    static ResultSet rs = null;
    static PreparedStatement ps = null;
     public static ResultSet getResultSet(String sql) {
   	 /* 
   	 Username: HIyCHr9sq4
   	 Database name: HIyCHr9sq4
   	 Password: QcvQ9fBLWp
   	 Server: remotemysql.com
   	 */

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
     static public ResultSet getMovies(String input) {
    	 String sql = "SELECT title FROM Movies WHERE title LIKE '%" + input + "%'";
    	 return getResultSet(sql);
     }
	
}
