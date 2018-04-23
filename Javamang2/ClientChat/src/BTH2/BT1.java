package BTH2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class BT1 {
	public static void main(String []args) throws Exception {
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[25000];
		byte[] receiveData = new byte[65000];
		Scanner scaner = new Scanner(System.in);
		
		
			System.out.println("Nhap vao chuoi can xu ly:");
			String msgIn = scaner.nextLine();
			if (msgIn.compareTo("quit")==0) {
				clientSocket.close();
			
			}
			sendData = msgIn.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,8000);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		
		String msgOUT= new String(receivePacket.getData());
		System.out.println(msgOUT);
		
	}

}
