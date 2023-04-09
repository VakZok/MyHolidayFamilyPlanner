package JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fh.aalen.familienmitglied.Familienmitglied;
import fh.aalen.urlaub.Urlaub;

public class FamilienmitgliedTest {

	static Familienmitglied f;
	static Urlaub u;

	@BeforeAll
	public static void init() {
		f = new Familienmitglied();
		u = new Urlaub();
	}

	@Test
	public void addFamilienmitglied() {
		f.setId(10);
		f.setName("Test");
		f.setGeburtstag("01.01.2000");
		assertEquals(10, f.getId(), 0.0);
		assertEquals("Test", f.getName(), "");
		assertEquals("01.01.2000", f.getGeburtstag(), "");
	}

	@Test
	public void addUrlaub() {
		u.setId(10);
		u.setTitel("Test");
		u.setZeitraum("01.01.2000-07.01.2000");
		assertEquals(10, u.getId(), 0.0);
		assertEquals("Test", u.getTitel(), "");
		assertEquals("01.01.2000-07.01.2000", u.getZeitraum(), "");
	}

}
