package Server;

import java.awt.Rectangle;
import java.awt.Robot;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.GZIPOutputStream;

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
//		try {
//			outputStream = socket.getOutputStream();
//			while (true) {
//				BufferedImage image =  robot.createScreenCapture(rectangle);
//				ImageIO.write(image, "jpeg", outputStream);
//				Thread.sleep(10);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		try {
			outputStream = socket.getOutputStream();
			FileInputStream fis = null;
			FileOutputStream fos = null;
			GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
			
			//Take a screenshot
			BufferedImage bufferedImage =  robot.createScreenCapture(rectangle);
			
			//Convert a BufferImage to a byte array
			ByteArrayOutputStream boas = new ByteArrayOutputStream();
			ImageIO.write(bufferedImage, "jpg", boas);
			byte[] bytes = boas.toByteArray();
			
			//Convert a BufferedImage to InputStream
			InputStream is = new ByteArrayInputStream(boas.toByteArray());
			
			
			//Compress image
			byte[] buffer = new byte[1024*1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				gzipOS.write(buffer, 0, len);
			}
			
			//Send byte array
			outputStream.write(buffer);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			byte[] buffer = new byte[1024];
//			
//			int bytes_read;
//			int len;
//            
//            while ((len = fis.read(buffer)) != -1) {
//                gzip.write(buffer, 0, bytes_read);
//            }
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
