import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {

	private double[][] d1 = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
	private double[][] d2 = {{100.33, 12.13, 201.91}, {123.21, 248.48}, {192, 5.3, 7.29}};
	private double[][] d3 = {{1192, 2133, 3442, 8888}, {2132, 3433}, {4122, 5231, 6324}, {1, 2, 3, 4}};
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculateHolidayBonus() {
		assertEquals(3, HolidayBonus.calculateHolidayBonus(d1).length);
		assertEquals(3, HolidayBonus.calculateHolidayBonus(d2).length);
		assertEquals(4, HolidayBonus.calculateHolidayBonus(d3).length);
	}

	@Test
	void testCalculateTotalHolidayBonus() {
		assertEquals(22000, HolidayBonus.calculateTotalHolidayBonus(d1));
		assertEquals(22000, HolidayBonus.calculateTotalHolidayBonus(d2));
		assertEquals(34000, HolidayBonus.calculateTotalHolidayBonus(d3));
	}

}
