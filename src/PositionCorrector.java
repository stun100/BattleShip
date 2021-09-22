import java.awt.Point;
/**
 * The {@code PositionCorrector} class is used to correct the position based on the grid-coordinates.
 * @author Daniele Bae
 *
 */
public class PositionCorrector {
	
	
	/**
	 * Returns the corrected position
	 * @param point non-corrected point
	 * @return corrected position
	 */
	public Point correctPosition(Point point) {	
		return new Point(correctDistance(point.x, 50), correctDistance(point.y, 50));
	}
	
	/**
	 * Returns the corrected distance
	 * @param distance from the origin of the grid (0,0)
	 * @param length of the square that compose the grid
	 * @return the corrected distance
	 */
	private int correctDistance(int distance, int length) {
		if ( distance < length) {
			return 0;
		} else if (50 <= distance && distance < 100) {
			return 50;		
		} else if (length*2 <=distance && distance < length*3) {
			return length*2;
		} else if (length*3 <=distance && distance < length*4) {
			return length*3;
		} else if (length*4 <=distance && distance < length*5) {
			return length*4;
		} else if (length*5 <=distance && distance < length*6) {
			return length*5;
		} else if (length*6 <=distance && distance < length*7) {
			return length*6;
		} else if (length*7 <=distance && distance < length*8) {
			return length*7;
		} else if (length*8 <=distance && distance < length*9) {
			return length*8;
		} else {
			return length*9;
		}
	}
	


}
