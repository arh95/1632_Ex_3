import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.*;

import org.junit.*;
import org.mockito.*;
public class TestRentACat{
	RentACat _r;
	
	@Before
	public void setup(){
		_r = new RentACat();
	}
	//test that trying to return a rented cat returns true
	@Test
	public void testReturnRentedCat(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getRented()).thenReturn(true);
		assertTrue(_r.returnCat(mockCat));
	}
	//test that trying to return a returned cat returns false (look at that tongue twister)
	@Test
	public void testReturnReturnedCat(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getRented()).thenReturn(false);
		assertFalse(_r.returnCat(mockCat));
	}
	//test that trying to rent a rented cat returns false
	@Test
	public void testRentRentedCat(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getRented()).thenReturn(true);
		assertFalse(_r.rentCat(mockCat));
	}
	//test that trying to rent a returned cat returns a true
	@Test
	public void testRentReturnedCat(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getRented()).thenReturn(false);
		assertTrue(_r.rentCat(mockCat));
	}
	//test that the listCats method formats as expected
	@Test
	public void testReturnedList(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.toString()).thenReturn("CAT");
		when(mockCat.getRented()).thenReturn(false);
		String shouldBe = "CAT\nCAT\nCAT";
		ArrayList<Cat> catList = new ArrayList();
		for(int i = 0; i < 3; i++){
			catList.add(mockCat);
		}
		assertEquals(shouldBe, _r.listCats(catList));
	}
	//test that the listCats method does not include rented cats in its output
	@Test
	public void testRentedList(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.toString()).thenReturn("CAT");
		when(mockCat.getRented()).thenReturn(true);
		String shouldBe = "";
		ArrayList<Cat> catList = new ArrayList();
		for(int i = 0; i < 3; i++){
			catList.add(mockCat);
		}
		assertEquals(shouldBe, _r.listCats(catList));
	}
	//test that the listCats method does not fail when encountering a null reference
	@Test
	public void testNullCatIgnoredToString(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.toString()).thenReturn("CAT");
		when(mockCat.getRented()).thenReturn(false);
		String shouldBe = "CAT\nCAT\nCAT";
		ArrayList<Cat> catList = new ArrayList();
		for(int i = 0; i < 3; i++){
			catList.add(mockCat);
		}
		catList.add(null);
		assertEquals(shouldBe, _r.listCats(catList));
	}
	//test that if a Cat object exists in the arraylist with the specified ID,
	//true is returned
	@Test
	public void testCatExistsInList(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getId()).thenReturn(5);
		ArrayList<Cat> catList = new ArrayList();
		catList.add(mockCat);
		assertTrue(_r.catExists(5,catList));
	}
	//test that if there is not a Cat object that exists in the arraylist with the 
	//specified ID, false is returned
	@Test
	public void testCatNotInList(){
		Cat mockCat = mock(Cat.class);
		when(mockCat.getId()).thenReturn(5);
		ArrayList<Cat> catList = new ArrayList();
		catList.add(mockCat);
		assertFalse(_r.catExists(6,catList));
	}
	//test that a null reference is treated as a mismatch ID value and will not
	//cause the program to crash
	@Test
	public void testNullCatIgnoredCatExists(){
		ArrayList<Cat> catList = new ArrayList();
		catList.add(null);
		assertFalse(_r.catExists(6, catList));
	}

	
}