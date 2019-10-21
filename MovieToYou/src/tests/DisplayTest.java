package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

import components.MovieInfo;

class DisplayTest {
	@Test
	void TestActionPerformed() {
		String s= "Wanted";
	    MovieInfo f = new MovieInfo();
	    ResultSet rs = null;
	    String fn = "rate";
	    String ln = "releaseDate";
	    String ag = "year";
	    rs = f.getInfo(s);
	    String rate = "";
	    String year = "";
	    String releaseDate = "";
	    try{
	        if(rs.next()){
	            rate = rs.getString("rate");
	             releaseDate =  rs.getString("releaseDate");
	                year = rs.getString("year");
	       }  else{
	            JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
	        }
	      }catch(Exception ex){
	             JOptionPane.showMessageDialog(null, ex.getMessage() + "test");
	              }
		 assertEquals(rate, "10");
		 assertEquals(year, "1996");
		 assertEquals(releaseDate,"Oct 15, 2018");	
		 assertFalse(rate.equals("8"));
		 assertFalse(year.equals("1997"));
		 assertFalse(releaseDate.equals("Oct 16, 2018"));
		 // All result match the movieInfo from database, that means the test pass.
	      }
	}
	



