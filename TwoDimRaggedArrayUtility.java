import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility extends Object{
	public static final int MAX_ROW = 10;
	public static final int MAX_COLUMN = 10;
	
	// default constructor
	public TwoDimRaggedArrayUtility() {
		
	}
	
	// takes a file and converts it into a ragged array
	public static double[][] readFile(File file) throws FileNotFoundException {
		// counters
		int rowCount = 0;
		int colCount = 0;
		
		Scanner inputFile = new Scanner(file);
		
		// save file data into temp as a text
		String[][] temp = new String[MAX_ROW][MAX_COLUMN];
		
		while (inputFile.hasNext()) {
			String[] line = inputFile.nextLine().split(" ");
			
			for (int col = 0; col < line.length; col++) {
				temp[rowCount][col] = line[col];
			}
			
			rowCount++;
		}
		
		// create new array
		double[][] array = new double[rowCount][];
		
		inputFile = new Scanner(file);
		
		// set up array size ONLY
		int row = 0;
		while (inputFile.hasNext()) {
			String[] line = inputFile.nextLine().split(" ");
			
			array[row] = new double[line.length];
			row++;
		}
		
		// transfer data from temp to array
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Double.parseDouble(temp[i][j]);
			}
		}
		
		inputFile.close();
		return array;
	}
	
	// writes data onto outputFile
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException{
		PrintWriter outFile = new PrintWriter(outputFile); // this needs to be modified to fit the code
		
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				outFile.print(data[row][col] + " ");
			}
			outFile.println();
		}
		
		outFile.close();
	}
	
	// get total of everything in array
	public static double getTotal(double[][] data) {
		double total = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		
		return Math.round(total * 100.0) / 100.0;
	}

	// get average of everything in array
	public static double getAverage(double[][] data) {
		double total = 0;
		double count = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
				count++;
			}
		}

		return Math.round((total/count) * 100.0) / 100.0;
	}

	// get total of row elements
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		for (int col = 0; col < data[row].length; col++) {
			total += data[row][col];
		}
		
		return Math.round(total * 100.0) / 100.0;
	}
	
	// get total of column elements, ignores empty
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		for (int row = 0; row < data.length; row++) {
			if (col >= data[row].length) {
					continue;
			}
			total += data[row][col];
		}
		
		return total;
	}
	
	// get highest value in row elements
	public static double getHighestInRow(double[][] data, int row) {
		double max = data[row][0];
		for (int col = 0; col < data[row].length; col++) {
			if (max < data[row][col]) {
				max = data[row][col];
			}
		}
		
		return max;
	}

	// get index of highest value in row elements
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max = data[row][0];
		int index = 0;
		for (int col = 0; col < data[row].length; col++) {
			if (max < data[row][col]) {
				max = data[row][col];
				index = col;
			}
		}
		
		return index;
	}

	// get lowest value in row elements
	public static double getLowestInRow(double[][] data, int row) {
		double min = data[row][0];
		for (int col = 0; col < data[row].length; col++) {
			if (min > data[row][col]) {
				min = data[row][col];
			}
		}
		
		return min;
	}
	
	// get index of lowest value in row elements
	public static int getLowestInRowIndex(double[][] data, int row) {
		double min = data[row][0];
		int index = 0;
		for (int col = 0; col < data[row].length; col++) {
			if (min > data[row][col]) {
				min = data[row][col];
				index = col;
			}
		}
		
		return index;
	}

	// get highest in column elements
	public static double getHighestInColumn(double[][] data, int col) {
		double max = 0;
		for (int row = 0; row < data.length; row++) {
			if (col >= data[row].length) {
		        continue;
			}
			if (max < data[row][col]) {
				max = data[row][col];
			}
		}
		
		return max;
	}
	
	// get index of highest value in column elements
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double max = 0;
		int index = 0;
		for (int row = 0; row < data.length; row++) {
			if (col >= data[row].length) {
		        continue;
			}
			if (max < data[row][col]) {
				max = data[row][col];
				index = row;
			}
		}
		
		return index;
	}
	
	// get lowest in column elements
	public static double getLowestInColumn(double[][] data, int col) {
		double min = 100000;
		for (int row = 0; row < data.length; row++) {
			if (col >= data[row].length) {
				continue;
			}
			if (min > data[row][col]) {
				min = data[row][col];
			}
		}
		
		return min;
	}
	
	// get index of lowest value in column elements
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double min = 100000;
		int index = 0;
		for (int row = 0; row < data.length; row++) {
			if (col >= data[row].length)
				continue;
			if (min > data[row][col]) {
				min = data[row][col];
				index = row;
			}
		}
		
		return index;
	}

	// get highest in entire array
	public static double getHighestInArray(double[][] data) {
		double max = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (max < data[row][col]) {
					max = data[row][col];
				}
			}
		}
		
		return max;
	}

	// get lowest in entire array
	public static double getLowestInArray(double[][] data) {
		double min = data[0][0];
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (min > data[row][col]) {
					min = data[row][col];
				}
			}
		}
		
		return min;
	}
}
