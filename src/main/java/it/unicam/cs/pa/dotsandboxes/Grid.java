package it.unicam.cs.pa.dotsandboxes;

import java.util.ArrayList;

//TODO popolare la griglia, inizializzarla

public class Grid {
	
	
		private Dot[][] grid = null;
		private int size;
		private ArrayList<Line> lineList = null;
		
		public Grid(int size) {
			this.size = size;
			this.grid = new Dot [size][size];
			this.lineList = new ArrayList<Line>();
			
		}
		
		public void insertLine(Line line) {
			if(line.getDot1().getX() >= size || line.getDot1().getY() >= size || line.getDot2().getX() >= size || line.getDot2().getY() >= size)
				throw new IllegalArgumentException("The lines has to be between boundaries");
			line = line.getNormalForm();
			grid[line.getDot1().getX()][line.getDot1().getY()] = line.getDot1();
			grid[line.getDot2().getX()][line.getDot2().getY()] = line.getDot2();
		}
		public Dot[][] getGrid() {
			return grid;
		}
	
  	}

