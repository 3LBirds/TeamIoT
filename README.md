TeamIoT
=======
1. Save EchoServer.java and EchoClient.java to location 
2. Compile Echo*
  javac EchoServer.java EchoClient.java

In Command Prompt/Terminal
3. Execute EchoServer before executin EchoClient
   
   java EchoServer <port number> //Example: java EchoServer 2014

4. Open another terminal window, and then execute EchoClient

  java EchoClient localhost <port number> //Example: java EchoClient localhost 2014
  
Result:
After EchoClient opens a socket with EchoServer, it writes an object to EchoServer. Once EchoServer recieves the object, it outputs the details of the object via standard output (System.out):

Example output:

On Tuesday, March 4, 2014:
You ordered 12 units of Java T-shirt at $19.99
You ordered 8 units of Java Mug at $9.99
You ordered 13 units of Duke Juggling Dolls at $15.99
You ordered 29 units of Java Pin at $3.99
You ordered 50 units of Java Key Chain at $4.99
For a TOTAL of: $892.88
