import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String []args ) throws Exception  {
		Socket socket = new Socket("localhost",1236);
		DataInputStream dataInputStream= new DataInputStream(socket.getInputStream());
		DataOutputStream  dataOutputStream= new DataOutputStream(socket.getOutputStream());
		
		Scanner scanner= new Scanner(System.in);
		
		while(true) {
			System.out.println("Client: ");
			String msgOUt= scanner.nextLine();
			dataOutputStream.writeUTF("Client:" +msgOUt);
			
			String msgIn = dataInputStream.readUTF();
			System.out.println(msgIn);
			if(msgIn.equals("exit")) break;
		}
		
		
	}

}
