import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * The {@code ComputerGrid} class creates a grid for the computer.
 * @author Daniele Bae
 *
 */
public class ComputerGrid extends JLayeredPane {

	public static JPanel computerPanel;
	public static JPanel invisiblePanel;
	public static GridClickable computerGrid;
	private RandomShipPositioner randomShipPositioner;
	
	
	public ComputerGrid() {
		
		invisiblePanel = new JPanel();
		//invisiblePanel.setOpaque(false);
		invisiblePanel.setBackground(new Color(50,50,255, 0));
		invisiblePanel.setLayout(null);
		invisiblePanel.setBounds(0, 0, 500, 500);
		
		computerPanel = new JPanel();
		computerPanel.setOpaque(false);
		computerPanel.setLayout(null);
		computerPanel.setBounds(0, 0, 500, 500);
			
		computerGrid = new GridClickable(50);
		computerGrid.setBounds(0, 0, 500, 500);
		
		randomShipPositioner = new RandomShipPositioner(computerPanel);
		randomShipPositioner.randomizeShipPosition();
		while(GridFiller.wrongPlacement) {
			computerPanel.removeAll();
			computerPanel.revalidate();
			computerPanel.repaint();
			randomShipPositioner.randomizeShipPosition();
		}
		computerPanel.revalidate();
		computerPanel.repaint();
		
		this.setBounds(0, 0, 500, 500);
		
		this.add(invisiblePanel, 0);
		this.add(computerGrid,1);
		this.add(computerPanel,2);
		

	}
}
