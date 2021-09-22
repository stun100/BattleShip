import java.awt.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JPanel;

/**
 * The {@code RandomShipPositionGenerator} is used to place randomly the ships in a panel.
 * @author Daniele Bae
 *
 */
public class RandomShipPositioner {
	
	private CheckShipPosition checkShipPosition;
	private Random rand;
	private PositionCorrector positionCorrector;
	private GridFiller gridFiller;
	private JPanel shipPanel;
	private ArrayList<Integer> shipSizes= new ArrayList<Integer>(
		      Arrays.asList(2,2,2,3,3,3,3,3,4,5));
	
	private int randomSize;
	private Point randomPoint;
	//private int randomRotation;
	private boolean randomRotation;
	private Ship randomShip;
	
	/**
	 * Create a random position generator for the ships.
	 * @param shipPanel panel that contains the ships
	 */
	public RandomShipPositioner(JPanel shipPanel) {
		this.shipPanel = shipPanel;
		rand = new Random();
		checkShipPosition = new CheckShipPosition(shipPanel);
		positionCorrector = new PositionCorrector();
		gridFiller = new GridFiller(shipPanel);
		
	}
	
	/**
	 * Place randomly the ships in the panel. Sometimes the nested while loops forever: 
	 * for avoid this problem is used the {@code autofill()} method of the {@code Autofill} class.
	 */
	public void randomizeShipPosition() {
		
		while (shipPanel.getComponents().length < 10) {
			GridFiller.wrongPlacement = false;
			randomSize = randomSize();
			boolean overlap = true;
			boolean checkBorder = true;
			
			
			while(overlap || checkBorder) {
				
				randomPoint = randomPoint();
				randomRotation = randomRotation();

				randomShip = new Ship(randomRotation, randomSize, 50, randomPoint);

				
				if (randomRotation == true) {
					//se la nave va fuori la griglia orizzontalmente
					if (randomPoint.x + randomShip.getWidth() > 500) {
						randomPoint = new Point(500-randomShip.getWidth(), randomPoint.y);
					}
				} else {
					//se la nave va fuori la griglia verticalmente
					if (randomPoint.y + randomShip.getHeight() > 500) {
						randomPoint = new Point(randomPoint.x, 500-randomShip.getHeight());
					}
				}
				
				//bisogna reimpostare la posizione della nave perche viene modificata se entra nell'if soprastante
				randomShip.setOriginLocation(randomPoint);
				
				checkBorder = checkShipPosition.checkShipBorder(randomPoint, randomShip);

			
				
				if (overlap || checkBorder) {

					randomPoint = gridFiller.fillGridWithShip(randomShip);
					randomShip.setOriginLocation(randomPoint);		
					//System.out.println("fill" + randomShip);
					break;
				}

			}
			
			if (GridFiller.wrongPlacement) {
				break;
			}
			
			//System.out.println("true" + randomShip);
			randomShip.setBounds(randomPoint.x, randomPoint.y, randomShip.getWidth(), randomShip.getHeight());
			
			shipPanel.add(randomShip);
		}
		
		shipSizes= new ArrayList<Integer>(
			      Arrays.asList(2,2,2,3,3,3,3,3,4,5));
	    
	}
	
	
	
	/**
	 * Returns a randomly generated point.
	 * @return a point
	 */
	public Point randomPoint() {
		int max = 450;
		int min = 0;
		int random_X = rand.nextInt((max - min) + 1) + min;
	    int random_Y = rand.nextInt((max - min) + 1) + min;

	    return new Point(positionCorrector.correctPosition(new Point(random_X, random_Y)));
	}
	
	/**
	 * Returns  randomly generated size.
	 * @return a size
	 */
	public int randomSize() {
		int max = shipSizes.size()-1;
	//	System.out.println("size" + shipSizes.size());
		int min = 0;
		int randomSizeIndex = rand.nextInt((max - min) + 1) + min;
		int randomSize = shipSizes.get(randomSizeIndex);
		shipSizes.remove(randomSizeIndex);
		return randomSize;
		
	}
	
	/**
	 * Returns a random rotation (1 = vertical = false or 0 = horizontal = true)
	 * @return false = vertical or true = horizontal
	 */
	public boolean randomRotation() {
		int max = 1;
		int min = 0;
		
		int zeroOrOne = rand.nextInt((max - min) + 1) + min;
		
		if (zeroOrOne == 1) {
			return Ship.VERTICAL;
		} else {
			return Ship.HORIZONTAL;
		}
		
	}

}
