import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GameOfLifeTests {

	@Test
	public void testFirstGeneration() {
		// given
		GameOfLife gol = new GameOfLife();
		gol.addPoint(new Point(-1, 0));
		gol.addPoint(new Point(0, 0));
		gol.addPoint(new Point(1, 0));
		gol.addPoint(new Point(2, 0));
		// when
		gol.evolution();
		// then
		Set<Point> result = new HashSet<Point>();
		result.add(new Point(1, -1));
		result.add(new Point(1, 1));
		result.add(new Point(0, 1));
		result.add(new Point(1, 0));
		result.add(new Point(0, 0));
		result.add(new Point(0, -1));
		assertEquals(gol.getPoints(), result);
	}

	@Test
	public void testSecondGeneration() {
		// given
		GameOfLife gol = new GameOfLife();
		gol.addPoint(new Point(1, -1));
		gol.addPoint(new Point(1, 1));
		gol.addPoint(new Point(0, 1));
		gol.addPoint(new Point(1, 0));
		gol.addPoint(new Point(0, 0));
		gol.addPoint(new Point(0, -1));

		// when
		gol.evolution();
		// then
		Set<Point> result = new HashSet<Point>();
		result.add(new Point(-1, 0));
		result.add(new Point(0, -1));
		result.add(new Point(0, 1));
		result.add(new Point(1, -1));
		result.add(new Point(1, 1));
		result.add(new Point(2, 0));
		assertEquals(gol.getPoints(), result);
	}

}
