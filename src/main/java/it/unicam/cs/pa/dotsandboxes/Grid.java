package it.unicam.cs.pa.dotsandboxes;


//Creazione griglia 

public class Grid implements IGrid{
	
	
		private Dot[][] grid;
		private int size;
		
		public Grid(int size) {
			this.size = size;
			this.grid = new Dot [size][size];
			
		}
		
		public void insertLine(Line line) throws IllegalArgumentException {
			//if(line.getDot1().getX() >= size || line.getDot1().getY() >= size || line.getDot2().getX() >= size || line.getDot2().getY() >= size)
			//	throw new IllegalArgumentException("The lines has to be between boundaries");
			
			line = line.getNormalForm();
			
			if(checkDot(line.getDot1()) || checkDot(line.getDot1()))
				throw new IllegalArgumentException();

			if(checkPosition(line.getDot1()) || checkPosition(line.getDot2()))	
				throw new IllegalArgumentException("You cant draw a line over a preexisting line");
			
			//grid[line.getDot1().getX()][line.getDot1().getY()] = line.getDot1();
			//grid[line.getDot2().getX()][line.getDot2().getY()] = line.getDot2();
			
			addToGrid(line.getDot1());
			addToGrid(line.getDot2());
		}
		
		private boolean checkDot(Dot dot)
		{
			return dot.getX() >= size || dot.getY() >= size;
		}
		
		private boolean checkPosition(Dot dot)
		{
			return grid[dot.getX()][dot.getY()] != null;
		}
		
		private void addToGrid(Dot dot)
		{
			grid[dot.getX()][dot.getY()] = dot;
		}

		
		public boolean isFinished()
		{
			for(int row = 0; row<grid.length; row++)
				for(int col = 0; col<grid[row].length; col++) 
					if(grid[row][col] == null)
						return false;
					
			return true;
		}
		
		public int getSize() {
			return size;
		}
		public String toString() {
			StringBuffer s = new StringBuffer();
			for(int row = 0; row<size; row++) {
				for(int col = 0; col<size; col++) {
					if(grid[row][col] == null)
						s.append(".");
					else
						s.append("*");
				}
				s.append("\n");
			}
			return s.toString();
		}
  	}

