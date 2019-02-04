package alltop.personmanagement.personManagement.controller;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SelectionControllerTest {

	private SelectionController controller = new SelectionController();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() throws IOException {
	    System.setOut(originalOut);
	    System.in.close();
	}
	
	@Test
	public void testSortOptionsWithValidDigit() {
		sortOptionsHelper("2", 2);
		 assertEquals("How would you like to sort the given data?\n" + 
		 		"Output 1 – sorted by gender (females before males) then by last name ascending.\n" + 
		 		"Output 2 – sorted by birth date, ascending.\n" + 
		 		"Output 3 – sorted by last name, descending.\n", outContent.toString());

	}
	
	@Test
	public void testSortOptionsWithInValidDigit() {
		sortOptionsHelper("5" + System.getProperty("line.separator") + "1", 1);
		assertEquals("How would you like to sort the given data?\n" + 
		 		"Output 1 – sorted by gender (females before males) then by last name ascending.\n" + 
		 		"Output 2 – sorted by birth date, ascending.\n" + 
		 		"Output 3 – sorted by last name, descending.\n" +
				"Please enter 1, 2, or 3\n", outContent.toString());

	}
	
	@Test
	public void testSortOptionsWithInValidCharacter() {
		sortOptionsHelper("h" + System.getProperty("line.separator") + "3", 3);
		assertEquals("How would you like to sort the given data?\n" + 
		 		"Output 1 – sorted by gender (females before males) then by last name ascending.\n" + 
		 		"Output 2 – sorted by birth date, ascending.\n" + 
		 		"Output 3 – sorted by last name, descending.\n" +
				"Please enter 1, 2, or 3\n", outContent.toString());
	}
	
	private void sortOptionsHelper(String input, int expected) {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals(expected,controller.sortOptions());
	}
}
