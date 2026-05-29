import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Client {
	
	private static String localhost = "127.0.0.1";
	
    public static void main(String[] args) throws IOException {
    	Socket socket = null;
    	
    	
    	
    	socket = new Socket(localhost, Server.PORT);
    	
    	
    	InputStreamReader inputReader = null;
    	OutputStreamWriter outputWriter = null;
    	BufferedReader bufferedReader = null;
    	
    	
    	
    	String userInput;
    	
    	while ((userInput = stdIn.readLine()) != null) {
    		out.println(userInput);
    	}
    	
    	
    	socket.close();
    	
    	

    	 	
    }

    
}
