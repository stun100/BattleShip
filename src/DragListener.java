import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The {@code DragListener} class contains the {@code mouseDragged()} method that manages the MOUSE_DRAGGED event.
 * @author Daniele Bae
 *
 */
public class DragListener extends MouseAdapter {
	
	public void mouseDragged(MouseEvent e) {
			
		if (SwingUtilities.isLeftMouseButton(e)) {
			
			try {
				JPanel gridFrame = (JPanel) e.getComponent().getParent().getParent();

				Ship currentShip = ((Ship) e.getComponent().getParent());

				currentShip.setLocation(gridFrame.getMousePosition());
			} catch (NullPointerException ex) {
				
			}
			
			
        }
		
	}

}