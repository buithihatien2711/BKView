package Server;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class panelRemote extends JPanel implements ActionListener {
	private JTextField txt_yourID;
	private static JTextField txtPinAllow;
	private JTextField txtPartId;
	private JTextField txtPinControl;
	private JButton btnConnect;
	private JButton btnStop;

	/**
	 * ham GUI
	 */
	public void GUI() {
		setBounds(0,0,836,570);
		setLayout(null);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 11, 402, 548);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Allow Remote Control");
		lblNewLabel.setBounds(46, 5, 309, 32);
		lblNewLabel.setForeground(new Color(147, 112, 219));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your ID :");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 76, 141, 46);
		panel.add(lblNewLabel_1);
		
		txt_yourID = new JTextField();
		txt_yourID.setBounds(66, 132, 309, 46);
		panel.add(txt_yourID);
		txt_yourID.setColumns(10);
		//
		//Lay ID cua may
		//
		txt_yourID.setText(InitConnection.getID());
		
		JLabel lblNewLabel_2 = new JLabel("PIN :");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 189, 72, 38);
		panel.add(lblNewLabel_2);
		
		txtPinAllow = new JTextField();
		txtPinAllow.setBounds(66, 238, 309, 46);
		panel.add(txtPinAllow);
		txtPinAllow.setColumns(10);
		//
		//Lay password
		//
		String password = InitConnection.createPassword();
		txtPinAllow.setText(password);
		
		btnStop = new JButton("Stop");
		//
		//Them actionListener cho stop
		//
		btnStop.addActionListener(this);
		btnStop.setFont(new Font("Verdana", Font.BOLD, 20));
		btnStop.setForeground(new Color(0, 0, 0));
		btnStop.setBounds(108, 438, 190, 46);
		panel.add(btnStop);
		
		JLabel lblNewLabel_3 = new JLabel("Active Connections");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(10, 364, 229, 46);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setLayout(null);
		panel_1.setBounds(422, 11, 402, 548);
		add(panel_1);
		
		JLabel lblControlRemoteCmuter = new JLabel("Control Remote PC");
		lblControlRemoteCmuter.setForeground(new Color(147, 112, 219));
		lblControlRemoteCmuter.setFont(new Font("Verdana", Font.BOLD, 25));
		lblControlRemoteCmuter.setBounds(60, 5, 267, 32);
		panel_1.add(lblControlRemoteCmuter);
		
		JLabel lblNewLabel_1_1 = new JLabel("Parter ID :");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 76, 141, 46);
		panel_1.add(lblNewLabel_1_1);
		
		txtPartId = new JTextField();
		txtPartId.setColumns(10);
		txtPartId.setBounds(66, 132, 309, 46);
		panel_1.add(txtPartId);
		
		JLabel lblNewLabel_2_1 = new JLabel("PIN :");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(10, 189, 72, 38);
		panel_1.add(lblNewLabel_2_1);
		
		txtPinControl = new JTextField();
		txtPinControl.setColumns(10);
		txtPinControl.setBounds(66, 238, 309, 46);
		panel_1.add(txtPinControl);
		
		btnConnect = new JButton("Connect");
		btnConnect.setForeground(Color.BLACK);
		btnConnect.setFont(new Font("Verdana", Font.BOLD, 20));
		btnConnect.setBounds(108, 438, 190, 46);
		panel_1.add(btnConnect);
		//
		//Them ham show();
		//
		show();
		
	}
	
	//
	//lay password cua may
	//
	public static String getPassword() {
		return txtPinAllow.getText();
	}
	//
	//ham actionPerform
	//
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStop) {
		}
	}
	//
	//Ham dung
	//
	public panelRemote() {
		// TODO Auto-generated constructor stub
		super();
		GUI();
	}
}
