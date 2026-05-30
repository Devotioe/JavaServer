import java.io.*;
import java.net.*;


public class MultithreadServer {
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 9527;
	
	private static class ClientHandler implements Runnable{
		private Socket socket;
		
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				
				//GET CLIENT INPUT
				BufferedReader clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); //buffer reader to get 
				String clientInput = clientReader.readLine(); //blocking method ; wait for buffer to have content to read
				System.out.println("Client sent: " + clientInput);
				//GET CLIENT INPUT
				
				//ECHO
				PrintWriter msgSender = new PrintWriter(socket.getOutputStream(), true); //
				msgSender.println(clientInput);
				System.out.println("Echoing back to the client...");
				//ECHO
				
			}catch(IOException e) {
				System.out.println("IO Exception: " + e.getMessage());
			}catch(Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}		
		}		
	}
	
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
		try{
			serverSocket = new ServerSocket();
			System.out.println("Waiting for client to connect...");
			
			serverSocket.bind(new InetSocketAddress(HOST, PORT)); //bind process to IP address, enabling client to send package
			System.out.println("Server binded to " + HOST + ":" + PORT);
			
			while(true) {
				clientSocket = serverSocket.accept(); //blocking method ; waiting for client to connect
				
				
				ClientHandler clientHandler = new ClientHandler(clientSocket);
				Thread clientThread = new Thread(clientHandler);
				clientThread.start();
				
				System.out.println("A client connected to server, IP: " + clientSocket.getInetAddress());
			}
			
		}catch(Exception e){
			
		}

	}
	

}
