import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TDDSortTest {

	// TDD: Sort function in user class.
	@Test
	void SortTest() throws SQLException {
		ArrayList <String> movies = new ArrayList<String>();
		User u = new User();
	    movies = u.search("ant");
	    ArrayList <String> moviesAfterSort = new ArrayList<String>();
	    moviesAfterSort = u.sort(movies);	    
	    // In our database table, the first one be selected is "Wanted", and the second one is "Ant man";
	    // After call the sort function, the first one should be "ant", and the second one should be "Wanted";
		assertEquals("Ant man", moviesAfterSort.get(0));
		assertEquals("Wanted", moviesAfterSort.get(1));
	}

}
