import java.io.DataInputStream;
import java.net.DatagramSocket;

public class ClientUDP {
	public static void main(String []args ) throws IOException{
		DatagramSocket ClientSocket = new DatagramSocket();
		System.out.println("Connected to server");
		
		DataInputStream inFromUser = new DataInputStream(System.in);
	}
	

}
