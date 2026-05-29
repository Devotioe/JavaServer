import java.io.*;
import java.net.*;

public class Server {
	
	protected static final int PORT = 5987; 
	
    public static void main(String[] args) throws IOException {
 
    	ServerSocket serverSocket = null;
    	//BufferedReader buf = new BufferedReader();
    	
    	
    	
        try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server listening on PORT " + PORT);
			
			while(true) {
				 Socket clientSocket = serverSocket.accept(); //blocking method, only continue when accepted client's socket
				 System.out.println("Client connected to server");
				 
				 
				 
			}
			
			
			
			} catch (IOException e) {
			
			e.printStackTrace();
		}
        
        
        
        
       
        
    
    }
}