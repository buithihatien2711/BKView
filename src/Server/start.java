package Server;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;

public class start extends JFrame {

	private JPanel contentPane;
	private static panelRemote panelRemote;
	private panelChat panelChat;
	//
	//Doi lai ham main
	//
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					start frame = new start();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		start frame = new start();
		frame.setVisible(true);
		new InitConnection(panelRemote.getPassword());
	}

	/**
	 * Create the frame.
	 */
	public start() {
		
		panelRemote = new panelRemote();
		panelChat = new panelChat();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1188, 629);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Menu = new JPanel();
		panel_Menu.setBackground(new Color(192, 192, 192));
		panel_Menu.setBounds(10, 11, 306, 570);
		contentPane.add(panel_Menu);
		panel_Menu.setLayout(null);
		
		JPanel panel_Remote = new JPanel();
		panel_Remote.addMouseListener(new PanelButtonMouseAdapter(panel_Remote)
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelRemote);
			}
		});
		panel_Remote.setBackground(new Color(192, 192, 192));
		panel_Remote.setBounds(0, 134, 306, 93);
		panel_Menu.add(panel_Remote);
		panel_Remote.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remote Control");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(100, 11, 206, 71);
		panel_Remote.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(123, 104, 238));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 11, 73, 71);
		panel_Remote.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(123, 104, 238));
		lblNewLabel_1.setIcon(new ImageIcon(start.class.getResource("/icon/iconRemote.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 306, 134);
		panel_Menu.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("BKViewer");
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(150, 26, 156, 69);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(start.class.getResource("/icon/logo.png")));
		lblNewLabel_3.setBounds(11, 11, 129, 95);
		panel.add(lblNewLabel_3);
		
		JPanel panel_Chat = new JPanel();
		panel_Chat.addMouseListener(new PanelButtonMouseAdapter(panel_Chat)
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelChat);
			}
		});
		panel_Chat.setBackground(new Color(192, 192, 192));
		panel_Chat.setLayout(null);
		panel_Chat.setBounds(0, 224, 306, 93);
		panel_Menu.add(panel_Chat);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setForeground(new Color(123, 104, 238));
		lblChat.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblChat.setBackground(Color.WHITE);
		lblChat.setBounds(100, 11, 206, 71);
		panel_Chat.add(lblChat);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(start.class.getResource("/icon/iconChat.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(123, 104, 238));
		lblNewLabel_1_1.setBounds(10, 11, 73, 71);
		panel_Chat.add(lblNewLabel_1_1);
		
		JPanel panel_Main = new JPanel();
		panel_Main.setBounds(328, 11, 836, 570);
		contentPane.add(panel_Main);
		panel_Main.setLayout(null);
		
		panel_Main.add(panelRemote);
		panel_Main.add(panelChat);
		
		panelRemote.setVisible(true);
		
		//new InitConnection(panelRemote.getPassword());
	}
	
	public void menuClicked(JPanel panel) {
		panelRemote.setVisible(false);
		panelChat.setVisible(false);
		panel.setVisible(true);
		
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(255, 255, 255));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(192,192,192));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(105,105,105));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(192,192,192));
		}
	}
}
