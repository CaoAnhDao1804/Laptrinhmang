package BTH1;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BT3Client extends Frame implements ActionListener {
	Label title;
	Label lbTen;
	Button btnSend;
	TextField txtNoidung;
	TextArea txtChuoiHT;
	Panel pn1,pn2,pn0;
	String chuoiHT= "";
	static Socket socket;
    static DataInputStream dataInputStream;
	static DataOutputStream  dataOutputStream;


	public   void loadUI() {
		title = new Label("Chuong trinh chat room hoat dong giao thuc TCP");
		lbTen = new Label("Client");
		btnSend = new Button("Send");
		btnSend.addActionListener(this);
		txtNoidung = new TextField("");
		txtChuoiHT = new TextArea();
		
		txtNoidung.setColumns(20);
		pn0 = new Panel(new GridLayout(1, 2));
		pn1 = new Panel(new FlowLayout());
		pn1.add(title);
		pn1.add(lbTen);
		pn1.add(txtNoidung);
		pn1.add(btnSend);
		pn0.add(pn1);
		pn0.add(txtChuoiHT);
		add(pn0);
		setSize(400, 400);
		setVisible(true);
		addWindowListener(	
				new WindowAdapter(){
				public void windowClosing(WindowEvent we){
					System.exit(0);
				}
			});

		
	}
	public void actionPerformed(ActionEvent i) {
		if (i.getSource()== btnSend) {
			String clientSt = txtNoidung.getText().toString();
			clientSt = "Client:"+clientSt;
			System.out.println(clientSt);
			txtNoidung.setText("");
			try {
				dataOutputStream.writeUTF(clientSt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		txtChuoiHT.append(clientSt);
		txtChuoiHT.append("\n");
			
						
		}
		
	}
	
	public BT3Client(String str) {
		super();
		loadUI();
	}
	
	 public static void main(String[] args) throws Exception {
		 
		 BT3Client clientUI = new BT3Client("Client");
		  socket = new Socket("localhost",1234);
	      dataInputStream= new DataInputStream(socket.getInputStream());
		  dataOutputStream= new DataOutputStream(socket.getOutputStream());
		 
		    
			
			while(true) {	
				
				String msgIn = dataInputStream.readUTF();
				clientUI.txtChuoiHT.append(msgIn);
				clientUI.txtChuoiHT.append("\n");
				
				System.out.println(msgIn);
				if(msgIn.equals("exit")) break;
				
				
			}
			
		 
	 }
	 
	 
}
