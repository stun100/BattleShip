import java.awt.Color;
import java.awt.Point;
import javax.swing.Box;

/**
 * The {@code Ship} class is used to represent a Ship using the {@code Box} class and the {@code Square} class.
 * A ship is made of n-squares.
 * @author Daniele Bae
 *
 */

public class Ship extends Box {
	

	/*public static void main(String[] args) {
		ClickListener c = new ClickListener();
		JFrame f = new JFrame();
		f.getContentPane().setBackground(Color.BLACK);
		Ship v = new Ship(Ship.HORIZONTAL, 5, 40, new Point(100,50));
		Ship v2 = new Ship(Ship.VERTICAL, 2, 20, new Point(0,0));
		Ship v3 = new Ship(Ship.VERTICAL, 6, 60, new Point(200,200));
		v.setBounds(100, 50, v.getWidth(), v.getHeight());
		v2.setBounds(0, 0, v2.getWidth(), v2.getHeight());
		v3.setBounds(200, 200, v3.getWidth(), v3.getHeight());

		//System.out.println(v.getWidth() + "|" + v.getHeight());

		//f.add(v2);
		f.add(v3);
		//f.remove(v3);
		//c.rotateShip(v3, f);
		f.setLayout(null);
		f.setSize(500,500);
		f.setVisible(true);
	}*/
	
	private boolean shipRotation;
	private int squareNumber;
	private int squareSize;
	public static final boolean VERTICAL = false;
	public static final boolean HORIZONTAL = true;
	private Point originLocation;
	private Color rectColor = new Color(168, 218, 220, 200);
	private Color borderColor = new Color(29, 53, 87);
	private ClickListener click;
	private DragListener drag;
	private ReleaseListener release;
	
	/**
	 * Creates a <code>Ship</code>. 
	 * The default rotation of the ship is vertical = false == 1
	 * @param rotation can be 0 (horizontal) or 1 (vertical)
	 * @param squareNumber number of the square of a ship
	 * @param squareSize size of the square
	 * @param originLocation the original location
	 */
	public Ship(boolean rotation, int squareNumber, int squareSize, Point originLocation) {
		
		super(boolRotationToIntRotation(rotation));
		
		shipRotation = rotation;
		click = new ClickListener();
		drag = new DragListener();
		release = new ReleaseListener();
		this.squareNumber = squareNumber;
		this.squareSize = squareSize;
		this.originLocation = originLocation;
				
		for (int i = 0; i < squareNumber; i++) {
			Square square = new Square(rectColor, borderColor, squareSize);
			square.addMouseListener(click);
			square.addMouseMotionListener(drag);
			square.addMouseListener(release);
			this.add(square);
		}
	}
		
		
	/**
	 * Conversion that need to match true = 0 and false = 1 because in the BoxLayout
	 * 1 means the Y axis and 0 means the X axis.
	 * @param rotation true = horizontal or false = vertical
	 * @return 0 or 1
	 */
	public static int boolRotationToIntRotation(boolean rotation) {
		if (rotation == HORIZONTAL) {
			return 0;
		} else if (rotation == VERTICAL) {
			return 1;
		} else {
			return -1;
		}
	}
    /**
     * Returns the rotation of this component.
     *
     * @return the current rotation of this component
     */
	public boolean getRotation() {
		// TODO Auto-generated method stub
		return this.shipRotation;
	}
	
    /**
     * Sets the rotation of this component.
     * 
     * @param shipRotation can be true (horizontal) of false (vertical)
     */
	public void setRotation(boolean shipRotation) {
		this.shipRotation = shipRotation;
	}
	
	/**
	 * Returns the width of the ship based on the rotation
	 * @return the width of the ship
	 */
	public int getWidth() {
		
		if (shipRotation == Ship.HORIZONTAL) {
			return squareNumber*squareSize;
		} else {
			return squareSize;
		}
				
	}
	
	/**
	 * Returns the height of the ship based on the rotation
	 * @return the height of the ship
	 */
	public int getHeight() {
		
		if (shipRotation == Ship.HORIZONTAL) {
			return squareSize;
		} else {
			return squareNumber*squareSize;
		}
				
	}
	
	/**
	 * Returns the number of the square of the ship
	 * @return the number of the square of the ship
	 */
	public int getSquareNumber() {
		return squareNumber;
	}
	
	/**
	 * Returns the size of the square of the ships
	 * @return the size of the square of the ship
	 */
	public int getSquareSize() {
		return squareSize;
	}
	
	/**
	 * Returns the original location of the ship
	 * @return the original location of the ship
	 */
	public Point getOriginLocation() {
		return originLocation;
	}
	
	/**
	 * Sets the original location of the ship
	 * @param originLocation is the original location of the ship
	 */
	public void setOriginLocation(Point originLocation) {
		this.originLocation = originLocation;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Ship originLocation: " + originLocation + "\n" +
				"Ship squareNum: " + squareNumber + "\n" +
				"------------------------------------";
	}
	

	

	
	
	
	
	

}
