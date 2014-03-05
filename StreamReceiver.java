import java.io.*;
import java.net.*;
import java.util.ArrayList;





public class StreamReceiver extends Thread {
	
	private ArrayList<StreamElement> elements;
	ServerSocket serverSocket;
	Socket clientSocket;
	ObjectInputStream in_from_Client;

	public StreamReceiver (int port) throws IOException { 
    	//... create ObjectInputStream and bind it to a certain port... 
    	serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();     
    	in_from_Client = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));

    }
   
      
    public void run() {
        while(true) {
        	try {
				elements = (ArrayList<StreamElement>) in_from_Client.readObject();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	int n = elements.size();
            for(int i = 0; i < n ; i++)
            	System.out.println( elements.get( i ).getTimestamp() + " : " + elements.get( i ).getSeq());
            	            
        }
    }
}
