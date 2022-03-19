/**
 * 
 */
package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author Vasilije
 *
 */
class AutoGumaTest {
	
	AutoGuma a;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#AutoGuma()}.
	 */
	@Test
	void testAutoGuma() {
		a = new AutoGuma();
		
		assertEquals(null, a.getMarkaModel());
		assertEquals(-1, a.getPrecnik());
		assertEquals(-1, a.getSirina());
		assertEquals(-1, a.getVisina());
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#AutoGuma(java.lang.String, int, int, int)}.
	 */
	@Test
	@DisplayName("testiranje konstruktora sa parametrima")
	void testAutoGumaStringIntIntInt() {
		a = new AutoGuma("Michelin S", 16, 280, 45);
		
		assertEquals("Michelin S", a.getMarkaModel());
		assertEquals(16, a.getPrecnik());
		assertEquals(280, a.getSirina());
		assertEquals(45, a.getVisina());
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setMarkaModel(java.lang.String)}.
	 */
	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("Dunlop M+S");
		
		assertEquals("Dunlop M+S", a.getMarkaModel());
	}
	
	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setMarkaModel(java.lang.String)}.
	 */
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setMarkaModel(null));
	}
	
	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setMarkaModel(java.lang.String)}.
	 */
	@Test
	void testSetMarkaModelBrojKarakteraJe0() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setMarkaModel(""));
	}
	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setMarkaModel(java.lang.String)}.
	 */
	@Test
	void testSetMarkaModelBrojKarakteraJe1() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setMarkaModel("1"));
	}
	
	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setMarkaModel(java.lang.String)}.
	 */
	@Test
	void testSetMarkaModelBrojKarakteraJe2() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setMarkaModel("12"));
	}
	
	
	
	
	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setPrecnik(int)}.
	 */
	@Test
	void testSetPrecnik() {
		a.setPrecnik(15);
		
		assertEquals(15, a.getPrecnik());
	}
	
	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setPrecnik(int)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"4, java.lang.IllegalArgumentException.class",
		"30, java.lang.IllegalArgumentException.class",
		"15, null"
		
	})
	void testSetPrecnikRaspon(int precnik, Exception exception) {
		if(precnik < 13 || precnik > 22) {
			assertThrows(exception.getClass(), () -> a.setPrecnik(precnik));
		}
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setSirina(int)}.
	 */
	@Test
	void testSetSirina() {
		a.setSirina(250);
		
		assertEquals(250, a.getSirina());
	}
	
	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setSirina(int)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"4, java.lang.IllegalArgumentException.class",
		"390, java.lang.IllegalArgumentException.class",
		"150, null"
	})
	void testSetSirinaRaspon(int sirina, Exception exception) {
		if (sirina < 135 || sirina > 355) {
			assertThrows(exception.getClass(), ()-> a.setSirina(sirina));
		}
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setVisina(int)}.
	 */
	@Test
	void testSetVisina() {
		a.setVisina(50);
		
		assertEquals(50, a.getVisina());
	}
	
	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#setVisina(int)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"5, java.lang.IllegalArgumentException.class",
		"150, java.lang.IllegalArgumentException.class",
		"60, null"
	})
	void testSetVisinaRaspon(int visina, Exception exception) {
		if (visina < 25 || visina > 95) {
			assertThrows(exception.getClass(), ()-> a.setVisina(visina));
		}
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#toString()}.
	 */
	@Test
	void testToString() {
		a.setMarkaModel("Michelin M");
		a.setPrecnik(20);
		a.setSirina(255);
		a.setVisina(75);
		
		String s = a.toString();
		
		assertTrue(s.contains("Michelin M"));
		assertTrue(s.contains("20"));
		assertTrue(s.contains("255"));
		assertTrue(s.contains("75"));
		
	}

	/**
	 * Test method for {@link auto_radnja.gume.AutoGuma#equals(java.lang.Object)}.
	 */
	@ParameterizedTest
	@CsvSource({
		"Dunlop, 16, 225, 70, Dunlop, 16, 225, 70, true",
		"Dunlop, 16, 225, 70, Michelin, 16, 225, 70, false",
		"Dunlop, 16, 225, 70, Dunlop, 17, 225, 70, false",
		"Dunlop, 16, 225, 70, Dunlop, 16, 230, 70, false",
		"Dunlop, 16, 225, 70, Dunlop, 16, 225, 80, false",
		"Dunlop, 16, 225, 70, Michelin, 17, 225, 70, false",
		"Dunlop, 16, 225, 70, Michelin, 16, 230, 70, false",
		"Dunlop, 16, 225, 70, Michelin, 16, 225, 80, false",
		"Dunlop, 16, 225, 70, Dunlop, 17, 230, 70, false",
		"Dunlop, 16, 225, 70, Dunlop, 17, 225, 80, false",
		"Dunlop, 16, 225, 70, Dunlop, 16, 230, 80, false",
		"Dunlop, 16, 225, 70, Michelin, 17, 230, 70, false",
		"Dunlop, 16, 225, 70, Michelin, 17, 225, 80, false",
		"Dunlop, 16, 225, 70, Michelin, 16, 230, 80, false",
		"Dunlop, 16, 225, 70, Dunlop, 17, 230, 80, false",
		"Dunlop, 16, 225, 70, Michelin, 17, 230, 80, false",
	})
	void testEqualsObject(String model1, int precnik1, int sirina1, int visina1, 
			String model2, int precnik2, int sirina2, int visina2, boolean rezultat) {
		
		a.setMarkaModel(model1);
		a.setPrecnik(precnik1);
		a.setSirina(sirina1);
		a.setVisina(visina1);
		
		AutoGuma b = new AutoGuma();
		
		b.setMarkaModel(model2);
		b.setPrecnik(precnik2);
		b.setSirina(sirina2);
		b.setVisina(visina2);
		
		assertEquals(rezultat, a.equals(b));
	}

}
