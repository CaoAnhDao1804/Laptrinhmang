import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
	public static void main(String []args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(1234);
		System.out.println("Server is started");
		Socket socket = serverSocket.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			
			String st= din.readUTF();
			System.out.println(st);
			
			if (st.compareTo("exit")==0) {
				
				socket.close();
				break;
			}
			System.out.println("Server:");
			String msg = kb.nextLine();
			dos.writeUTF("Server:"+msg);
			dos.flush();
			kb= kb.reset();
		}
		
		
		
	}


}
