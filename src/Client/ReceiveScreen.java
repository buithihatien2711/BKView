package Client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.awt.Image;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ReceiveScreen extends Thread{

	InputStream inputStream = null;
	Image image = null;
	JPanel jPanel = null;
	
	public ReceiveScreen(InputStream in, JPanel p) {
		// TODO Auto-generated constructor stub
		inputStream = in;
		jPanel = p;
		start();
	}
	
	
	@Override
	public void run() {
		try {
			while (true) {
				byte[] bytes = new byte[1024*1024];
				int count = 0;
				count += inputStream.read(bytes, count, bytes.length - count);
				
				//Ket thuc cua luong hinh anh la 0xFFD9 
				do {
					count += inputStream.read(bytes, count, bytes.length - count);
				} while (!(count > 4  && bytes[count-2]==(byte)-1 && bytes[count-1]==(byte)-39 ));
				
				image = ImageIO.read(new ByteArrayInputStream(bytes));
				image = image.getScaledInstance(jPanel.getWidth(), jPanel.getHeight(), Image.SCALE_FAST);
				
				Graphics graphics = jPanel.getGraphics();
				graphics.drawImage(image, 0, 0 , jPanel.getWidth(), jPanel.getHeight(), jPanel);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
