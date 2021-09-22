/**
 * The {@code GameLogic} class manages the logic part of the game.
 * @author Daniele Bae
 *
 */
public class GameLogic {
	
	private RandomAttackGenerator randAttack;
	public static int coloredSquarePlayer = 0;
	public static int coloredSquareComputer = 0;
	public static final int TOTAL_SQUARE = 30;
	public static boolean playerWin = false;
	public static boolean computerWin = false;
	public static int turn = 0;
	
	public GameLogic() {
		randAttack = new RandomAttackGenerator();
	}
	
	/**
	 * Starts the game.
	 */
	public static void startGame() {

		BattleShip battleshipGame = new BattleShip();
	}
	
	public void turns() {
		//System.out.println(turn);
		if (turn % 2 == 0) {
			//player turn
			//System.out.println("PLAYER TURN");
		} else {
			//System.out.println("COMPUTER TURN");
			randAttack.randomAttack();
			PlayerGrid.playerGrid.repaint();
		}
	}
	
	/**
	 * Checks the winner and sends a pop-up message.
	 */
	public static void checkWin() {
		if (coloredSquarePlayer == TOTAL_SQUARE) {
			PopupMessage.infoBox("PLAYER WIN", null);
			playerWin = true;
		}
		
		if (coloredSquareComputer == TOTAL_SQUARE) {
			PopupMessage.infoBox("COMPUTER WIN", null);
			computerWin = true;
		}
		
		if (playerWin || computerWin) {
			PopupMessage.infoBox("END GAME", null);
			System.exit(0);
		}
	}

}
