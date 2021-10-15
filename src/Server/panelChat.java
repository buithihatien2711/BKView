package Server;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class panelChat extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelChat() {
		setBounds(0,0,836,570);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Chat");
		lblNewLabel.setBounds(334, 216, 81, 49);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblNewLabel);
	}

}
