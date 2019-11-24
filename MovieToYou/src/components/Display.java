package components;
import javax.swing.*; 
import java.sql.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Display extends JFrame {
	 
	JLabel search_label;
    JTextField search_field;
    JButton search_button; //initializing GUI elements
    JButton sort_button;
    JFrame frame = new JFrame("movie2you");
    JPanel top_panel;
    JPanel movie_list_panel;
    JPanel right_panel;
    JScrollPane scroll_pane;
    
    JPanel movieDetails_Panel;
    JLabel dTitle;
    JLabel dRunTime;
    JLabel dRating;
    JLabel dMpaaRating;
    JLabel dReleaseDate;
    JButton backBtn;
    
    public void showMovieDetails(ArrayList<String> details, User user) {
  	  dTitle = new JLabel("Movie Title: " + details.get(0));
  	  dRunTime = new JLabel("Runtime: " + details.get(1));
  	  dRating = new JLabel("Rating: " + details.get(2));
  	  dMpaaRating = new JLabel("mpaaRating: " + details.get(3));
  	  dReleaseDate = new JLabel("releaseDate: " + details.get(4));
  	  backBtn = new JButton("Go Back to Searching");
  	  backBtn.addActionListener(user);
  	  movieDetails_Panel = new JPanel(new GridLayout(0,1));
  	  movieDetails_Panel.add(dTitle);
  	  movieDetails_Panel.add(dRunTime);
  	  movieDetails_Panel.add(dRating);
  	  movieDetails_Panel.add(dMpaaRating);
  	  movieDetails_Panel.add(dReleaseDate);
  	  movieDetails_Panel.add(backBtn);
  	  
  	  frame.remove(scroll_pane);
  	  frame.remove(top_panel);
  	  frame.remove(right_panel);
  	  frame.add(movieDetails_Panel, BorderLayout.CENTER);
  	  frame.validate();
  	  frame.repaint();
    }
    
    
    public Display(){
    }
    public JTextField getSearchField() {
    	return search_field;
    }
   
      public void setUpStartDisplay(User user) {
    	  if(movieDetails_Panel != null) {
    		  frame.remove(movieDetails_Panel);
    		  frame.validate();
    		  frame.repaint();
    		  
    	  }
    	  search_label = new JLabel("Enter Movie:");
    	  search_field = new JTextField("movie name");
    	  search_field.setColumns(20);
    	  search_button = new JButton("Search");
    	  search_button.addActionListener(user);
    	  sort_button = new JButton("Sort abc");
    	  sort_button.addActionListener(user);
    	  
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.setSize(600,500);
    	  frame.setLayout(new BorderLayout());
    	  
    	  right_panel = new JPanel(new GridLayout(0,1));
    	  right_panel.add(sort_button);
    	  top_panel = new JPanel();
    	  top_panel.add(search_label, BorderLayout.NORTH);
    	  top_panel.add(search_field, BorderLayout.NORTH);
    	  top_panel.add(search_button, BorderLayout.NORTH);
    	  frame.add(top_panel, BorderLayout.NORTH);
    	  frame.add(right_panel, BorderLayout.EAST);
    	  frame.setLocationRelativeTo(null);
    	  frame.setVisible(true);
      }
      
      
      
      public void displayMovies(ArrayList<String> movieList, User user) {
    	  if (scroll_pane != null) {
    		  frame.remove(scroll_pane);
    	  }
    	  movie_list_panel = new JPanel(new GridBagLayout());
    	  GridBagConstraints c = new GridBagConstraints();
    	  c.gridwidth = 1;
		  c.weightx = 1;
		  c.weighty = 1;
		  c.fill = GridBagConstraints.HORIZONTAL;
		  c.gridx = 0;
		  c.gridy = 0;
    	  for(String s: movieList) {
    		  //for(int i =0; i<25; i++) {for showing the scroll bar usage
    		  c.gridy++;
    		  JButton tempBtn = new JButton(s);
    		  tempBtn.addActionListener(user);
    		  movie_list_panel.add(tempBtn, c);
    		  //}
    	  }
    	  scroll_pane = new JScrollPane(movie_list_panel);
    	  scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    	  frame.add(scroll_pane, BorderLayout.CENTER);
    	  frame.validate();
    	  frame.repaint();
    	  //frame.update(frame.getGraphics());
      }
      

      public static void main(String[] args){
    	  Display myDisplay = new Display();
    	  new User(myDisplay);
    	  //new Display();
    	  // make a display object
    	  // pass in display object where needed
    	  // application will probably need to take a parameter of type Display
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