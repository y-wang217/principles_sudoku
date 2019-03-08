package game.logic;

import java.util.HashMap;

public class NumberMap {
	private HashMap<Integer, Boolean> map = new HashMap<>();
	
	public NumberMap() {
		super();
		this.reset();
	}
	
	
	public void reset() {
		for(int i=1; i<=9; i++) {
			map.put(i, false);			
		}
		
	}


	public HashMap<Integer, Boolean> getMap() {
		return map;
	}

	
	
}
