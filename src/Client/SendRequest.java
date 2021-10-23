package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.cert.CertPathValidatorException.BasicReason;

public class SendRequest {
	public int port = 7700;
	Socket socket = null;
	
	public boolean isConnected(Socket socket, String password) {
		boolean result = false;
		this.socket = socket;
		// TODO Auto-generated constructor stub
		try {
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
