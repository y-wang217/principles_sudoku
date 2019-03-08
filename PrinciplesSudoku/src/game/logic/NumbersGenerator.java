package game.logic;

/**
 * This class will generate a set of numbers that fit the Sudoku logic
 * 
 * Keeps track of numbers through 27 NumberMap:
 * 
 * 9 grids:
 * UL|UC|UR
 * CL|CC|CR
 * LL|LC|LR
 * 
 * 9 rows, 0-8
 * 9 columns 0-8
 * 
 * 
 * ----> this doesn't work. gotta keep track
 * 
 * @author yale
 *
 */
public class NumbersGenerator {
	private final int min = 1;
	private final int max = 9;
	private int[][] game_numbers = new int[9][9];
	private NumberMap availableNums = new NumberMap();
	private NumberChecker checker = new NumberChecker();
	
//	private int[] generateRow() {
//		int [] result = new int[9];
//		
//		for(int i=0; i<9; i++) {
//			int num;
//			do {
//				num = newNum();
//			}
//			while(checker.has(num));
//			
//			result[i] = num;
//			checker.getMap().put(num, true);
//		}
//		return result;
//	}
	public int newNum() {
		
		return (int) (Math.random() * ((max - min) + 1)) + min;
	}
	
	private int[][] generateNums() {
		int [][] result = new int[9][9];
		
		for(int row=0; row<9; row++) {
			for(int col=0; col<9; col++) {
				int num;
				do {
					
					num = newNum();
				}
				while(checker.has(row,col,num));
				
				result[row][col] = num;
				checker.insert(row, col, num);
				
			}
		}
		this.game_numbers = result;
		return result;
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
	
	public void organize() {
		
	}
	
	public static void main(String[] args) {
		NumbersGenerator test = new NumbersGenerator();
		test.generateNums();
		test.printNums();
	}
}
