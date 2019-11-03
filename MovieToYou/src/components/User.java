package components;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {

	Display display;
	public User() {
		display = new Display();
	}
	public void search(String input) throws SQLException {
		ArrayList<String> movies = Application.listResults(input);
		display.displayMovies(movies);
		for(String s: movies)
			System.out.println(s);
	}
	public void sort(String s) {
		
	}
	public void selectMovie(String s) {
		
	}
}
