import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class OperatorClient {

    public void go(){ 
        try { 
            Socket client = null; 
            DataOutputStream out_put = null; 
            DataInputStream in_put = null; 
             
            while(true){ 
                client = new Socket("localhost",2011); 
                out_put = new DataOutputStream(client.getOutputStream()); 
                in_put = new DataInputStream(client.getInputStream()); 
                // nhap du lieu tu ban phim     
                Scanner sc = new Scanner(System.in); 
                String data_out = sc.nextLine(); 
                 
                // xuat du lieu     
                out_put.writeUTF(data_out); 
                 
                // kiem tra thoat 
                if((data_out.toUpperCase()).compareTo("QUIT")==0) { 
                    client.close(); 
                    break; 
                } 
                 
                // xuat du lieu 
                System.out.println(in_put.readUTF()); 
                 
                client.close(); 
            } 
     
        } catch (UnknownHostException e) { 
            e.printStackTrace(); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
    } 
    public static void main(String[] args) { 
        new OperatorClient().go(); 
    } 
}
