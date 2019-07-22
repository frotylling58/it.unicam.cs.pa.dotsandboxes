package it.unicam.cs.pa.dotsandboxes.player;

import it.unicam.cs.pa.dotsandboxes.structure.Dot;
import it.unicam.cs.pa.dotsandboxes.structure.IGrid;
import it.unicam.cs.pa.dotsandboxes.structure.Line;

import java.util.Scanner;
import java.util.regex.*;

/**
 * @param
 *
 */
public class RealPlayer extends AbstractPlayer {

	private Scanner s = new Scanner(System.in);

	public RealPlayer(IGrid grid) {
		super(grid);
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
			} else {
				System.out.println("Invalid coordinates, enter again");
			}
		} while (!end);
		return line;
	}

}
