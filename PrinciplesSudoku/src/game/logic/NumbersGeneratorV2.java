package game.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import game.logic.numbers.Coord;

/**
 * BEGIN
 * random cell
 * ->select available number (keep track of this in 2d array)
 * ->move to next cell
 * IF
 * 	no available numbers
 *  go to previous cell 
 *  select different available number
 *  
 * ->repeat
 * 
 * @author yale
 *
 */
public class NumbersGeneratorV2 {

	private int[][] game_numbers = new int[9][9];
	
	public Coord start = Coord.random();
	
	
	public void init(Coord cell) {
		
	}
	
	public ArrayList<Integer> availableNums(Coord cell) {
		int x = cell.getX();
		int y = cell.getY();
		int[] defaultNums = {1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> result = new ArrayList<>();
		for(int n:defaultNums) result.add(n);
		
		for(int i=x, j=0; j<9; j++) {
			int n = game_numbers[i][j];
			if(n > 0) result.remove(n-1);
		}
		for(int i=0, j=y; i<9; j++) {
			int n = game_numbers[i][j];
			if(n > 0) result.remove(n-1);
		}
		int grid = NumberChecker.gridNum(x, y);
		result = gridCheck(grid,result);
		
		return result;
	}
	
	private ArrayList<Integer> gridCheck(int grid, ArrayList<Integer> list) {
		ArrayList<Integer> copy = list;
		switch (grid) {
			case 1 : ;
		}
		return copy;
	}
	
	public void printNums() {
		for(int row[]:game_numbers) {
			System.out.print("[");
			for(int num: row) {
				System.out.print(num+", ");
			}
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		NumbersGeneratorV2 test = new NumbersGeneratorV2();
		test.init(test.start);
	}
}
