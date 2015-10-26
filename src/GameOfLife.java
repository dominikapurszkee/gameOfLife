import java.util.HashSet;
import java.util.Set;

public class GameOfLife {

	private Set<Point> points = new HashSet<Point>();

	public void addPoint(Point p) {
		points.add(p);
	}

	public Set<Point> getPoints() {
		return points;
	}

	public void printPoints() {
		System.out.println(points);
	}

	private int numberOfNeighbors(int x, int y) {
		int neighbors = 0;

		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				if (points.contains(new Point(i, j))) {
					neighbors++;
				}
			}
		}
		if (points.contains(new Point(x, y))) {
			return neighbors - 1;
		} else
			return neighbors;
	}

	private boolean staysAlive(Point p) {
		int neighbors = numberOfNeighbors(p.getX(), p.getY());

		if ((neighbors == 3) || (neighbors == 2)) {
			return true;
		}
		return false;
		// http://pmav.eu/stuff/javascript-game-of-life-v3.1.1/
	}

	private boolean isBorn(Point p) {
		int neighbors = numberOfNeighbors(p.getX(), p.getY());

		if (neighbors == 3)
			return true;

		return false;

	}

	private Set<Point> findDeadCells(Set<Point> pointSet) {
		Set<Point> deadCells = new HashSet<Point>();

		for (Point p : pointSet) {
			if (!staysAlive(p)) {
				deadCells.add(p);
			}
		}

		return deadCells;

	}

	private Set<Point> findNewBornCells(Set<Point> pointSet) {
		Set<Point> newbornCells = new HashSet<Point>();
		for (Point p : pointSet) {
			int x = p.getX();
			int y = p.getY();
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					Point temp = new Point(i, j);
					if (isBorn(temp)) {
						newbornCells.add(temp);
					}
				}
			}

		}

		return newbornCells;
	}

	public Set<Point> evolution() {
		Set<Point> deadSet = findDeadCells(points);
		Set<Point> newbornSet = findNewBornCells(points);
		points.removeAll(deadSet);
		points.addAll(newbornSet);
		return points;

	}

	public static void main(String[] args) {
		Point p1 = new Point(-1, 0);
		Point p2 = new Point(0, 0);
		Point p3 = new Point(1, 0);
		Point p4 = new Point(2, 0);

		GameOfLife gol = new GameOfLife();
		gol.addPoint(p1);
		gol.addPoint(p2);
		gol.addPoint(p3);
		gol.addPoint(p4);
		gol.evolution();
		System.out.println(gol.getPoints());

	}

}
