package components;
import javax.swing.*; 
import java.sql.*;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.event.*;

public class Display extends JFrame implements ActionListener{
    JLabel JL_rate,JL_releaseDate,JL_year,JL_name;
    JTextField JT_rate,JT_releaseDate,JT_year,JT_name;
    static JButton btn_search; //initializing GUI elements

      public Display(){
    	  //Sets GUI Elements
          super("Search");
          JL_name = new JLabel("Enter Name:");
          JL_name.setBounds(20, 20, 200, 20);
          JT_name = new JTextField(20);
          JT_name.setBounds(130, 20, 150, 20);
          btn_search = new JButton("Search");
          btn_search.setBounds(300, 20, 80, 20);
          btn_search.addActionListener(this);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(500,500);
          
          /*JL_rate = new JLabel("Rate: ");
          JL_rate.setBounds(20, 50, 100, 20);
          JT_rate = new JTextField(20);
          JT_rate.setBounds(130, 50, 150, 20);
          JL_releaseDate = new JLabel("Release: ");
          JL_releaseDate.setBounds(20, 80, 100, 20);
          JT_releaseDate = new JTextField(20);
          JT_releaseDate.setBounds(130, 80, 150, 20);
          JL_year = new JLabel("Age: ");
          JL_year.setBounds(20, 110, 100, 20);
          JT_year = new JTextField(20);
          JT_year.setBounds(130, 110, 150, 20);
          */
          //add(JL_rate);
          //add(JT_rate);
          //add(JL_releaseDate);
          //add(JT_releaseDate);
          //add(JL_year);
          //add(JT_year);
          
          //adds Gui elements on window
          setLayout(null);
          add(btn_search);
          add(JL_name);
          add(JT_name);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	String input = JT_name.getText();
    	User user = new User();
    	try {
			user.search(input);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    /*public void displayMovieList(ArrayList<String> movieList) {
    	int numRows = movieList.size();
    	//setLayout(new GridLayout(numRows,1));
    	for(int i=0; i < numRows; i++) {
    		btn_search = new JButton("");
            btn_search.setBounds(300, 20, 80, 20);
            add(btn_search);
            //btn_search.addActionListener(this);
            
    	}
    }
    */
    

    
 public static void main(String[] args){
	 new Display();
 }


 
}
//User.selectMovie();

/*	
MovieInfo f = new MovieInfo();
ResultSet rs = null;
String fn = "rate";
String ln = "releaseDate";
String ag = "year";

rs = f.getInfo(JT_name.getText()); < - IMPORTANT LINE OF CODE
try{
  if(rs.next()){
      JT_rate.setText(rs.getString("rate"));
        JT_releaseDate.setText(rs.getString("releaseDate"));
          JT_year.setText(rs.getString("year"));
  }  else{
      JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
  }
} catch(Exception ex){
       JOptionPane.showMessageDialog(null, ex.getMessage());
        } */