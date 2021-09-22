import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * The {@code PlayersAttackManager} is used to manage the shifts and the attack of both players.
 * @author Daniele Bae
 *
 */
public class PlayersAttackManager extends MouseAdapter{
		
		private GameLogic gameLogic;
		private boolean invisiblePanelOn = true;
		
		public PlayersAttackManager() {
			
			gameLogic = new GameLogic();
			
		}
				
		public void mouseClicked(MouseEvent e) {
			
			//turno giocatore
			try {
				System.out.println("prima");
				System.out.println("invisiblePanelOn " + invisiblePanelOn);
				invisiblePanelOn = false;
				
				Square currentSquare = (Square) e.getComponent();	
				JLayeredPane layer = (JLayeredPane) e.getComponent().getParent().getParent();
				
				JPanel panelWithShip = (JPanel) layer.getComponents()[2];
				System.out.println(currentSquare);
				if (panelWithShip.getComponentAt(ComputerGrid.computerGrid.getMousePosition()) instanceof Ship && !currentSquare.getClicked()) {
					currentSquare.setRectColor(new Color(240, 0, 0, 200));
					currentSquare.setClicked(true);
					ComputerGrid.computerGrid.repaint();
					
					GameLogic.coloredSquarePlayer++;
					
					GameLogic.turn++;
					GameLogic.checkWin();
					if (!invisiblePanelOn) {		
						//turno nemico
						gameLogic.turns();
						GameLogic.turn++;
						GameLogic.checkWin();
					}
					
				} else {
					if (!currentSquare.getClicked()) {
						currentSquare.setRectColor(new Color(128, 128, 128, 200));
						currentSquare.setClicked(true);
						ComputerGrid.computerGrid.repaint();
						GameLogic.turn++;
						GameLogic.checkWin();
						if (!invisiblePanelOn) {		
							//turno nemico
							gameLogic.turns();
							GameLogic.turn++;
							GameLogic.checkWin();
						}
					}
					
				
				}
				
			} catch (Exception ex) {
				System.out.println(ex);
				invisiblePanelOn = true;
			}

			
 
		}
		
	}
