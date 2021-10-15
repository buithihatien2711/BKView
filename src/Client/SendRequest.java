package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendRequest {
	public int port = 7700;
	
	public boolean isConnected(String ip, String password) {
		boolean result = false;
		// TODO Auto-generated constructor stub
		try {
			Socket socket = new Socket(ip, port);
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			
			dataOutputStream.writeUTF(password);
			result = dataInputStream.readBoolean();
			

			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
