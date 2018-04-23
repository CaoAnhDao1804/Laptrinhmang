package BTH2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class BT3Client {
	public static void main(String []args) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[25000];
		byte[] receiveData = new byte[25000];
		Scanner scaner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Client: ");
			String msg= scaner.nextLine();
			msg = "Client"+ msg;
			sendData = msg.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,8000);
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.receive(receivePacket);
			String msgServer = new String(receivePacket.getData());
			System.out.println(msgServer);
		}
	
	}

}
