import java.io.*;
import java.net.*;
import java.util.*;


public class StreamSender extends Thread{
	
	  private Queue<StreamElement> sendQueue = new LinkedList<StreamElement>();
	  private Socket clientSocket;
	  private ObjectOutputStream out_to_Server;
	  
	  public StreamSender (String ipAddr, int port) throws UnknownHostException, IOException {
	        //... connect to a StreamReceiver with given address and port ...
	        //... initialize sendBuffer ...
		  clientSocket = new Socket(ipAddr, port);
		  out_to_Server = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
  
	  }

	public void closeSocket() throws IOException
	{
		out_to_Server.close();
		clientSocket.close();
	}
	
	public void run(){
		
			try {
			
				ArrayList<StreamElement> elements = popElements(); // this may block if nothing is in sendQueue
				int n = elements.size();
                for(int i = 0; i < n ; i++)
                	{
                	   
                	    out_to_Server.writeObject(elements.get( i ));
                	}

				//out_to_Server.writeObject(elements);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	public synchronized void pushElement(StreamElement elem) {
		System.out.println( elem.getTimestamp() + " : " + elem.getSeq());

        sendQueue.add(elem);
        notifyAll();  // Wake up this thread
    }
	
	private synchronized ArrayList<StreamElement> popElements() {
	    	if(sendQueue.isEmpty()){
				try {
					wait();  // If nothing is in the queue, sleep this thread
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  	
	    	}
	    	System.out.println("Queue is not empty...");
	    	ArrayList<StreamElement> ret = new ArrayList<StreamElement>();	
	    	while(!sendQueue.isEmpty())
	    	{
	    		ret.add(sendQueue.remove());
	    	}
	    	return ret;
	}

	

}
