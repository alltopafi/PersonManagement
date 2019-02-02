package alltop.personmanagement.personManagement;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AppTest {

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
		String[] args = { "test" };
		App.main(args);
	}

}