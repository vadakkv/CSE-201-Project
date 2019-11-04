import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserTester {

	@Test
	void searchTest() throws SQLException {
		ArrayList<String> movies = Application.listResults("Wanted");
		// Select the movie title include "Wanted", then add to movie arraylist, now the arraylist should not be empty.
		assertFalse(movies.isEmpty());
		// Adding title movie to arraylist, so the value of first index in arraylist must be "Wanted".
		assertEquals(movies.get(0),"Wanted");
		// the size should be 1
		assertEquals(movies.size(),1);
	}

}
