package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class User implements ActionListener{
	
	public Display display;
	public Application app;
	
	public User(Display display) {
		this.display = display;
		this.app = new Application();
		setUpDisplay();
	}
	public void setUpDisplay() {
		display.setUpStartDisplay(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String buttonText = ((JButton) e.getSource()).getText();
		if(buttonText == "Search") {
			try {
				search(display.getSearchField().getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} else if(buttonText == "Sort abc") {
			sort();
		} else if(buttonText == "Go Back to Searching") {
			display.setUpStartDisplay(this);
		} else {
			try {
				selectMovie(buttonText);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void search(String input) throws SQLException {
		
		ArrayList<String> movies = Application.listResults(input);
		display.displayMovies(movies, this);
		app.setMovieList(movies);
	}
	
	public void sort() {
		ArrayList<String> movieList = new ArrayList<String>();
		movieList = app.getMovieList();
		Collections.sort(movieList);
		app.setMovieList(movieList);
		display.displayMovies(movieList, this);
	}
	
	public void selectMovie(String title) throws SQLException {
		ArrayList<String> details = app.getMovieDetails(title);
		display.showMovieDetails(details, this);
	}
}
