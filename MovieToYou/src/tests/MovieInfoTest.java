package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

class MovieInfoTest {

	@Test
	void testgetInfo() {
		getInfo("Wanted");
		assertTrue(rs != null);
		// If rs is not null, that means rs was set, so the database is connected.
		assertTrue(ps!=null);
		// ps was also set with info from database.
	}
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public ResultSet getInfo(String s){
        try{
     	   //Server:sql9.freemysqlhosting.net
     	   //UserName:sql9309198
     	   //Password:TWVhcmyt29
     	   //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net/sql9309198","sql9309198","TWVhcmyt29");
        ps = con.prepareStatement("select * from movies where movieId = ?");
        ps.setString(1,s);
        rs = ps.executeQuery();
        }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
    } 
}

