import java.awt.Color;
import java.awt.Point;
import java.util.Random;


/**
 * The {@code RandomAttackGenerator} class is used to generate a choose a random position in the players grid. 
 * @author Daniele Bae
 *
 */
public class RandomAttackGenerator {
	
	private Random rand;

	public RandomAttackGenerator(){
		rand = new Random();
	}
	
	/**
	 * Chooses a random square from the grid (the square are saved in an ArrayList)
	 */
	public void randomAttack() {
		
		int max = Grid.squareList.size() - 1;
		int min = 0;
		
		int randomSquare = rand.nextInt((max - min) + 1) + min;
		
		Square currentSquare = Grid.squareList.get(randomSquare);
		
		Grid.squareList.remove(currentSquare);

		colorSquare(currentSquare.getSquarePosition(), currentSquare);
	}
	
	/**
	 * Colors the square that is chosen by {@code randomAttack()}.
	 * If in the chosen position there is already a ship, is colored red, otherwise gray.
	 * @param squarePosition is the position of the square
	 * @param currentSquare is the chosen square
	 */
	
	private void colorSquare(Point squarePosition, Square currentSquare) {
		if (PlayerGrid.playerPanel.getComponentAt(squarePosition) instanceof Ship) {
			
			currentSquare.setRectColor(new Color(240, 0, 0, 200));
			currentSquare.setClicked(true);
			PlayerGrid.playerGrid.repaint();
			GameLogic.coloredSquareComputer++;

		} else {
			
			currentSquare.setRectColor(new Color(128, 128, 128, 200));
			currentSquare.setClicked(true);
			PlayerGrid.playerGrid.repaint();
			
		}
	}
	
	
}
