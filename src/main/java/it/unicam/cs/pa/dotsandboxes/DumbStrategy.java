package it.unicam.cs.pa.dotsandboxes;
import java.util.Random;

public class DumbStrategy implements Strategy {

	@Override
	public Line suggestLine(IGrid grid) {
		Random r = new Random();
		int x = r.nextInt(grid.getSize());
		int y = r.nextInt(grid.getSize());
		Dot dot1 = new Dot(x,y);
		Dot[] adjacence = getAdjacence(x,y, grid.getSize());
		Dot dot2 = adjacence[r.nextInt(adjacence.length)];
		return new Line(dot1, dot2);
		
		
		
		
	}
	
	private Dot[] getAdjacence(int x, int y, int size) {
		// controllo angoli
		if(x == 0 && y == 0) return new Dot[] {new Dot(1,0), new Dot(0,1)};
		if(x == 0 && y == size) return new Dot[] {new Dot(0,size-1), new Dot(1,size)};
		if(x == size && y== 0) return new Dot[] {new Dot(size-1, 0), new Dot(size, 1)};
		if(x==size && y==size) return new Dot[] {new Dot(size-1, size), new Dot(size, size-1)};
		//controllo lati
		if(y == 0) return new Dot[] {new Dot(x+1,y), new Dot(x-1, y), new Dot(x, y+1)};
		if(y == size) return new Dot[] {new Dot(x+1, y), new Dot(x-1,y), new Dot(x, y-1)};
		if(x == 0) return new Dot[] {new Dot(x+1, y), new Dot(x,y+1), new Dot(x, y-1)};
		if(x == size) return new Dot[] {new Dot(x-1, y), new Dot(x,y+1), new Dot(x, y-1)};
		// altrimenti il punto è all'interno della griglia (no lati, no angoli)
		return new Dot[] {new Dot(x,y-1), new Dot(x,y+1), new Dot(x+1,y), new Dot(x-1,y)};
	}
	
}
