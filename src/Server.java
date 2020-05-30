import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	Socket s;
	ServerSocket server;
	DataInputStream dis;

	public Server(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server started!");
			System.out.println("Waiting for client...");
			s = server.accept();
			System.out.println("Client accepted");
			dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
			String harf="";
			int a=0;
			while (a!=-1) {
				a = dis.read();
				System.out.println(a);
				byte[] b = {(byte)a};	//byte i harfe cevirip ekrana yaziyor. input q olunca cikiyor.
				harf = new String(b);
				if (a==113) {
					break;
				}
				System.out.println(harf);
			}

			System.out.println("Closing connection ... ");
			s.close();
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server server = new Server(8000);
	}
}
/*
import socket

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect((socket.gethostname(), 8000))
#bu iki satiri en basa ekle

msg = input()
s.send(bytes(msg, "utf-8"))
#bunlari while dongusunun sonuna ekle


  
 
  
  */
 