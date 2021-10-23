package Server;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import javax.swing.*;

public class InitConnection {
	private static int lengthPassword = 8;
	public static int port = 7700;
	static ServerSocket serverSocket;
	static Socket socket;
	
	public InitConnection(String pass) {
//		// TODO Auto-generated constructor stub
//		try {
//			serverSocket = new ServerSocket(port);
//			while (true) {
//				socket = serverSocket.accept();
//				
//				//password do client gui toi
//				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//				
//				String passClient = dataInputStream.readUTF();
//				
//				//password cua server la pass
//				
//				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//				
//				if(passClient.equals(pass)) {
//					dataOutputStream.writeBoolean(true);;
//				}
//				else {
//					dataOutputStream.writeBoolean(false);
//				}
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Robot robot = null;
		Rectangle rectangle = null;
		try{
			System.out.println("Awaiting Connection from Client");
			serverSocket=new ServerSocket(port);
			
			GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
	
			Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
			String width=""+dim.getWidth();
			String height=""+dim.getHeight();
			rectangle=new Rectangle(dim);
			robot=new Robot(gDev);

			//drawGUI();

			while(true){
				socket=serverSocket.accept();
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				String passClient = dataInputStream.readUTF();
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				//String username=password.readUTF();
				//String pssword=password.readUTF();
				
				if(passClient.equals(pass)) {
					dataOutputStream.writeBoolean(true);
					new SendScreen(socket, robot, rectangle);
					
				}
				else {
					dataOutputStream.writeBoolean(false);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getID() {
		String ip = "";
		try {
			ip = (InetAddress.getLocalHost()).getHostAddress();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ip;
	}
	
	public static String createPassword() {
	    final String alpha = "abcdefghijklmnopqrstuvwxyz"; 
	    final String alphaUpperCase = alpha.toUpperCase();
	    final String digits = "0123456789"; 
	    final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
	    
	    StringBuilder pass = new StringBuilder();
	    Random generator = new Random();
	    
	    for(int i = 0; i<lengthPassword; i++) {
	    	//random vi tri cua ki tu
	    	int number = generator.nextInt(ALPHA_NUMERIC.length());
	    	pass.append(ALPHA_NUMERIC.charAt(number));
	    }
	    
	    return pass.toString();
	}
	
	public static void updatePassword(String password) {
		//password do client gui toi
		DataInputStream dataInputStream;
		try {
			dataInputStream = new DataInputStream(socket.getInputStream());
			String passClient = dataInputStream.readUTF();
			
			//password cua server la pass
			
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			if(passClient.equals(password)) {
				dataOutputStream.writeBoolean(true);;
			}
			else {
				dataOutputStream.writeBoolean(false);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnect() {
		try {
			serverSocket.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
