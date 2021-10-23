package Server;

import java.awt.Rectangle;
import java.awt.Robot;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SendScreen extends Thread{
	Socket socket = null;
	OutputStream outputStream = null;
	Robot robot = null;
	Rectangle rectangle = null;
	
	public SendScreen(Socket socket, Robot robot, Rectangle rectangle) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.robot = robot;
		this.rectangle = rectangle;
		start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			outputStream = socket.getOutputStream();
			while (true) {
				BufferedImage image =  robot.createScreenCapture(rectangle);
				ImageIO.write(image, "jpeg", outputStream);
				Thread.sleep(10);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
