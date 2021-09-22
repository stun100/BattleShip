import javax.swing.JOptionPane;

/**
 * The {@code PopupMessage} class generates a pop-up message.
 * @author Daniele Bae
 *
 */
public class PopupMessage
{

	/**
	 * Generate a pop-up message.
	 * @param infoMessage content of the message
	 * @param titleBar title for the message
	 */
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}