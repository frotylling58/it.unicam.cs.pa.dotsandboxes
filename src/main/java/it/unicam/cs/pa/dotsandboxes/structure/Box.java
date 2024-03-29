package it.unicam.cs.pa.dotsandboxes.structure;

/**
 * @param
 * 
 * 
 * @author Donoval Candolfi - Mattia Incoronato
 */
public class Box {

	// definisce un box formato da 4 line

	private final Line lineTop;
	private final Line lineBottom;
	private final Line lineLeft;
	private final Line lineRight;

	public Box(Line lineTop, Line lineBottom, Line lineLeft, Line lineRight) {

		/// inverto le y di top e bottom
		/// inverto le x di left e right

		lineTop = lineTop.getNormalForm();
		lineBottom = lineBottom.getNormalForm();
		lineLeft = lineLeft.getNormalForm();
		lineRight = lineRight.getNormalForm();

		/// controllo se le linee sono adiacenti

		if (!(lineTop.getDot1().equals(lineLeft.getDot2()) && lineBottom.getDot2().equals(lineLeft.getDot2())
				&& lineTop.getDot2().equals(lineRight.getDot1()) && lineBottom.getDot2().equals(lineRight.getDot2()))) {
			throw new IllegalArgumentException("The lines do not create a box !");
		}

		this.lineTop = lineTop;
		this.lineBottom = lineBottom;
		this.lineLeft = lineLeft;
		this.lineRight = lineRight;
	}

	public Line getLineTop() {
		return lineTop;
	}

	public Line getLineBottom() {
		return lineBottom;
	}

	public Line getLineLeft() {
		return lineLeft;
	}

	public Line getLineRight() {
		return lineRight;
	}

	// Metodo per controllare se due box sono uguali
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Box)) {
			return false;
		}
		Box box = (Box) obj;
		return box.getLineTop().equals(lineTop) && box.getLineBottom().equals(lineBottom)
				&& box.getLineRight().equals(lineRight) && box.getLineLeft().equals(lineLeft);
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public String toString() {
		return String.format("[%s,%s]", "[%s,%s]", "[%s,%s]", "[%s,%s]", lineTop.toString(), lineBottom.toString(),
				lineLeft.toString(), lineRight.toString());

	}

}
