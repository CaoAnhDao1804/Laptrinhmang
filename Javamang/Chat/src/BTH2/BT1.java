package BTH2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import BTH1.StringCustom;

public class BT1 {
	public static void main(String []args) throws Exception{
		DatagramSocket serverSocket = new DatagramSocket(8000);
		System.out.println("Server is started!");
		byte[] receiveData= new byte[12222];
		byte[] sendData = new byte[650000];
		
		while(true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String chuoikytu = new String(receivePacket.getData());
			System.out.println(chuoikytu);
			StringCustom custom = new StringCustom();
			
			String chuoiHoa = custom.doiHoa(chuoikytu);
			String chuoiThuong = custom.doiThuong(chuoikytu);
			int demtu = custom.demTu(chuoikytu);
			String demtuStr = String.valueOf(demtu);
			 
			
			String receive = "Chuoi thuong:"+chuoiThuong+"\n"+"Chuoi hoa:"+chuoiHoa+"\n"+"So tu:"+demtuStr;
			System.out.println(receive);
			sendData= receive.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port);
			System.out.println(sendData.length);
			serverSocket.send(sendPacket);
						
			
		}
}
}
