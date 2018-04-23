package BTH1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BT1Server {
	public static void main(String []args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(1241);
		System.out.println("Server is started");
		System.out.println("Chờ nhận chuỗi từ Client!");
		Socket socket = serverSocket.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		
		Scanner kb = new Scanner(System.in);
		
		while(true) {
			
			String st= din.readUTF();
			System.out.println(st);
			try {
				if(st.compareTo("quit")==0) {
					System.out.println("Nhan duoc lenh quit tu client");
					socket.close();
					break;
					
				}
			} catch (EOFException e) {
				System.out.println("Da ngat ket noi");
			}
			StringCustom custom = new StringCustom();
			String chuoiHoa = custom.doiHoa(st);
			System.out.println("Server se tra ve chuoi Hoa");
			dos.writeUTF("Chuoi hoa cua chuoi da cho: "+ chuoiHoa);
			
			String chuoiThuong = custom.doiThuong(st);
			System.out.println("Server se tra ve chuoi thuong");
			dos.writeUTF("Chuoi thuong cua chuoi da cho:"+chuoiThuong);
			
			int sotu = custom.demTu(st);
			System.out.println("Server se tra ve so tu cua chuoi da nhap");
			dos.writeUTF("Chuoi da cho co "+ sotu+"tu" );
			dos.flush();
			kb= kb.reset();
		}
		
		
}
}