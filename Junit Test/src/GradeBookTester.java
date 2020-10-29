import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	GradeBook g1;
	GradeBook g2;
	@BeforeEach
	void setUp() throws Exception {
		 g1 = new GradeBook(5);
		 g2 = new GradeBook(5);

         g1.addScore(50);
	     g1.addScore(75);
 	     g1.addScore(80);
 	    
	     g2.addScore(65);
		 g2.addScore(89);
	     g2.addScore(90);
	}

	@AfterEach
	void tearDown() throws Exception {
		 g1 = null;
		 g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals(g1.toString()));
		assertTrue(g2.toString().equals(g2.toString()));	
	}

	@Test
	void testSum() {
		assertEquals(205, g1.sum(), .0001);
		assertEquals(244, g2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(50, g1.minimum(), .001);
		assertEquals(65, g2.minimum(), .001);	}

	@Test
	void testFinalScore() {
		assertEquals(155, g1.finalScore(), .01);
		assertEquals(179, g2.finalScore(), .01);
	}

}
