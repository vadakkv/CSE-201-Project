package components;

import java.sql.*; 

import javax.swing.JOptionPane;

	public class MovieInfo{
		   
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

