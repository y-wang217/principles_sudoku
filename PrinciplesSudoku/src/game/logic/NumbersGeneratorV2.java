package game.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import game.logic.numbers.Coord;

/**
 * BEGIN random cell ->select available number (keep track of this in 2d array)
 * ->move to next cell IF no available numbers go to previous cell select
 * different available number
 * 
 * ->repeat
 * 
 * @author yale
 *
 */
public class NumbersGeneratorV2 {
	File file;
	BufferedWriter writer;

	int count = 0;

	private int[][] game_numbers = new int[9][9];

	public Coord start;

	public NumbersGeneratorV2() {
		file = new File("sudoku.txt");
		try {
			writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start = Coord.random();
	}

	private HashMap<Coord, ArrayList<Integer>> availableNumTracker = new HashMap<>();

	public void init(Coord cell) {
		generateNums(start, availableNums(start));
	}

	public void generateNums(Coord cell, ArrayList<Integer> availableNums) {
		count++;
		if (count % 100 == 0)
			printNums();

		// find an available number
		int trialNum = getAvailableNum(availableNums);

		// assign the available number to the cell
		game_numbers[cell.getX()][cell.getY()] = trialNum;

		// stop if finished
		if (cell.equals(start.prev()))
			return;

		// remove this number from the available numbers for this cell
		if (availableNumTracker.containsKey(cell))
			availableNums = availableNumTracker.get(cell);
		availableNums.remove((Integer) trialNum);
		availableNumTracker.put(cell, availableNums);

		availableNums = null;
		System.gc();
		// if no available numbers, go back
		if (trialNum < 0) {

			// delete the tracker entry for this cell
			availableNumTracker.remove(cell);
			// availableNumTracker.remove(cell);

			generateNums(cell.prev(), availableNumTracker.get(cell.prev()));
		} else {
			// generate the number for the next cell
			generateNums(cell.next(), availableNums(cell.next()));
		}
	}

	public int getAvailableNum(ArrayList<Integer> arr) {
		if (arr.size() == 0) {
			return -1;
		}
		int x = count%arr.size();
		if (count % 10 == 0) {
			int max = arr.size() - 1;
			x = (int) (Math.random() * max);
		}
		return arr.get(x);
	}

	public ArrayList<Integer> availableNums(Coord cell) {
		if (availableNumTracker.containsKey(cell))
			return availableNumTracker.get(cell);
		int x = cell.getX();
		int y = cell.getY();
		int[] defaultNums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ArrayList<Integer> result = new ArrayList<>();
		for (int n : defaultNums)
			result.add(n);

		// for the rows, remove the numbers that already exist
		for (int i = x, j = 0; j < 9; j++) {
			int n = game_numbers[i][j];
			if (n > 0)
				// use remove (Object o)
				result.remove((Integer) (n));
		}
		// same for the cols
		for (int i = 0, j = y; i < 9; i++) {
			int n = game_numbers[i][j];
			if (n > 0)
				// use remove (Object o)
				result.remove((Integer) (n));
		}
		// check the grid that the cell is in
		int grid = NumberChecker.gridNum(x, y);

		// helper method checks the numbers in the grid
		// then, it removes the numbers that are taken
		result = gridCheck(grid, result);

		return result;
	}

	// grid check, to make sure the corresponding 3x3 grid ensures available numbers
	private ArrayList<Integer> gridCheck(int grid, ArrayList<Integer> list) {
		int row, col;
		switch (grid) {
		case 0: {
			for (row = 0; row < 3; row++) {
				for (col = 0; col < 3; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		case 1: {
			for (row = 0; row < 3; row++) {
				for (col = 3; col < 6; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		case 2: {
			for (row = 0; row < 3; row++) {
				for (col = 6; col < 9; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		case 3: {
			for (row = 3; row < 6; row++) {
				for (col = 0; col < 3; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		case 4: {
			for (row = 3; row < 6; row++) {
				for (col = 3; col < 6; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		case 5: {
			for (row = 3; row < 6; row++) {
				for (col = 6; col < 9; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		case 6: {
			for (row = 6; row < 9; row++) {
				for (col = 0; col < 3; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		case 7: {
			for (row = 6; row < 9; row++) {
				for (col = 3; col < 6; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		case 8: {
			for (row = 6; row < 9; row++) {
				for (col = 6; col < 9; col++) {
					int n = game_numbers[row][col];
					if (n > 0)
						list.remove((Integer) n);
				}
			}
		}
			;
			break;
		}
		return list;
	}

	public void printNums() {
		System.out.println("//" + count);
		for (int row[] : game_numbers) {
			System.out.print("[");
			for (int num : row) {
				System.out.print(num + ", ");
			}
			System.out.println("]");
		}
	}

	public void printTracker() {
		for (Coord c : availableNumTracker.keySet()) {
			System.out.println("(" + c.getX() + ", " + c.getY() + ") : " + availableNumTracker.get(c));
		}
	}

	public static void main(String[] args) {
		NumbersGeneratorV2 test = new NumbersGeneratorV2();
		test.init(test.start);

		test.printNums();
	}
}
