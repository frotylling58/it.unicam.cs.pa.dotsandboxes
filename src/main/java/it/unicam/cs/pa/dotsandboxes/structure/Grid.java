package it.unicam.cs.pa.dotsandboxes.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * 
 *
 */
//Creazione griglia 

public class Grid implements IGrid {

	private Dot[][] grid;
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

		line = line.getNormalForm();

		if (checkDot(line.getDot1()) || checkDot(line.getDot1()))
			throw new IllegalArgumentException("The lines has to be between boundaries");

		if (checkPosition(line.getDot1()) || checkPosition(line.getDot2()))
			throw new IllegalArgumentException("You cant draw a line over a preexisting line");

		addToGrid(line.getDot1());
		addToGrid(line.getDot2());

		for (Box b : numberOfBoxCreated(line)) {
			boxes.add(b);
			notifyBoxCreatedListeners();
		}
	}

	private boolean checkDot(Dot dot) {
		return dot.getX() >= size || dot.getY() >= size;
	}

	private boolean checkPosition(Dot dot) {
		return grid[dot.getX()][dot.getY()] != null;
	}

	private void addToGrid(Dot dot) {
		grid[dot.getX()][dot.getY()] = dot;
	}

	public boolean isFinished() {
		for (int row = 0; row < grid.length; row++)
			for (int col = 0; col < grid[row].length; col++)
				if (grid[row][col] == null)
					return false;

		return true;
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

		int dX = line.isVertical() ? 1 : 0;
		int dY = line.isHorizontal() ? 1 : 0;

		ArrayList<Integer> d1_arr = new ArrayList<Integer>();
		d1_arr.add(d1.getX());
		d1_arr.add(d1.getY());
		ArrayList<Integer> d2_arr = new ArrayList<Integer>();
		d2_arr.add(d2.getX());
		d2_arr.add(d2.getY());

		return adjacentLines(line, d1_arr, d2_arr, d1, d2, dX, dY);
	}

	private ArrayList<Box> adjacentLines(Line line, ArrayList<Integer> d1_arr, ArrayList<Integer> d2_arr, Dot d1,
			Dot d2, int dX, int dY) {

		ArrayList<Box> result = new ArrayList<Box>();

		// stream per ottenere le eventuali linee adiacenti

		if (!d1_arr.contains(size) && !d2_arr.contains(size)) {

			Line l1 = getLine(d1, dX, dY);

			Line l2 = getLine(d1, dX, dY);

			Line l3 = getLine(d2, dX, dY);

			if (l1 != null && l2 != null && l3 != null)
				result.add(checkBox(line, l1, l2, l3));

		}
		if (!d1_arr.contains(0) && !d2_arr.contains(0)) {

			Line l1 = getLine(d1, -dX, -dY);

			Line l2 = getLine(d1, -dX, -dY);

			Line l3 = getLine(d2, -dX, -dY);

			if (l1 != null && l2 != null && l3 != null)
				result.add(checkBox(line, l1, l2, l3));

		}

		return result;
	}

	private Line getLine(Dot dot, int dX, int dY) {
		return lines.stream().filter((Line l) -> {
			Dot l_d1 = l.getDot1();
			Dot l_d2 = l.getDot2();
			return l_d1.equals(dot) && l_d2.equals(new Dot(dot.getX() + dX, dot.getY() + dY));
		}).findFirst().orElse(null);
	}

	private Box checkBox(Line line, Line l1, Line l2, Line l3) {

		if (line.isVertical())
			return (new Box(l1, l3, line, l2));
		else
			return (new Box(line, l2, l1, l3));
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
