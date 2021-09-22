import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
/**
 * The {@code Battleship} class is used to hold all the components which serve to compose the game, 
 * @author Daniele Bae
 *
 */
public class BattleShip {
	
	public static JFrame mainFrame;
	
	public BattleShip() {
		
		//frame for grids and button. Contains all the components
		mainFrame = new JFrame();
		
		//main menu
		JLabel titleLabel = new JLabel("BATTLESHIP");
		titleLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		titleLabel.setBounds(490, 200,300,45);
		
		JPanel startMenu = new JPanel();
		startMenu.setLayout(null);
		startMenu.setBounds(0, 0, 1280, 720);
		
		JButton goToGameButton = new JButton("Start Game");
		goToGameButton.setBounds(510, 360, 250, 150);
		
		startMenu.add(goToGameButton);
		startMenu.add(titleLabel);	
		
		//Labels for players names and rules
		JLabel playerLabel = new JLabel("PLAYER");
		playerLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		playerLabel.setBounds(200,100,200,45);
		JLabel computerLabel = new JLabel("COMPUTER");
		computerLabel.setFont(new Font("Serif", Font.PLAIN, 50));
		computerLabel.setBounds(820,100,300,45);
		JLabel helpLabel = new JLabel("<html>Help: "
				+ "<br/>a) Drag and release with left mouse click for move the ships"
				+ "<br/>b) Click with right mouse click for rotate the ships"
				+ "<br/>c) Random button will generate a random position for the ships"
				+ "</html>");
		helpLabel.setFont(new Font("Serif", Font.PLAIN, 16));
		helpLabel.setBounds(20,0,600,90);
		
		//Set visible because they are behind the main-menu
		playerLabel.setVisible(false);
		computerLabel.setVisible(false);
		helpLabel.setVisible(false);
		

		//grid and buttons
		JLayeredPane playerGrid = new PlayerGrid();
		JLayeredPane computerGrid = new ComputerGrid();
		
		JButton button1 = new JButton("Random");
		button1.setBounds(580, 340, 100,40);
		
		//when clicked makes a random position for the ships
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomShipPositioner randomShipPositioner = new RandomShipPositioner(PlayerGrid.playerPanel);
				PlayerGrid.playerPanel.removeAll();
				PlayerGrid.playerPanel.revalidate();
				PlayerGrid.playerPanel.repaint();
				
				randomShipPositioner.randomizeShipPosition();

				while(GridFiller.wrongPlacement) {
					PlayerGrid.playerPanel.removeAll();
					PlayerGrid.playerPanel.revalidate();
					PlayerGrid.playerPanel.repaint();
					randomShipPositioner.randomizeShipPosition();
					
				}
				
			}
		});	
		
		
		JButton button2 = new JButton("Start Game");
		button2.setBounds(580, 200, 100,40);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("repaint");
				PlayerGrid.playerPanel.setVisible(false);
				ComputerGrid.invisiblePanel.setVisible(false);
				button1.setVisible(false);
				button2.setVisible(false);
				helpLabel.setVisible(false);
				mainFrame.repaint();
				
			}
		});	
		
		
		goToGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerLabel.setVisible(true);
				computerLabel.setVisible(true);
				helpLabel.setVisible(true);
				button1.setVisible(true);
				button2.setVisible(true);
				startMenu.setVisible(false);
				goToGameButton.setVisible(false);
			}
		});
		
		button1.setVisible(false);
		button2.setVisible(false);
		
		mainFrame.add(helpLabel);
		mainFrame.add(playerLabel);
		mainFrame.add(computerLabel);
		
		mainFrame.add(startMenu);
		
		mainFrame.add(button1);
		mainFrame.add(button2);
		
		playerGrid.setBounds(50,150,500,500);
		mainFrame.add(playerGrid);
		
		computerGrid.setBounds(710, 150, 500, 500);
		mainFrame.add(computerGrid);

		
		mainFrame.setLayout(null);
		mainFrame.setTitle("Battaglia Navale by Daniele Bae, Kosmin Ablay");
		mainFrame.setVisible(true);
		mainFrame.setSize(1280, 720);
		mainFrame.setResizable(false);
		
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
}
