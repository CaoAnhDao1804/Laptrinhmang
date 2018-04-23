import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OperatorServer {

    public static void main(String[] args) { 
        new OperatorServer().go(); 
    } 

	public void in(String[] data, int len) {
		for (int i=0; i<len;i++) {
			System.out.println(data[i]);
		}
		System.out.println();
	}
	
	public String[] xoa(String[] data, int vitri) {
		for (int i= vitri +2; i<data.length;i++) {
			data[i-2] = data[i];
		}
		return data;
	}
	
	public String tinh(float so1, float so2, int dau) {
		float so=0;
		switch (dau) {
		case 1:
			so = so1+so2;
			break;
		case 2:
			so = so1-so2;
			break;
		case 3:
			so = so1*so2;
			break;
		case 4:
			so = so1/so2;
			break;
		}
		return Float.toString(so);
	}
	
	public String xuly(String in) {
		String[] temp = in.split(" ");
		int len = temp.length;
		
		int i=1;
		while(i<len-1) {
			if(temp[i].compareTo("*")==0) {
				temp[i-1]= tinh(Float.parseFloat(temp[i-1]), Float.parseFloat(temp[i+1]),3);
				temp= xoa(temp, i);
				
				i=1;
				len-=2;
			} 
			else if (temp[i].compareTo("/")==0){
				temp[i-1]= tinh(Float.parseFloat(temp[i-1]), Float.parseFloat(temp[i+1]),4);
				temp= xoa(temp, i);
				
				i=1;
				len-=2;
				
			} else i+=2;
			 i=1; 
		        while(i<len -1){ 
		            if(temp[i].compareTo("+")==0){ 
		                temp[i-1]=tinh(Float.parseFloat(temp[i-1]),Float.parseFloat(temp[i+1]),1); 
		                temp=xoa(temp,i); 
		                i=1;len-=2; 
		            }else if(temp[i].compareTo("-")==0){ 
		                temp[i-1]=tinh(Float.parseFloat(temp[i-1]),Float.parseFloat(temp[i+1]),2); 
		                temp=xoa(temp,i); 
		                i=1;len-=2; 
		            }else i+=2; 
		        } 
		        
		}
		return "Ket qua : "+temp[0]; 
	}

public void go(){ 
		        try { 
		            ServerSocket server = new ServerSocket(2011); 
		            System.out.println("Bat dau chay server"); 
		             
		            DataInputStream in_put=null; 
		            DataOutputStream out_put=null; 
		             
		            while(true){ 
		                // chap nhan ket noi 
		                Socket client = server.accept();         
		                in_put = new DataInputStream(client.getInputStream()); 
		                out_put = new DataOutputStream(client.getOutputStream()); 
		                 
		                // lay du lieu 
		                String data_in = in_put.readUTF(); 
		                 
		                // kiem tra dieu kien thoat 
		                if((data_in.toUpperCase()).compareTo("QUIT")==0) { 
		                    client.close(); 
		                    continue; 
		                } 
		                 
		                // xuat du lieu 
		                out_put.writeUTF(xuly(data_in)); 
		                client.close(); 
		            } 
		        } catch (IOException e) { 
		            System.out.println("Loi tao socket Server"); 
		        } 
		    } 

}