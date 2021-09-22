import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The {@code ReleaseListener} class is used to manage the release-event with mouse.
 * @author Daniele Bae
 *
 */
public class ReleaseListener extends MouseAdapter{
		
	private PositionCorrector positionCorrector;
	private CheckShipPosition checkShipPosition;
		
	public void mouseReleased(MouseEvent e){
			
		positionCorrector = new PositionCorrector();
	

				
		try {
			
			if (SwingUtilities.isLeftMouseButton(e)) {
				JPanel gridFrame = (JPanel) e.getComponent().getParent().getParent();

				checkShipPosition = new CheckShipPosition(gridFrame);
				
				Ship currentShip = ((Ship) e.getComponent().getParent());
				//System.out.println("releasedreleasedreleased" + currentShip + "|" + currentShip.getRotation());
				//posizione iniziale della nave
				Point initialShipLocation = currentShip.getOriginLocation();
				Point currentPt = gridFrame.getMousePosition();
				Point finalLocation = new Point(positionCorrector.correctPosition(currentPt));
				
				//controlla se nel punto "finalLocation" c'è la componente Ship
				//se la lunghezza della nave sfora il limite della griglia nelle assi x or y
				if (checkShipPosition.checkOutOfGrid(finalLocation, currentShip)) {
					
					currentShip.setLocation(initialShipLocation);
					
				} else {
					
					boolean overlap = checkShipPosition.checkOverlapDrag(finalLocation, currentShip);
					
					if (overlap) {
						currentShip.setLocation(initialShipLocation);
					} else {
						currentShip.setLocation(finalLocation);
						boolean borderCheck = checkShipPosition.checkShipBorder(finalLocation, currentShip);
						
						if (borderCheck) {
							currentShip.setLocation(initialShipLocation);
						} else {
							currentShip.setOriginLocation(finalLocation);
						}							
						
					}
					
						
				}
				
			}

		} catch (Exception ex) {

			Ship currentShip = ((Ship) e.getComponent().getParent());
			Point shipLocation = currentShip.getOriginLocation();
			currentShip.setLocation(shipLocation);
		}
				
				
				
	}
					
		
}
	


