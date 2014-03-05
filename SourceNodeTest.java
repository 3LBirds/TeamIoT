import java.io.IOException;


public class SourceNodeTest {
	public static void main(String[] args) throws IOException {
	
		
		StreamElement ele = new StreamElement(2208,1,"TestSourceNode".getBytes());
		System.out.println("Element filled...");
		StreamSender client = new StreamSender("localhost",2014);
		System.out.println("Client connected...");
	    client.pushElement(ele);
	    System.out.println("Element in queue....");
	    client.run();
	    System.out.println("Element transmitted...");
	    client.closeSocket();
	
		
		
		
		
	}
	

}
