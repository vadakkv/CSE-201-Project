package components;
import javax.swing.*; 
import java.sql.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Display extends JFrame implements ActionListener{
    
	 
	JLabel search_label;
    JTextField search_field;
    JButton search_button; //initializing GUI elements
    JFrame frame = new JFrame("movie2you");
    JPanel top_panel;
    JPanel movie_list_panel;
      
    public Display(){
    	setUpStartDisplay();  
    }
   
      public void setUpStartDisplay() {
    	  search_label = new JLabel("Enter Movie:");
    	  search_field = new JTextField("movie name");
    	  search_button = new JButton("Search");
    	  search_button.addActionListener(this);
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.setSize(600,500);
    	  frame.setLayout(new BorderLayout());
    	  
    	  top_panel = new JPanel();
    	  top_panel.add(search_label, BorderLayout.NORTH);
    	  top_panel.add(search_field, BorderLayout.NORTH);
    	  top_panel.add(search_button, BorderLayout.NORTH);
    	  frame.add(top_panel, BorderLayout.NORTH);
    	  
    	  frame.setLocationRelativeTo(null);
    	  frame.setVisible(true);
      }
      public void displayMovies(ArrayList<String> movieList) {
    	  movie_list_panel = new JPanel(new GridLayout(0,1));
    	  for(String s: movieList) {
    		  movie_list_panel.add(new JButton(s));
    	  }
    	  frame.add(movie_list_panel, BorderLayout.CENTER);
      }

    @Override
    public void actionPerformed(ActionEvent e) {
    	String input = search_field.getText();
    	User user = new User();        /////NEED TO CHANGE THIS IT IS OPENING A NEW WINDOW!
    	try {
			user.search(input);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    

    
    	public static void main(String[] args){
    		new User();
    		//new Display();
    	}
 
 
 
	}






/*JL_name = new JLabel("Enter Movie:");
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

setLayout(null);
add(btn_search);
add(JL_name);
add(JT_name);
*/
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