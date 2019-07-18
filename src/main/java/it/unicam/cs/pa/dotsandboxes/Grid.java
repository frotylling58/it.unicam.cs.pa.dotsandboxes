package it.unicam.cs.pa.dotsandboxes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//Creazione griglia 

public class Grid {

	private Dot[][] grid = null;
	private int size;
	private List<BoxCreatedListener> listeners = new ArrayList<BoxCreatedListener>();
	private List<Box> boxes = new ArrayList<Box>();
	private List<Line> lines = new ArrayList<Line>();

	public Grid(int size) {
		this.size = size;
		this.grid = new Dot[size][size];

	}

	// listener che controlla se vengono create box
	public void addBoxCreatedListener(BoxCreatedListener listener) {
		if (listener == null)
			return;

		this.listeners.add(listener);
	}

	private void notifyBoxCreatedListeners() {
		for (BoxCreatedListener l : listeners)
			l.onBoxCreated();
	}

	public void insertLine(Line line) throws IllegalArgumentException {
		if (line.getDot1().getX() >= size || line.getDot1().getY() >= size || line.getDot2().getX() >= size
				|| line.getDot2().getY() >= size)
			throw new IllegalArgumentException("The lines has to be between boundaries");
		line = line.getNormalForm();

		if (grid[line.getDot1().getX()][line.getDot1().getY()] != null
				&& grid[line.getDot2().getX()][line.getDot2().getY()] != null)
			throw new IllegalArgumentException("You cant draw a line over a preexisting line");

		grid[line.getDot1().getX()][line.getDot1().getY()] = line.getDot1();
		grid[line.getDot2().getX()][line.getDot2().getY()] = line.getDot2();
		lines.add(line);

		for (Box b : numberOfBoxCreated(line)) {
			boxes.add(b);
			notifyBoxCreatedListeners();
		}

	}

	public Dot[][] getGrid() {
		return grid;
	}

	public List<Box> getBoxes() {
		return this.boxes;
	}

	public int getSize() {
		return size;
	}

	private List<Box> numberOfBoxCreated(Line line) {
		Dot d1 = line.getDot1();
		Dot d2 = line.getDot2();
		ArrayList<Box> result = new ArrayList<Box>();
		int dX = line.isVertical() ? 1 : 0;
		int dY = line.isHorizontal() ? 1 : 0;

		ArrayList<Integer> d1_arr = new ArrayList<Integer>();
		d1_arr.add(d1.getX());
		d1_arr.add(d1.getY());
		ArrayList<Integer> d2_arr = new ArrayList<Integer>();
		d2_arr.add(d2.getX());
		d2_arr.add(d2.getY());

		// stream per ottenere le eventuali linee adiacenti

		if (!d1_arr.contains(size) && !d2_arr.contains(size)) {
			Line l1 = lines.stream().filter((Line l) -> {
				Dot l_d1 = l.getDot1();
				Dot l_d2 = l.getDot2();
				return l_d1.equals(d1) && l_d2.equals(new Dot(d1.getX() + dX, d1.getY() + dY));
			}).findFirst().orElse(null);

			Line l2 = lines.stream().filter((Line l) -> {
				Dot l_d1 = l.getDot1();
				Dot l_d2 = l.getDot2();
				return l_d1.equals(new Dot(d1.getX() + dX, d1.getY() + dY))
						&& l_d2.equals(new Dot(d2.getX() + dX, d2.getY() + dY));
			}).findFirst().orElse(null);

			Line l3 = lines.stream().filter((Line l) -> {
				Dot l_d1 = l.getDot1();
				Dot l_d2 = l.getDot2();
				return l_d1.equals(d2) && l_d2.equals(new Dot(d2.getX() + dX, d2.getY() + dY));
			}).findFirst().orElse(null);

			if (l1 != null && l2 != null && l3 != null)
				if (line.isVertical())
					result.add(new Box(l1, l3, line, l2));
				else
					result.add(new Box(line, l2, l1, l3));

		}
		if (!d1_arr.contains(0) && !d2_arr.contains(0)) {
			Line l1 = lines.stream().filter((Line l) -> {
				Dot l_d1 = l.getDot1();
				Dot l_d2 = l.getDot2();
				return l_d2.equals(d1) && l_d1.equals(new Dot(d1.getX() - dX, d1.getY() - dY));}).findFirst().orElse(null);
			
			Line l2 = lines.stream().filter((Line l) -> {
				Dot l_d1 = l.getDot1();
				Dot l_d2 = l.getDot2();
					return	l_d2.equals(new Dot(d1.getX() - dX, d1.getY() - dY))
								&& l_d1.equals(new Dot(d2.getX() - dX, d2.getY() - dY));}).findFirst().orElse(null);
			
			Line l3 = lines.stream().filter((Line l) -> {
				Dot l_d1 = l.getDot1();
				Dot l_d2 = l.getDot2();
					return l_d2.equals(d2) && l_d1.equals(new Dot(d2.getX() - dX, d2.getY() - dY));}).findFirst().orElse(null);

			if (l1 != null && l2 != null && l3 != null)
				if (line.isVertical())
					result.add(new Box(l1, l3, line, l2));
				else
					result.add(new Box(line, l2, l1, l3));
				
		}

		return result;
	}
	

	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (grid[row][col] == null)
					s.append(".");
				else
					s.append("*");
			}
			s.append("\n");
		}
		return s.toString();
	}
}

