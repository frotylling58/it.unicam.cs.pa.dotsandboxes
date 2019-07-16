package it.unicam.cs.pa.dotsandboxes;

import java.util.ArrayList;
import java.util.List;

//Creazione griglia 

public class Grid {
	
	
		private Dot[][] grid = null;
		private int size;
		private List <BoxCreatedListener> listeners = new ArrayList <BoxCreatedListener>();
		private List <Box> boxes = new ArrayList <Box>();
		
		public Grid(int size) {
			this.size = size;
			this.grid = new Dot [size][size];
			
		}
		// listener che controlla se vengono create box
		public void addBoxCreatedListener(BoxCreatedListener listener) {
			if(listener == null) return;
			
			this.listeners.add(listener);
		}
		
		private void notifyBoxCreatedListeners() {
			for(BoxCreatedListener l : listeners)
				l.onBoxCreated();
		}
		
		public void insertLine(Line line) throws IllegalArgumentException {
			if(line.getDot1().getX() >= size || line.getDot1().getY() >= size || line.getDot2().getX() >= size || line.getDot2().getY() >= size)
				throw new IllegalArgumentException("The lines has to be between boundaries");
			line = line.getNormalForm();
			
			if(grid[line.getDot1().getX()][line.getDot1().getY()] != null && grid[line.getDot2().getX()][line.getDot2().getY()] != null)
				throw new IllegalArgumentException("You cant draw a line over a preexisting line");
			
			grid[line.getDot1().getX()][line.getDot1().getY()] = line.getDot1();
			grid[line.getDot2().getX()][line.getDot2().getY()] = line.getDot2();
			
			if(line.isVertical()) {
				if(line.getDot1().getX()==0) {
					// TODO implementare questo metodo usando gli stream per il controllo delle box create
				}
			}
			notifyBoxCreatedListeners();
		}
		
		public Dot[][] getGrid() {
			return grid;
		}
		
		public List getBoxes() {
			return this.boxes;
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

