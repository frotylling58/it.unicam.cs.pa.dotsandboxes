package it.unicam.cs.pa.dotsandboxes.structure;

/**
 * @param
 * @author Donoval Candolfi - Mattia Incoronato
 */
public class Line {

	private final Dot dot1;
	private final Dot dot2;

	// Costruttore
	public Line(Dot dot1, Dot dot2) throws IllegalArgumentException {
		if (dot1.equals(dot2))
			throw new IllegalArgumentException("A line can exist only between two different points !");

		if (Dot.distance(dot1, dot2) != 1.0)
			throw new IllegalArgumentException("A line must be formed by two adjacent points !");
		this.dot1 = dot1;
		this.dot2 = dot2;

	}

	public Dot getDot1() {
		return dot1;
	}

	public Dot getDot2() {
		return dot2;
	}

	public Line getNormalForm() {
		if (dot1.getX() < dot2.getX() || dot1.getY() < dot2.getY())
			return new Line(dot2, dot1);
		return this;
	}

	public boolean isVertical() {
		Line line = this.getNormalForm();
		return line.getDot1().getY() < line.getDot2().getY();
	}

	public boolean isHorizontal() {
		return !isVertical();
	}

	@Override
	public String toString() {
		return String.format("[%s,%s]", dot1.toString(), dot2.toString());

	}

	// Controlla se l'elemento è una istanza di Line
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Line)) {
			return false;
		}
		Line line = (Line) obj;
		return this.dot1.equals(line.dot1) && this.dot2.equals(line.dot2)
				|| this.dot1.equals(line.dot2) && this.dot2.equals(line.dot1);

	}

}
