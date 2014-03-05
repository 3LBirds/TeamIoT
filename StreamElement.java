
public class StreamElement implements java.io.Serializable {

	 private long timestamp; // unix timestamp
	 private long seq; // sequence number
	 private byte[] data; // this is the user data
	 
	 public StreamElement(){
		 
	 }
	 
	 public StreamElement( long timestamp, long seq, byte[] data)
	 {
		 this.timestamp = timestamp;
		 this.seq = seq;
		 this.data = data;
	 }
	 
	 public long getTimestamp()
	 {
		 return timestamp;
	 }
	 
	 public long getSeq()
	 {
		 return seq;
	 }
	 
	 public byte[] getData()
	 {
		 return data;
	 }
	 
	 


}
