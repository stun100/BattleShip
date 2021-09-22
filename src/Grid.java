import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * The {@code Grid} class is used to represent a grid using the {@code Square} class.
 * @author Daniele Bae
 *
 */

public class Grid extends JPanel {

	/**
	 * 
	 */

	private final int SQUARE_NUMBER = 10;
	public static ArrayList<Square> squareList = new ArrayList<>();

	/**
	 * Creates a grid.
	 * @param squareSize is the length of the square
	 */
	public Grid(int squareSize) {
		
		this.setLayout( new GridLayout(SQUARE_NUMBER, SQUARE_NUMBER) );
		for (int y = 0; y < SQUARE_NUMBER; y++) {
			for (int i = 0; i < SQUARE_NUMBER; i++) {
				Square square = new Square(new Color(255, 255, 255), new Color(69, 123, 157), squareSize);
				squareList.add(square);
				square.setSquarePosition(new Point(i*50, y*50));
				this.add(square);
			}
		}

	}
	
}
