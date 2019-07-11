package it.unicam.cs.pa.dotsandboxes;

import java.util.Scanner;
import java.util.regex.*;

public class RealPlayer extends AbstractPlayer {

	private Scanner s = new Scanner(System.in);
	public RealPlayer() {
		//super(grid);
	}

	@Override
	public Line drawLine() {
		boolean end = false;
		Line line = null;
		do {
			String cmd = s.nextLine();
			Pattern p = Pattern.compile("\\((\\d+),(\\d+)\\) \\((\\d+),(\\d+)\\)");
			Matcher m = p.matcher(cmd);
			if (m.matches()) {
				end = true;
				int x1 = Integer.parseInt(m.group(1));
				int y1 = Integer.parseInt(m.group(2));
				int x2 = Integer.parseInt(m.group(3));
				int y2 = Integer.parseInt(m.group(4));
				Dot dot1 = new Dot(x1, y1);
				Dot dot2 = new Dot(x2, y2);
				line = new Line(dot1, dot2);
			}else {
				System.out.println("Coordinate non valide, inserisci di nuovo");
			}
		} while (!end);
		return line;
	}

}
