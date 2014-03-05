import java.io.*;
import java.net.*;
import java.util.ArrayList;





public class StreamReceiver extends Thread {
	
	public StreamReceiver(){}
	
	public void openSocket (int port) throws IOException { 
    	//... create ObjectInputStream and bind it to a certain port... 
    	try( 
    			ServerSocket serverSocket = new ServerSocket(port);
    			Socket clientSocket = serverSocket.accept();     
    			ObjectInputStream in_from_Client = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
 	)
	{
    		    System.out.println("Reciever listening...");
        		StreamElement elements = new StreamElement();
        		
            	try {
    				elements = (StreamElement) in_from_Client.readObject();
    				
            	} catch (ClassNotFoundException | IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	
                System.out.println( "Timestamp -> " + elements.getTimestamp() + " : Sequence# -> " + elements.getSeq());
                	            
            
    		
	}catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + port + " or listening for a connection");
            System.out.println(e.getMessage());
        }
	
    }
   
}
   
    
    

