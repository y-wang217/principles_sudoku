package game.logic;

/**
 * 
 * @author yale
 *
 */

public class NumberChecker {
	private NumberMap[] grids = new NumberMap[9];
	private NumberMap[] rows = new NumberMap[9];
	private NumberMap[] cols = new NumberMap[9];
	
	public NumberChecker() {
		for(int i=0; i<9; i++) {
			grids[i] = new NumberMap();
			rows[i] = new NumberMap();
			cols[i] = new NumberMap();
		}
	}
	
	public boolean has(int row, int col, int num) {
		int grid = gridNum(row,col);
		System.out.println("row: " + row + " col: " + col + " grid: " + grid + " num: " + num);
		return rows[row].has(num) || cols[col].has(num) || grids[grid].has(num);
	}
	
	public int gridNum(int row, int col) {
		     if(0<=row && row<=2 && 0<=col && col<=2) return 0;
		else if(0<=row && row<=2 && 3<=col && col<=5) return 1;
		else if(0<=row && row<=2 && 6<=col && col<=8) return 2;
		else if(3<=row && row<=5 && 0<=col && col<=2) return 3;
		else if(3<=row && row<=5 && 3<=col && col<=5) return 4;
		else if(3<=row && row<=5 && 6<=col && col<=8) return 5;
		else if(6<=row && row<=8 && 0<=col && col<=2) return 6;
		else if(6<=row && row<=8 && 3<=col && col<=5) return 7;
		else if(6<=row && row<=8 && 6<=col && col<=8) return 8;
		
		return -1;
	}
	
	public void insert(int row, int col, int num) {
		rows[row].getMap().put(num, true);
		cols[col].getMap().put(num, true);
		grids[gridNum(row, col)].getMap().put(num, true);
	}
	public void print() {
		System.out.println("rows");
		for(int row=0; row<9; row++) {
			rows[row].print();
		}
		System.out.println("");
		System.out.println("cols");
		for(int col=0; col<9; col++) {
			cols[col].print();
		}
		System.out.println("");
		System.out.println("grids");
		for(int grid=0; grid<9; grid++) {
			grids[grid].print();
		}
		System.out.println("");
	}
}
