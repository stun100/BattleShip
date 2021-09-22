import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The {@code Square} class is used to represent a square.
 * @author Daniele Bae
 *
 */

public class Square extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		
		Box box = Box.createVerticalBox();
		//frame.add(new Square(Color.BLUE, Color.red, 50));
		box.add(new Square(Color.BLUE, Color.red, 50));
		frame.add(box);
	 	
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	private Color rectColor;
	private Color borderColor;
	private int length;
	private boolean clicked = false;
	private Point squarePosition;
	
	
	/**
	 * Create a square
	 * @param rectColor color of the square
	 * @param borderColor color of the border of the square
	 * @param length length of the square
	 */
	public Square(Color rectColor, Color borderColor, int length) {
		this.rectColor = rectColor;
		this.borderColor = borderColor;
		this.length = length;

	}
	
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		g.setColor(rectColor);
		g.fillRect(0, 0, length-1, length-1);
		
		g.setColor(borderColor);
		g.drawRect(0, 0, length-1, length-1);
	}

	/**
	 * Returns the color of the square
	 * @return the color of the square
	 */
	public Color getRectColor() {
		return rectColor;
	}

	/**
	 * Sets the color of the square
	 * @param rectColor color of the square
	 */
	public void setRectColor(Color rectColor) {
		this.rectColor = rectColor;
	}

	/**
	 * Returns the color of the border of the square
	 * @return the color of the border of the square
	 */
	public Color getBorderColor() {
		return borderColor;
	}

	/**
	 * Sets the color of the border of the square
	 * @param borderColor color of the border of the square
	 */
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	/**
	 * Returns if a square is clicked {@code true} or if not {@code false}
	 * @return if is clicked {@code true} otherwise {@code false}
	 */
	public boolean getClicked() {
		return clicked;
	}
	
	/**
	 * Sets {@code true} if is clicked, otherwise {@code false}
	 * @param clicked {@code true} if is clicked, otherwise {@code false}
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	/**
	 * Sets the position of the square
	 * @param squarePosition position of the square
	 */
	public void setSquarePosition(Point squarePosition) {
		this.squarePosition = squarePosition;
	}
	
	/**
	 * Returns the position of the square
	 * @return the position of the square
	 */
	public Point getSquarePosition() {
		return squarePosition;
	}
	
	public String toString() {
		return "clicked" + this.clicked;
		
	}
		
}
