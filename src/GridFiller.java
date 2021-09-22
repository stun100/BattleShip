import java.awt.Point;
import javax.swing.JPanel;

/**
 * The {@code GridFiller} class provide methods for help the {@code randomizeShipPosition()} method
 * in the {@code RandomShipPositionGenerator} class.
 * @author baeda
 *
 */

public class GridFiller {
	
	private JPanel shipPanel;
	private CheckShipPosition checkShipPosition;
	private Point startPoint;
	static boolean wrongPlacement = false;
	
	public static void main(String[] args) {
		Point p = new Point(0,0);
		for (int i = 0; i < 20; i++) {
			System.out.println(p);
			p.translate(100, 0);
			if (p.x == 500) {
				p.x = 0;
				p.translate(0, 50);
			}
		}
	}
	
	public GridFiller(JPanel shipPanel) {
		this.shipPanel = shipPanel;
		checkShipPosition = new CheckShipPosition(shipPanel);		
	}
	
	/**
	 * Checks all the grid and finds a point where a ship is placeable. 
	 * @param currentShip the selected ship
	 * @return a point where the ship is placeable
	 */
	public Point fillGridWithShip(Ship currentShip) {
		startPoint = new Point(-50,0);

		boolean overlap = true;
		boolean checkBorder = true;
				
		while(overlap || checkBorder) {
			if (startPoint.x >= 450 || startPoint.y >= 450) {
				wrongPlacement = true;
				break;
			}
			startPoint.translate(50, 0);
			if (startPoint.x == 450) {
				startPoint.x = 0;
				startPoint.translate(0, 50);
			}
			if (shipPanel.getComponentAt(startPoint) instanceof Ship) {
				
				continue;
			}
			
			boolean outOfGrid = checkShipPosition.checkOutOfGrid(startPoint, currentShip);
			
			if (!outOfGrid) {
				overlap = checkShipPosition.checkOverlapDrag(startPoint, currentShip);
				checkBorder = checkShipPosition.checkShipBorder(startPoint, currentShip);
			}			
		}	
			
		return startPoint;
	}
	
	

}
