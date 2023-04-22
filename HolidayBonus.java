/*
 * Class :CMSC203
 * Instructor: Dr. Monshi
 * Description: Takes a file from the computer separated with spaces and a newline and converts it into a 2D ragged array.
 * Using the new array, determines the highest and lowest of each item.
 * The application finds out the amount of holiday bonus for each store, and finds the total of the bonuses.
 * Due: 4/23/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Name: Alex Tseng
 */

public class HolidayBonus extends Object{

	final static int HIGHEST_BONUS = 5000;
	final static int LOWEST_BONUS = 1000;
	final static int ALL_BONUS = 2000;
	
	// default constructor
	public HolidayBonus() {
		
	}
	
	// find bonuses for each store
	public static double[] calculateHolidayBonus(double[][] data) {
		// each of data's row is a store, so 4 row = 4 stores
		double[] bonuses = new double[data.length];
		
		// loop through all possible items
		for (int col = 0; col < TwoDimRaggedArrayUtility.MAX_COLUMN; col++) {
			// focuses on a specific item
			for (int row = 0; row < data.length; row++) {
				// catches IndexOutOfBoundsException
				if (col >= data[row].length) {
					continue;
				}
				
				// add bonuses respectively
				if (data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data, col)) {
					bonuses[row] += HIGHEST_BONUS;
				}
				else if (data[row][col] < 0) {
					continue;
				}
				else if (data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data, col)) {
					bonuses[row] += LOWEST_BONUS;
				}
				else {
					bonuses[row] += ALL_BONUS;
				}
			}
		}
		
		return bonuses;
	}
	
	// uses calculateHolidayBonus to total up the bonuses
	public static double calculateTotalHolidayBonus(double[][] data) {
		// counter
		double total = 0;
		
		// store a temporary array
		double[] temp = calculateHolidayBonus(data);

		// add up all bonuses in temp
		for (int i = 0; i < temp.length; i++) {
			total += temp[i];
		}
		
		return total;
	}
}
