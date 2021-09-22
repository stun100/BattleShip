import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * The {@code GridClickable} class is same the {@code Grid} class, but every square is clickable.
 * @author Daniele Bae
 *
 */
public class GridClickable extends JPanel {

	/**
	 * 
	 */

	private final int SQUARE_NUMBER = 10;
	private PlayersAttackManager click;	
	public static int turn = 0;
	public static ArrayList<Square> clickableSquareList = new ArrayList<>();
	
	/**
	 * Create an interactive grid.
	 * @param squareSize length of the square 
	 */
	public GridClickable(int squareSize) {

		click = new PlayersAttackManager();
		
		this.setLayout( new GridLayout(SQUARE_NUMBER, SQUARE_NUMBER) );

		for (int y = 0; y < SQUARE_NUMBER; y++) {
			for (int i = 0; i < SQUARE_NUMBER; i++) {
				Square square = new Square(new Color(255, 255, 255), new Color(69, 123, 157), squareSize);
				square.addMouseListener(click);
				clickableSquareList.add(square);
				square.setSquarePosition(new Point(i*50,y*50));
				this.add(square);				
			}
		}


	} 
	
	
	

	
}

