 import java.awt.Point;

import javax.swing.JPanel;

/**
 * The {@code CheckOverlap} class provides a bunch of methods 
 * that checks the positions of the ships.
 * @author Daniele Bae
 *
 */
public class CheckShipPosition {
	
	private JPanel gridFrame;
	
	public CheckShipPosition(JPanel gridFrame) {
		this.gridFrame = gridFrame;
	}
	
	/**
	 * Check if the ship released by the mouse, overlaps another ship or not
	 * @param location point where the ship is released
	 * @param currentShip the selected ship
	 * @return {@code true} if overlaps, otherwise {@code false}
	 */
	public boolean checkOverlapDrag(Point location, Ship currentShip) {
		
		int squareSize = currentShip.getSquareSize();
		int squareNumber = currentShip.getSquareNumber();
		boolean rotation = currentShip.getRotation();
		
		if (rotation) {
			for (int i = 0; i < squareNumber; i++) {
				int checkLocation_X = (i*squareSize) + location.x;
				if (gridFrame.getComponentAt(new Point(checkLocation_X, location.y)) instanceof Ship) {				
					return true;
				} 
			}
			
			return false;

		} else {
			for (int i = 0; i < squareNumber; i++) {
				int checkLocation_Y = (i*squareSize) + location.y;
				if (gridFrame.getComponentAt(new Point(location.x, checkLocation_Y)) instanceof Ship) {				
					return true;		
				} 
			}
			
			return false;
		}

	}
	
	/**
	 * Checks if the ship overlaps another ship after the rotation.
	 * @param location the original location of the ship
	 * @param currentShip the selected ship
	 * @return {@code true} if overlaps, otherwise {@code false}
	 */
	public boolean checkOverlapRotation(Point location, Ship currentShip) {
		
		int squareSize = currentShip.getSquareSize();
		int squareNumber = currentShip.getSquareNumber();
		boolean rotation = currentShip.getRotation();
		//se verticale
		if (!rotation) {
			for (int i = 1; i < squareNumber; i++) {
				int checkLocation_X = (i*squareSize) + location.x;
				if (gridFrame.getComponentAt(new Point(checkLocation_X, location.y)) instanceof Ship) {				
					return true;
				} 
			}
			
			return false;
					
		} else {
			for (int i = 1; i < squareNumber; i++) {
				int checkLocation_Y = (i*squareSize) + location.y;
				if (gridFrame.getComponentAt(new Point(location.x, checkLocation_Y)) instanceof Ship) {				
					return true;		
				} 
			}
			
			return false;
		}
		
	}
	
	/**
	 * Checks if the squares around a ship doesn't contain other ship.
	 * @param location the original location of the ship
	 * @param currentShip the selected ship
	 * @return {@code true} if overlaps, otherwise {@code false}
	 */
	public boolean checkShipBorder(Point location, Ship currentShip) {
		int squareSize = currentShip.getSquareSize();
		int squareNumber = currentShip.getSquareNumber();
		boolean rotation = currentShip.getRotation();
 
		Point newLocation = new Point(location.x - squareSize, location.y - squareSize);
		Point border_bottom = new Point(newLocation.x, location.y + currentShip.getHeight());
		Point border_right = new Point(location.x + currentShip.getWidth(), newLocation.y);

		//se verticale
		if (!rotation) {
			
			for (int i = 0; i <= squareNumber+1; i++) {

				int checkLocation_Y = (i*squareSize) + newLocation.y;
				boolean condition_1 = gridFrame.getComponentAt(new Point(newLocation.x, checkLocation_Y)) instanceof Ship;
				boolean condition_2 = gridFrame.getComponentAt(new Point(border_right.x, checkLocation_Y)) instanceof Ship;

				if (condition_1 || condition_2) {
					return true;
				}
			}		
			
			int checkLocation_X = squareSize + newLocation.x;
			boolean condition_1 = gridFrame.getComponentAt(new Point(checkLocation_X, newLocation.y)) instanceof Ship;
			boolean condition_2 = gridFrame.getComponentAt(new Point(checkLocation_X, border_bottom.y)) instanceof Ship;

			if (condition_1 || condition_2) {
				return true;
			}
					
			return false;
		} else {
			
			for (int i = 0; i <= squareNumber+1; i++) {
				
				int checkLocation_X = (i*squareSize) + newLocation.x;
				boolean condition_1 = gridFrame.getComponentAt(new Point(checkLocation_X, newLocation.y)) instanceof Ship;
				boolean condition_2 = gridFrame.getComponentAt(new Point(checkLocation_X, border_bottom.y)) instanceof Ship;
				
				if (condition_1 || condition_2) {
					
					return true;
				}
			}
			
			int checkLocation_Y = (squareSize) + newLocation.y;
			boolean condition_1 = gridFrame.getComponentAt(new Point(newLocation.x, checkLocation_Y)) instanceof Ship;
			boolean condition_2 = gridFrame.getComponentAt(new Point(border_right.x, checkLocation_Y)) instanceof Ship;

			if (condition_1 || condition_2) {
				return true;
			}
					
			return false;
		}
	}
	
	/**
	 * Check if the squares around a ship doesn't contain other ship after rotation.
	 * @param location the ship original location
	 * @param currentShip the selected ship
	 * @return {@code true} if overlaps, otherwise {@code false}
	 */
	public boolean checkShipBorderRotation(Point location, Ship currentShip) {
		int squareSize = currentShip.getSquareSize();
		int squareNumber = currentShip.getSquareNumber();
		boolean rotation = currentShip.getRotation();
		Point newLocation = new Point(location.x - squareSize, location.y - squareSize);
		Point border_bottom = new Point(newLocation.x, location.y + currentShip.getWidth());
		Point border_right = new Point(location.x + currentShip.getHeight(), newLocation.y);
		//se verticale
		if (!rotation) {
			
			for (int i = 0; i < 3; i++) {
				int checkLocation_Y = (i*squareSize) + newLocation.y;
				boolean condition_1 = gridFrame.getComponentAt(new Point(newLocation.x, checkLocation_Y)) instanceof Ship;
				boolean condition_2 = gridFrame.getComponentAt(new Point(border_right.x, checkLocation_Y)) instanceof Ship;

				if (condition_1 || condition_2) {
					return true;
				}
			}
			
			for (int i = 1; i < squareNumber+1; i++) {
	
				int checkLocation_X = (i*squareSize) + newLocation.x;
				boolean condition_1 = gridFrame.getComponentAt(new Point(checkLocation_X, newLocation.y)) instanceof Ship;
				boolean condition_2 = gridFrame.getComponentAt(new Point(checkLocation_X, border_bottom.y)) instanceof Ship;
				
				if (condition_1 || condition_2) {
					
					return true;
				}
			}
			
			return false;
			
		} else {

			for (int i = 0; i < 3; i++) {
				int checkLocation_X = (i*squareSize) + newLocation.x;
				boolean condition_1 = gridFrame.getComponentAt(new Point(checkLocation_X, newLocation.y)) instanceof Ship;
				boolean condition_2 = gridFrame.getComponentAt(new Point(checkLocation_X, border_bottom.y)) instanceof Ship;

				if (condition_1 || condition_2) {
					return true;
				}
			}
			
			for (int i = 1; i < squareNumber+1; i++) {

				int checkLocation_Y = (i*squareSize) + newLocation.y;
				boolean condition_1 = gridFrame.getComponentAt(new Point(newLocation.x, checkLocation_Y)) instanceof Ship;
				boolean condition_2 = gridFrame.getComponentAt(new Point(border_right.x, checkLocation_Y)) instanceof Ship;

				if (condition_1 || condition_2) {
					return true;
				}
			}
			
			return false;
			

		}
	}
	
	/**
	 * Checks if the ship pops out from the grid.
	 * @param location the ship location
	 * @param currentShip the selected ship
	 * @return {@code true} if pops out, otherwise {@code false}
	 */
	public boolean checkOutOfGrid(Point location, Ship currentShip) {
		
		if (location.x + currentShip.getWidth() > 500 || location.y + currentShip.getHeight() > 500) {
			
			return true;
		}
		
		return false;
	}
	
	

}
