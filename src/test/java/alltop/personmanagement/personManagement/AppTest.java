package alltop.personmanagement.personManagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class AppTest {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setup() {
		System.setOut(new PrintStream(outContent));	
	}
	
	@After
	public void restoreStreams() throws IOException {
		System.setOut(System.out);
		System.in.close();
	}
	
	@Test
	public void testConstructor() {
		App app = new App();
		assertNotNull(app);
	}

	@Test(expected = Exception.class)
	public void testMainException() throws Exception {
		App.main(new String[0]);
	}

	@Test
	public void testMain() throws Exception {
		File output = tempFolder.newFile("output.txt");
		PrintWriter writer = new PrintWriter(new FileWriter(output));
		writer.println("testLast, testFirst male | color | 11/11/1992");
		writer.println("testLast, testFirst female | color | 11/11/1992");
		writer.println("testLast, testFirst female | color | 11/11/1992");
		writer.close();
		String[] args = { output.getAbsolutePath() };
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		App.main(args);
		
		assertEquals("How would you like to sort the given data?\n" + 
				"Output 1 – sorted by gender (females before males) then by last name ascending.\n" + 
				"Output 2 – sorted by birth date, ascending.\n" + 
				"Output 3 – sorted by last name, descending.\n" + 
				"TESTLAST TESTFIRST FEMALE COLOR 11/11/1992\n" + 
				"TESTLAST TESTFIRST MALE COLOR 11/11/1992\n", outContent.toString());
		outContent.reset();
		assertEquals("", outContent.toString());
		
	}

}