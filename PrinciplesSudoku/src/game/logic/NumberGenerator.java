package game.logic;

/**
 * This class will generate a set of numbers that fit the Sudoku logic
 * @author yale
 *
 */
public class NumberGenerator {
	private final int min = 1;
	private final int max = 9;
	private int[] first_row = null;
	private NumberMap checker = new NumberMap();
	
	private int[] generateRow() {
		int [] result = new int[9];
		
		for(int i=0; i<9; i++) {
			int num;
			do {
				num = newNum();
			}
			while(checker.getMap().get(num));
			
			result[i] = num;
			checker.getMap().put(num, true);
		}
		return result;
	}
	public int newNum() {
		return (int) (Math.random() * ((max - min) + 1)) + min;
	}
	
	public void printRow(int[] row) {
		System.out.print("[");
		for(int n:row) {
			System.out.print(n+", ");
		}
		System.out.println("]");
	}
	public static void main(String[] args) {
		NumberGenerator test = new NumberGenerator();
		test.printRow(test.generateRow());
	}
}
