import java.io.*;
import java.net.*;


public class MyServer {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 9527;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		try{
			serverSocket = new ServerSocket();
			System.out.println("Waiting for client to connect...");
			
			serverSocket.bind(new InetSocketAddress(HOST, PORT)); //bind process to IP address, enabling client to send package
			System.out.println("Server binded to " + HOST + ":" + PORT);
			
			//while(true) {
			clientSocket = serverSocket.accept(); //blocking method ; waiting for client to connect
			System.out.println("Client connected to server");
			//}
			
			BufferedReader clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //buffer reader to get 
			String clientInput = clientReader.readLine(); //blocking method ; wait for buffer to have content to read
			
			System.out.println("Client sent: " + clientInput);
			
			PrintWriter msgSender = new PrintWriter(clientSocket.getOutputStream(), true); //
			msgSender.println(clientInput);
			System.out.println("Echoing back to the client...");
			
			
			serverSocket.close();
			System.out.println("Server closing...");
			
			
			
			
		}catch(Exception e){
			
		}
		
		
		
	}
}
