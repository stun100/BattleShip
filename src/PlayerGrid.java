import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * The {@code ComputerGrid} class creates a grid for the player.
 * @author Daniele Bae
 *
 */
public class PlayerGrid extends JLayeredPane {
	
	/**
	 * 
	 */

	public static JPanel playerPanel;
	private RandomShipPositioner randomShipPositioner;
	public static Grid playerGrid;
	
	public PlayerGrid() {
		
		playerPanel = new JPanel();
		playerPanel.setOpaque(false);
		playerPanel.setLayout(null);
		playerPanel.setBounds(0, 0, 500, 500);

		randomShipPositioner = new RandomShipPositioner(playerPanel);
		
		playerGrid = new Grid(50);
		
		playerGrid.setBounds(0, 0, 500, 500);

		randomShipPositioner.randomizeShipPosition();
		
		while(GridFiller.wrongPlacement) {
			playerPanel.removeAll();
			playerPanel.revalidate();
			playerPanel.repaint();
			randomShipPositioner.randomizeShipPosition();
		}
		playerPanel.revalidate();
		playerPanel.repaint();
		this.setBounds(0, 0, 500, 500);
		
		this.add(playerPanel,1);
		this.add(playerGrid,2);
		

	}
	

}
