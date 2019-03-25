package game.logic;

/**
 * maps int:boolean pairs
 */
import java.util.HashMap;

public class NumberMap {
	private HashMap<Integer, Boolean> map = new HashMap<>();
	
	public NumberMap() {
		this.reset();
	}
	
	
	public void reset() {
		for(int i=1; i<=9; i++) {
			map.put(i, false);			
		}
		
	}

	public boolean has(int num) {
		return map.get(num);
	}
	public HashMap<Integer, Boolean> getMap() {
		return map;
	}
	public void print() {
		System.out.print("[");
		for(int i=1; i<=9; i++) {
			System.out.print(map.get(i)?i:"#");
		}
		System.out.println("]");
	}
	
	
}
