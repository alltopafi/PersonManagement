package alltop.personmanagement.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenerEnumTest {

	@Test(expected = IllegalArgumentException.class)
	public void testGenderEnum() {
		assertEquals(3, GenderEnum.values().length); 
		assertEquals(GenderEnum.FEMALE, GenderEnum.valueOf("FEMALE"));
		assertEquals(GenderEnum.MALE, GenderEnum.valueOf("MALE"));
		assertEquals(GenderEnum.OTHER, GenderEnum.valueOf("OTHER"));
		assertEquals(null, GenderEnum.valueOf("invalid"));
	}
}
