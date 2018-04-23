import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChuyenChuoi {
	public static void main(String []args ) throws Exception  {
		Socket socket = new Socket("localhost",1241);
		DataInputStream dataInputStream= new DataInputStream(socket.getInputStream());
		DataOutputStream  dataOutputStream= new DataOutputStream(socket.getOutputStream());
		
		Scanner scanner= new Scanner(System.in);
		
		while(true) {
			System.out.println("Client: ");
			String msgOUt= scanner.nextLine();
			
//			if(msgOUt.compareTo("quit")==0) {
//				socket.close();
//				break;
//			}
			dataOutputStream.writeUTF(msgOUt);
			
			String msgIn = dataInputStream.readUTF();
			System.out.println(msgIn);
			String msg2 = dataInputStream.readUTF();
			System.out.println(msg2);
			String msg3 = dataInputStream.readUTF();
			System.out.println(msg3);
			if(msgIn.equals("exit")) break;
		}
		
		
	}

}
