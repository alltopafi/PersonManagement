package alltop.personmanagement.personManagement.controller;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@Test
	public void testSortOptionsWithValidDigit() {
		sortOptionsHelper("2", 2);

	}
	
	@Test
	public void testSortOptionsWithInValidDigit() {
		sortOptionsHelper("5" + System.getProperty("line.separator") + "1", 1);

	}
	
	@Test
	public void testSortOptionsWithInValidCharacter() {
		sortOptionsHelper("h" + System.getProperty("line.separator") + "3", 3);
	}
	
	private void sortOptionsHelper(String input, int expected) {
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		assertEquals(expected,controller.sortOptions());
	}
}
