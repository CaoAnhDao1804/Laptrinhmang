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
import java.net.ServerSocket;
import java.net.Socket;

public class BT3Server extends Frame implements ActionListener {
Label title;
Label lbTen;
Button btnSend;
TextField txtNoidung;
TextArea txtChuoiHT;
Panel pn1,pn2,pn0;
String chuoiHT= "";
static ServerSocket serverSocket;
static Socket socket;
static DataInputStream din;
static DataOutputStream dos;


public   void loadUI() {
	title = new Label("Chuong trinh chat room hoat dong giao thuc TCP");
	lbTen = new Label("Server: ");
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

public BT3Server(String str) {
	super();
	loadUI();
}
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == btnSend) {
		String serverStr = txtNoidung.getText().toString();
		serverStr = "Server: " + serverStr;
		txtNoidung.setText("");
		try {
			dos.writeUTF(serverStr);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtChuoiHT.append(serverStr);
		txtChuoiHT.append("\n");
	}
}

public static void main(String[] args ) throws Exception {
	BT3Server serverUI = new BT3Server("Server");
	serverSocket = new ServerSocket(1234);
	socket = serverSocket.accept();
	din = new DataInputStream(socket.getInputStream());
	dos = new DataOutputStream(socket.getOutputStream());
	while(true) {
		String str= din.readUTF();
		serverUI.txtChuoiHT.append(str);
		serverUI.txtChuoiHT.append("\n");

		if (str.compareTo("exit")==0) {
			socket.close();
			break;
			
		}
	}
	
	
}

}