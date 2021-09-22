import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 * The {@code ClickListener} class is used to manage the clicking-event with mouse.
 * @author Daniele Bae
 *
 */
public class ClickListener extends MouseAdapter {
	
	private CheckShipPosition checkShipPosition;
	
	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isRightMouseButton(e)) {

			checkShipPosition = new CheckShipPosition(PlayerGrid.playerPanel);
			
			Ship currentShip = ((Ship) e.getComponent().getParent());
			//System.out.println(currentShip);
			boolean overlap = checkShipPosition.checkOverlapRotation(currentShip.getOriginLocation(), currentShip);
			
			//se orizzontale
			if (currentShip.getRotation()) {
				//se non supera i limiti della griglia
				if (!(currentShip.getY() + currentShip.getWidth() > 500)) {
					//se non sovrappone nessuna nave
					if (!overlap) {
						PlayerGrid.playerPanel.remove(currentShip);
						Ship rotatedShip = rotateShip(currentShip);
						boolean checkBorder = checkShipPosition.checkShipBorderRotation(currentShip.getOriginLocation(), currentShip);
						
						if (checkBorder) {
							PlayerGrid.playerPanel.remove(rotatedShip);
							rotateShip(rotatedShip);
							PlayerGrid.playerPanel.revalidate();
							PlayerGrid.playerPanel.repaint();
										
						} else {
							
							PlayerGrid.playerPanel.revalidate();
							PlayerGrid.playerPanel.repaint();
						}
					} 			
				}
				
			} else {
						
				if (!(currentShip.getX() + currentShip.getHeight() > 500)) {
					if (!overlap) {
						PlayerGrid.playerPanel.remove(currentShip);
						Ship rotatedShip = rotateShip(currentShip);
						boolean checkBorder = checkShipPosition.checkShipBorderRotation(currentShip.getOriginLocation(), currentShip);
						if (checkBorder) {
							PlayerGrid.playerPanel.remove(rotatedShip);
							rotateShip(rotatedShip);
							PlayerGrid.playerPanel.revalidate();
							PlayerGrid.playerPanel.repaint();

							
						} else {
							PlayerGrid.playerPanel.revalidate();
							PlayerGrid.playerPanel.repaint();
						}
					} 
				}
			}

        }			
	}
	
	/**
	 * Rotates the ship based on the original rotation.
	 * @param currentShip selected ship
	 * @return rotated ship
	 */
	private Ship rotateShip(Ship currentShip) {
		
		int ship_x = currentShip.getX();
		int ship_y = currentShip.getY();
		int squareNumber = currentShip.getSquareNumber();
		boolean rotation = currentShip.getRotation();
		int squareSize = currentShip.getSquareSize();
		
		if (!rotation) {
			Ship horizontalShip = new Ship(Ship.HORIZONTAL, squareNumber, squareSize, new Point(ship_x, ship_y));
			horizontalShip.setBounds(ship_x, ship_y, horizontalShip.getWidth(), horizontalShip.getHeight());
			PlayerGrid.playerPanel.add(horizontalShip);
			return horizontalShip;
		} else {
			Ship verticalShip = new Ship(Ship.VERTICAL, squareNumber, squareSize, new Point(ship_x, ship_y));
			verticalShip.setBounds(ship_x, ship_y, verticalShip.getWidth(), verticalShip.getHeight());
			PlayerGrid.playerPanel.add(verticalShip);
			return verticalShip;
		}
	}

}
