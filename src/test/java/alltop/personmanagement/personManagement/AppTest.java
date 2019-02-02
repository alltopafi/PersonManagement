package alltop.personmanagement.personManagement;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class AppTest {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
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
		String[] args = { output.getAbsolutePath() };
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		App.main(args);
	}

}