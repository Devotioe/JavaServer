import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MultithreadClient {
	
	
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 9527;
	
	
	public static void main(String[] args) {
		
		Socket socket = null;
		String userInput = "";

		
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
//		
//		
//		System.out.println(str);
		
		try {
			
			socket = new Socket(HOST, PORT);

			
			while (!userInput.equalsIgnoreCase("exit")) {
				
			
				BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)); //get user's input into buffer
				
				
				userInput = inputReader.readLine(); //make buffer string into a string object
				
	//			String userInput = new BufferedReader(new InputStreamReader(System.in)).readLine();
				
	//			String userInput = new Scanner (System.in).nextLine(); 
				
				PrintWriter msgSender = new PrintWriter(socket.getOutputStream(), true); //
				
				msgSender.println(userInput); //send userinput to server
				
				
				if (userInput.equalsIgnoreCase("exit")) {
					System.out.println("Closing Connection...");
					socket.close();
					break;
				}
				
				System.out.println("You sent: " + userInput);
				BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("Server echoed: " + serverReader.readLine());
			
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
	}

}
