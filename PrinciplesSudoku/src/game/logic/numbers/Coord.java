package game.logic.numbers;

import java.util.Objects;

public class Coord {
	private int x, y;
	
	@Override
	public boolean equals(Object o) {
		if (o == this) { 
            return true; 
        } 
		if (!(o instanceof Coord)) { 
            return false; 
        } 
		Coord c = (Coord) o;
		
		return this.x==c.getX()&&this.y==c.getY();
	}
	@Override
    public int hashCode() {
		return Objects.hash(this.x, this.y);
    }
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coord next() {
		if(this.x==8 & this.y == 8) return new Coord(0,0);
		int nextY = this.y==8?0:this.y+1;
		int nextX = this.y==8?x+1:this.x;
		return new Coord(nextX,nextY);
	}
	public Coord prev() {
		if(this.x==0 & this.y == 0) return new Coord(8,8);
		int nextY = this.y==0?8:this.y-1;
		int nextX = this.y==0?x-1:this.x;
		return new Coord(nextX,nextY);
		
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public static Coord random() {
		int max = 8, min=0;
		int x = (int) (Math.random() * ((max - min) + 1)) + min;
		int y = (int) (Math.random() * ((max - min) + 1)) + min;
		Coord random = new Coord(x, y);
		
		
		return random;
	}
}
