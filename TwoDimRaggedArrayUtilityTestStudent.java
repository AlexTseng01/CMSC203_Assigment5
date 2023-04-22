import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {

	private double[][] d1 = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
	private double[][] d2 = {{100.3, 12.1, 201.1}, {123.1, 248.8}, {192.1, 5.3, 7.9}};
	private double[][] d3 = {{1192, 2133, 3442, 8888}, {2132, 3433}, {4122, 5231, 6324}, {1, 2, 3, 4}};
	private File f = new File("dataSet1.txt");
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReadFile() {
		try {
			assertEquals(4.5, TwoDimRaggedArrayUtility.getAverage(TwoDimRaggedArrayUtility.readFile(f)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
		}
	}

	@Test
	void testGetTotal() {
		assertEquals(36, TwoDimRaggedArrayUtility.getTotal(d1));
		assertEquals(890.7, TwoDimRaggedArrayUtility.getTotal(d2));
		assertEquals(36907, TwoDimRaggedArrayUtility.getTotal(d3));
	}

	@Test
	void testGetAverage() {
		assertEquals(4.5, TwoDimRaggedArrayUtility.getAverage(d1));
		assertEquals(111.34, TwoDimRaggedArrayUtility.getAverage(d2));
		assertEquals(2839, TwoDimRaggedArrayUtility.getAverage(d3));
	}

	@Test
	void testGetRowTotal() {
		assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(d1, 0));
		assertEquals(371.9, TwoDimRaggedArrayUtility.getRowTotal(d2, 1));
		assertEquals(15677, TwoDimRaggedArrayUtility.getRowTotal(d3, 2));
	}

	@Test
	void testGetColumnTotal() {
		assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(d1, 2));
		assertEquals(415.5, TwoDimRaggedArrayUtility.getColumnTotal(d2, 0));
		assertEquals(10799, TwoDimRaggedArrayUtility.getColumnTotal(d3, 1));
	}

	@Test
	void testGetHighestInRow() {
		assertEquals(3, TwoDimRaggedArrayUtility.getHighestInRow(d1, 0));
		assertEquals(248.8, TwoDimRaggedArrayUtility.getHighestInRow(d2, 1));
		assertEquals(4, TwoDimRaggedArrayUtility.getHighestInRow(d3, 3));
	}

	@Test
	void testGetHighestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(d1, 0));
		assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(d2, 1));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(d3, 2));
	}

	@Test
	void testGetLowestInRow() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRow(d1, 0));
		assertEquals(123.1, TwoDimRaggedArrayUtility.getLowestInRow(d2, 1));
		assertEquals(4122, TwoDimRaggedArrayUtility.getLowestInRow(d3, 2));
	}

	@Test
	void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(d1, 0));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(d2, 1));
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(d3, 2));
	}

	@Test
	void testGetHighestInColumn() {
		assertEquals(8, TwoDimRaggedArrayUtility.getHighestInColumn(d1, 2));
		assertEquals(4122, TwoDimRaggedArrayUtility.getHighestInColumn(d3, 0));
		assertEquals(248.8, TwoDimRaggedArrayUtility.getHighestInColumn(d2, 1));
	}

	@Test
	void testGetHighestInColumnIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(d1, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(d2, 0));
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(d3, 1));
	}

	@Test
	void testGetLowestInColumn() {
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumn(d1, 2));
		assertEquals(5.3, TwoDimRaggedArrayUtility.getLowestInColumn(d2, 1));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInColumn(d3, 0));
	}

	@Test
	void testGetLowestInColumnIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(d1, 2));
		assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(d2, 1));
		assertEquals(3, TwoDimRaggedArrayUtility.getLowestInColumnIndex(d3, 0));
	}

	@Test
	void testGetHighestInArray() {
		assertEquals(8, TwoDimRaggedArrayUtility.getHighestInArray(d1));
		assertEquals(248.8, TwoDimRaggedArrayUtility.getHighestInArray(d2));
		assertEquals(8888, TwoDimRaggedArrayUtility.getHighestInArray(d3));
	}

	@Test
	void testGetLowestInArray() {
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(d1));
		assertEquals(5.3, TwoDimRaggedArrayUtility.getLowestInArray(d2));
		assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(d3));
	}

}
