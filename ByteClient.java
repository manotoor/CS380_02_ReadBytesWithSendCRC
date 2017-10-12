public class ByteClient{
	public static void main(String[] args){
		try(Socket socket = new Socket("18.221.102.182",38102)){
			System.out.println("Connected to " socket.)
			InputStream is = socket.getInputStream();

		}
	}
}